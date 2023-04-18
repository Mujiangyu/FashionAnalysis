package web.background;

import serivice.HBaseService;
import serivice.HDFSService;
import serivice.serviceImpl.HBaseServiceImpl;
import serivice.serviceImpl.HDFSServiceImpl;
import utils.ConfUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * #Author :Sino
 * #Date   :2021/11/27 11:39
 * #Describe:
 */
@WebServlet("/background/DataProcessServlet")
public class DataProcessServlet extends HttpServlet {
    private final HDFSService hdfsService = new HDFSServiceImpl();
    private final HBaseService hBaseService = new HBaseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码为UTF-8
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //上传数据集
        boolean uploadResult = hdfsService.uploadDataset("\\src\\main\\resources\\dataset");

        if (uploadResult) {
            try {
                final List<String> tableNameList = hBaseService.storeInTable(ConfUtils.getCoreConf("DATA_SET_PATH"));
                getServletContext().setAttribute("tableNames", tableNameList);
            } catch (ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("/background/InitDataServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
