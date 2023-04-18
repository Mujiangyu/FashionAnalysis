package serivice.serviceImpl;

import dao.HDFSDao;
import dao.daoImpl.HDFSBaseDaoImpl;
import serivice.HDFSService;
import utils.ConfUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * #Author :Sino
 * #Date   :2021/11/27 17:08
 * #Describe:
 */
public class HDFSServiceImpl implements HDFSService {
    private final HDFSDao dao = new HDFSBaseDaoImpl();
    @Override
    public void mkdir(String path) throws IOException {
        dao.mkdir(path);
    }

    @Override
    public void copyFromLocal(String src, String dest, boolean overwrite) throws IOException {
        dao.copyFromLocal(src, dest, overwrite);
    }

    @Override
    public void copyToLocal(String src, String dest) throws IOException {
        dao.copyToLocal(src, dest);
    }

    @Override
    public void delete(String path) throws IOException {
        dao.delete(path);
    }

    @Override
    public boolean uploadDataset(String relativePath) throws IOException {
        //数据集存储的本地路径
        String localDirectory = ConfUtils.getCoreConf("ABSOLUTE_PATH_OF_PROJECT")
                + relativePath;
        //在HDFS上创建存储数据集的目录
        dao.mkdir(ConfUtils.getCoreConf("DATA_SET_PATH"));

        File datasetDir = new File(localDirectory);
        if (datasetDir.isDirectory()) {
            File[] datasets = datasetDir.listFiles();
            for (File dataset : Objects.requireNonNull(datasets)) {
                dao.copyFromLocal(dataset.getAbsolutePath(),
                        ConfUtils.getCoreConf("DATA_SET_PATH"),
                        true);
            }
        } else {
            return false;
        }
        return true;
    }
}
