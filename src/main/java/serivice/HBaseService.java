package serivice;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

import java.io.IOException;
import java.util.List;

/**
 * #Author :Sino
 * #Date   :2021/11/27 17:12
 * #Describe:
 */
public interface HBaseService {

    /**
     * 在HBase中建表
     *
     * @param tableName    表名
     * @param columnFamily 列族
     */
    void createTable(String tableName, String... columnFamily) throws IOException;

    /**
     * 删除一张HBase中的表
     *
     * @param tableName 表名
     */
    void deleteTable(String tableName) throws IOException;

    /**
     * 判断HBase表是否存在
     *
     * @param tableName 表名
     * @return 结果，存在为true
     * @throws IOException
     */
    boolean isTableExists(String tableName) throws IOException;

    /**
     * 向指定HBase表中插入数据
     *
     * @param tableName       表名
     * @param rowKey          行键
     * @param columnFamily    列族
     * @param columnQualifier 列标志符
     * @param value           待插入值
     */
    void insertData(String tableName, String rowKey, String columnFamily, String columnQualifier, String value) throws IOException;

    /**
     * 获取指定HBase表中的数据
     *
     * @param tableName       表名
     * @param rowKey          行键
     * @param columnFamily    列族
     * @param columnQualifier 列标志符
     * @return 结果集
     */
    Result getData(String tableName, String rowKey, String columnFamily, String columnQualifier) throws IOException;

    /**
     * 重载方法，查找指定行键的数据
     *
     * @param tableName 表名
     * @param rowKey    行键
     * @return 结果集
     */
    Result getData(String tableName, String rowKey) throws IOException;

    /**
     * HBase扫描全表数据
     *
     * @param tableName 表名
     */
    ResultScanner scanData(String tableName) throws IOException;

    /**
     * 删除HBase表中的指定数据
     *
     * @param tableName       表名
     * @param rowKey          行键
     * @param columnFamily    列族
     * @param columnQualifier 列标志符
     */
    void deleteData(String tableName, String rowKey, String columnFamily, String columnQualifier) throws IOException;

    /**
     * 将数据集加载到HBase表中
     *
     * @param filePath  文件所在目录
     * @return
     */
    List<String> storeInTable(String filePath) throws IOException, ClassNotFoundException, InterruptedException;
}
