package web.listener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import dao.daoImpl.HBaseDaoImpl;
import dao.daoImpl.HDFSBaseDaoImpl;
import dao.daoImpl.MySQLBaseDao;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HTable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * #Author :Sino
 * #Date   :2021/11/18 11:53
 * #Describe:
 */
public class DestroyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            //注销MySQL驱动并关闭相关线程
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                DriverManager.deregisterDriver(drivers.nextElement());
            }
            MySQLBaseDao.close(MySQLBaseDao.conn, null, null);
            AbandonedConnectionCleanupThread.uncheckedShutdown();
            //关闭Hadoop和HBase连接
            HDFSBaseDaoImpl.closeAll();
            HBaseDaoImpl.closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
