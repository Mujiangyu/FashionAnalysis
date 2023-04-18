package dao.daoImpl;


import dao.HDFSDao;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import utils.ConfUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * #Author :Sino
 * #Date   :2021/11/13 18:31
 * #Describe:
 */
public class HDFSBaseDaoImpl implements HDFSDao {
    private static Configuration conf;
    private static FileSystem fileSystem;

    static {
        try {
            conf = new Configuration();
            URI uri = new URI(ConfUtils.getCoreConf("HADOOP_FS_URI"));
            String userName = ConfUtils.getCoreConf("HADOOP_USER_NAME");
            fileSystem = FileSystem.get(uri, conf, userName);
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void mkdir(String path) throws IOException {
        fileSystem.mkdirs(new Path(path));
    }

    @Override
    public void copyFromLocal(String src, String dest, boolean overwrite) throws IOException {
        fileSystem.copyFromLocalFile(false, overwrite, new Path(src), new Path(dest));
    }

    @Override
    public void copyToLocal(String src, String dest) throws IOException {
        fileSystem.copyToLocalFile(false, new Path(src), new Path(dest), true);
    }

    @Override
    public void delete(String path) throws IOException {
        fileSystem.delete(new Path(path), false);
    }

    @Override
    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public static void closeAll() {
        IOUtils.closeStream(fileSystem);
    }
}
