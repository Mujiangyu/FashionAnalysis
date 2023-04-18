package web.font;

import serivice.UserReact;
import serivice.serviceImpl.UserReactImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/16 10:51
 * #Describe:
 */
@WebServlet("/font/UserChangePasswordServlet")
public class UserChangePasswordServlet extends HttpServlet {
    private final UserReact react = new UserReactImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String userName = req.getParameter("userName");
        String newPassword = req.getParameter("newPassword");
        String validQuestion = req.getParameter("validQuestion");
        String validAnswer = req.getParameter("validAnswer");

        try {
            boolean change = react.userChangePassword(newPassword, userName, validQuestion, validAnswer);
            req.setAttribute("information", change ? "修改成功，请登录！" : "修改失败，请重试！");
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
