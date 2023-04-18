package serivice.serviceImpl;

import dao.HBaseDao;
import dao.HDFSDao;
import dao.daoImpl.HBaseDaoImpl;
import dao.daoImpl.HDFSBaseDaoImpl;
import mapred.driver.ImportCsvFile;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import serivice.HBaseService;
import utils.ConfUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * #Author :Sino
 * #Date   :2021/11/27 17:13
 * #Describe:
 */
public class HBaseServiceImpl implements HBaseService {
    private final HBaseDao dao = new HBaseDaoImpl();

    @Override
    public void createTable(String tableName, String... columnFamily) throws IOException {
        dao.createTable(tableName, columnFamily);
    }

    @Override
    public void deleteTable(String tableName) throws IOException {
        dao.deleteTable(tableName);
    }

    @Override
    public boolean isTableExists(String tableName) throws IOException {
        return dao.isTableExists(tableName);
    }

    @Override
    public void insertData(String tableName, String rowKey, String columnFamily, String columnQualifier, String value) throws IOException {
        dao.insertData(tableName, rowKey, columnFamily, columnQualifier, value);
    }

    @Override
    public Result getData(String tableName, String rowKey, String columnFamily, String columnQualifier) throws IOException {
        return dao.getData(tableName, rowKey, columnFamily, columnQualifier);
    }

    @Override
    public Result getData(String tableName, String rowKey) throws IOException {
        return dao.getData(tableName, rowKey);
    }

    @Override
    public ResultScanner scanData(String tableName) throws IOException {
        return dao.scanData(tableName);
    }

    @Override
    public void deleteData(String tableName, String rowKey, String columnFamily, String columnQualifier) throws IOException {
        dao.deleteData(tableName, rowKey, columnFamily, columnQualifier);
    }

    @Override
    public List<String> storeInTable(String filePath) throws IOException, ClassNotFoundException, InterruptedException {
        //存放表名的集合
        List<String> tableNameList = new ArrayList<>();
        HDFSDao hdfsDao = new HDFSBaseDaoImpl();
        RemoteIterator<LocatedFileStatus> iterator =
                hdfsDao.getFileSystem().listFiles(new Path(ConfUtils.getCoreConf("DATA_SET_PATH")), false);

        while (iterator.hasNext()) {
            LocatedFileStatus fileStatus = iterator.next();
            //文件路径
            Path path = fileStatus.getPath();
            //表名
            String[] dirArray = path.toString().split("/");
            String fileName = dirArray[dirArray.length-1];
            String tableName = fileName.substring(0, fileName.length()-4);
            //导入到表
            /*if (isTableExists(tableName)) dao.deleteTable(tableName);
            dao.createTable(tableName, "product_info");*/

            if (!isTableExists(tableName)) {
                dao.createTable(tableName, "product_info");
                ImportCsvFile.importFile(path.toString(), tableName);
            }//如果已导入指定表，跳过
            //添加表名
            tableNameList.add(tableName);
        }
        return tableNameList;
    }
}
