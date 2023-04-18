package web.background;

import org.apache.hadoop.hbase.client.ResultScanner;
import serivice.HBaseService;
import serivice.serviceImpl.HBaseServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #Author :Sino
 * #Date   :2021/11/28 16:54
 * #Describe:
 */
@WebServlet("/background/InitDataServlet")
public class InitDataServlet extends HttpServlet {
    private final HBaseService service = new HBaseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        //存放ResultScanner的Map集合
        Map<String, ResultScanner> scannerMap = new HashMap<>();
        //存放表名的List集合
        List<String> tableNameList = (List<String>) context.getAttribute("tableNames");

        for (String tableName : tableNameList) {
            final ResultScanner scanner = service.scanData(tableName);
            scannerMap.put(tableName, scanner);
        }
        context.setAttribute("tableScanner", scannerMap);
        req.getRequestDispatcher("/background/menu_accessories.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
