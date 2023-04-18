package dao.daoImpl;

import org.junit.Test;
import utils.ConfUtils;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/15 22:27
 * #Describe:
 */
public class TestHDFSDao {
    HDFSBaseDaoImpl dao = new HDFSBaseDaoImpl();

    @Test
    public void testMkdir() {
        try {
            dao.mkdir("/test_dir");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyFromLocal() {
        try {
            dao.copyFromLocal(ConfUtils.getCoreConf("ABSOLUTE_PATH_OF_PROJECT") + "\\src\\test\\resources\\FileForHDFSTest.txt",
                    "/test_dir",
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyToLocal() {
        try {
            dao.copyToLocal("/test_dir/FileForHDFSTest.txt",
                    ConfUtils.getCoreConf("ABSOLUTE_PATH_OF_PROJECT") + "\\src\\test\\resources\\AnotherFileForHDFSTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        try {
            dao.delete("/test_dir/FileForHDFSTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
