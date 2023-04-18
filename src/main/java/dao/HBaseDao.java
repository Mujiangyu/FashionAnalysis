package dao;

import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/13 18:47
 * #Describe:
 */
public interface HBaseDao {

    /**
     * 获取HBase的连接
     * @return HBase的连接
     */
    Connection getHBaseConnection();

    /**
     * 创建HBase的命名空间
     *
     * @param name 命名空间名
     * Deprecated： 不建议使用
     */
    @Deprecated
    void createNameSpace(String name) throws IOException;

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

}
