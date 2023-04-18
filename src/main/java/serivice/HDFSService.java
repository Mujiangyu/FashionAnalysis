package serivice;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/27 17:04
 * #Describe:
 */
public interface HDFSService {
    /**
     * 在HDFS上创建目录
     *
     * @param path 目录的路径
     */
    void mkdir(String path) throws IOException;
    /**
     * 上传文件到HDFS
     *
     * @param src  源路径
     * @param dest 目标路径
     * @param overwrite 是否覆盖写入
     */
    void copyFromLocal(String src, String dest, boolean overwrite) throws IOException;

    /**
     * 从HDFS上下载文件
     *
     * @param src  源路径
     * @param dest 目标路径
     */
    void copyToLocal(String src, String dest) throws IOException;

    /**
     * 删除文件
     *
     * @param path 删除路径
     */
    void delete(String path) throws IOException;

    /**
     * 上传数据集
     *
     * @param relativePath 数据集相对于工程路径的路径，以“\”开头
     * @return 上传的结果
     */
    boolean uploadDataset(String relativePath) throws IOException;
}
