package web.background;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import pojo.ProductInformation;
import serivice.HBaseService;
import serivice.serviceImpl.HBaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/29 20:14
 * #Describe: 在此抽取商品详细信息
 */

//"background/ExtractDetailServlet?tableName=category-accessories&rowKey=${pageScope.rowKey}

@WebServlet("/background/ExtractDetailServlet")
public class ExtractDetailServlet extends HttpServlet {
    private final HBaseService service = new HBaseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码为UTF-8
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //创建Bean
        ProductInformation product = new ProductInformation();
        //获取商品结果集
        String tableName = req.getParameter("tableName");
        String rowKey = req.getParameter("rowKey");
        Result productRecord = service.getData(tableName, rowKey);
        //设置信息
        product.setCategory(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("category"))));
        product.setSubcategory(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("subcategory"))));
        product.setName(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("name"))));
        product.setCurrentPrice(Double.parseDouble(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("currentPrice"))).trim()));
        product.setRawPrice(Double.parseDouble(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("rawPrice"))).trim()));
        product.setCurrency(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("currency"))));
        product.setDiscount(Double.parseDouble(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("discount"))).trim()));
        product.setLikesCount(Integer.parseInt(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("likesCount"))).trim()));
        product.setNew(Boolean.parseBoolean(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("isNew"))).trim().toLowerCase()));
        product.setBrand(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("brand"))));
        product.setBrandURL(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("brandURL"))));
        product.setColorTypeOne(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("colorTypeOne"))));
        product.setSmallImageURLOne(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("smallImageURLOne"))));
        product.setImageURLOne(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("ImageURLOne"))));
        product.setColorTypeTwo(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("colorTypeTwo"))));
        product.setSmallImageURLTwo(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("smallImageURLTwo"))));
        product.setImageURLTwo(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("ImageURLTwo"))));
        product.setModelURL(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("modelURL"))));
        product.setID(Long.parseLong(Bytes.toString(productRecord.getValue(Bytes.toBytes("product_info"), Bytes.toBytes("ID"))).trim()));

        req.setAttribute("information", product);
        req.getRequestDispatcher("/webapp/background/ProductDetails.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
