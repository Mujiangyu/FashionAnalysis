package dao.daoImpl;

import dao.HBaseDao;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IOUtils;
import utils.ConfUtils;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/14 21:42
 * #Describe:
 */
public class HBaseDaoImpl implements HBaseDao {
    private static Connection conn;
    private static Admin admin;

    static {
        try {
            Configuration conf = new Configuration();
            HBaseConfiguration.addHbaseResources(conf);
            conf.set("hbase.zookeeper.quorum", ConfUtils.getCoreConf("ZOOKEEPER_QUORUMS"));
            conf.set("fs.defaultFS",ConfUtils.getCoreConf("HADOOP_FS_URI"));
            //conf.set("hbase.zookeeper.property.clientPort", "2181");
            //conf.set("zookeeper.znode.parent","/hbase" );
            System.setProperty("HADOOP_USER_NAME", ConfUtils.getCoreConf("HADOOP_USER_NAME"));

            conn = ConnectionFactory.createConnection(conf);
            admin = conn.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getHBaseConnection() {
        return conn;
    }

    @Override
    public void createNameSpace(String name) throws IOException {
            NamespaceDescriptor descriptor = NamespaceDescriptor.create(name).build();
            admin.createNamespace(descriptor);
    }

    @Override
    public void createTable(String tableName, String... columnFamily) throws IOException {
        if (!isTableExists(tableName)) {
            TableDescriptorBuilder descriptorBuilder = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName));
            for (String cf : columnFamily)
                descriptorBuilder.setColumnFamily(ColumnFamilyDescriptorBuilder.of(cf));
            TableDescriptor descriptor = descriptorBuilder.build();
            admin.createTable(descriptor);
        }
    }

    @Override
    public void deleteTable(String tableName) throws IOException {
        if (isTableExists(tableName)) {
            admin.disableTable(TableName.valueOf(tableName));
            admin.deleteTable(TableName.valueOf(tableName));
        }
    }

    @Override
    public boolean isTableExists(String tableName) throws IOException {
        return admin.tableExists(TableName.valueOf(tableName));
    }

    @Override
    public void insertData(String tableName, String rowKey, String columnFamily, String columnQualifier, String value) throws IOException {
        if (isTableExists(tableName)) {
            Table table = conn.getTable(TableName.valueOf(tableName));
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnQualifier), Bytes.toBytes(value));
            table.put(put);
        }
    }

    @Override
    public Result getData(String tableName, String rowKey, String columnFamily, String columnQualifier) throws IOException {
        if (isTableExists(tableName)) {
            Table table = conn.getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnQualifier));
            return table.get(get);
        } else {
            System.out.println("No such a table...");
            return null;
        }
    }

    @Override
    public Result getData(String tableName, String rowKey) throws IOException {
        if (isTableExists(tableName)) {
            Table table = conn.getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            return table.get(get);
        } else {
            System.out.println("No such a table...");
            return null;
        }
    }

    @Override
    public ResultScanner scanData(String tableName) throws IOException {
        if (isTableExists(tableName)) {
            Table table = conn.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            return table.getScanner(scan);
        } else {
            System.out.println("No such a table...");
            return null;
        }
    }

    @Override
    public void deleteData(String tableName, String rowKey, String columnFamily, String columnQualifier) throws IOException {
        if (isTableExists(tableName)) {
            Table table = conn.getTable(TableName.valueOf(tableName));
            Delete delete = new Delete(Bytes.toBytes(rowKey));
            delete.addColumns(Bytes.toBytes(columnFamily), Bytes.toBytes(columnQualifier));
            table.delete(delete);
        }
    }

    public static void closeAll() {
        IOUtils.closeStream(admin);
        IOUtils.closeStream(conn);
    }
}
