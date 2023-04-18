package web.font;

import pojo.UserInformation;
import pojo.ValidationQuestion;
import serivice.UserReact;
import serivice.serviceImpl.UserReactImpl;
import utils.ValidationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/16 10:08
 * #Describe:
 */
@WebServlet("/font/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    UserReact react = new UserReactImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 解决字符集乱码 --- 相应和请求都要设置 */
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf8");
        PrintWriter writer = resp.getWriter();
        String validQuestion = req.getParameter("validQuestion");
        ValidationQuestion validationEnum = ValidationUtil.transformTheQuestion(validQuestion);

        UserInformation information = new UserInformation(
                req.getParameter("userName"),
                req.getParameter("password"),
                req.getParameter("birthday"),
                req.getParameter("email"),
                validationEnum,
                req.getParameter("validAnswer")
        );

        try {
            boolean result = react.userRegister(information);
            writer.print("<script>alert('" + (result ? "注册成功，请登录!" : "注册失败，请重试!") + "')</script>");
            req.getRequestDispatcher("/UserInterface.jsp").include(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
