package dao.daoImpl;

import dao.HBaseDao;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/27 13:33
 * #Describe:
 */
public class TestHBaseDaoImpl {
    private HBaseDao dao = new HBaseDaoImpl();

    @Test
    public void testCreateNamespace() throws IOException {
        dao.createNameSpace("TestNamespace");
    }

    @Test
    public void testCreateTable() throws IOException {
        dao.createTable("testtable", "cf1", "cf2");
    }

    @Test
    public void testDeleteTable() throws IOException {
        dao.deleteTable("testtable");
    }

    @Test
    public void testIsTableExists() throws IOException {
        boolean test = dao.isTableExists("testtable");
        Assert.assertFalse(test);
    }

    @Test
    public void testInsertData() throws IOException {
        dao.insertData("testtable", "1001", "cf1", "info1", "v1");
    }

    @Test
    public void testGetData() throws IOException {
        Result result = dao.getData("testtable", "1001", "cf1", "info1");
        for (Cell cell : result.rawCells()) {
            System.out.println(Bytes.toString(CellUtil.cloneRow(cell)) + " : "
                    + Bytes.toString(CellUtil.cloneFamily(cell)) + " : "
                    + Bytes.toString(CellUtil.cloneQualifier(cell)) + " : "
                    + Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }

    @Test
    public void testScanData() throws IOException {
        ResultScanner scanner = dao.scanData("category-women");
        for (Result result : scanner) {
            for (Cell cell : result.rawCells()) {
                System.out.println(Bytes.toString(CellUtil.cloneRow(cell)) + " : "
                        + Bytes.toString(CellUtil.cloneFamily(cell)) + " : "
                        + Bytes.toString(CellUtil.cloneQualifier(cell)) + " : "
                        + Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }
    }

    @Test
    public void testDeleteData() throws IOException {
        dao.deleteData("testtable", "1001", "cf1", "info1");
    }

    @Test
    public void testGetHBaseConnection() {
        System.out.println(dao.getHBaseConnection().getClass());
    }
}
