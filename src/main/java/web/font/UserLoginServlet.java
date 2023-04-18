package web.font;

import serivice.UserReact;
import serivice.serviceImpl.UserReactImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/16 9:51
 * #Describe:
 */
@WebServlet("/font/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private final UserReact react = new UserReactImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        session.setAttribute("userName", userName);
        session.setAttribute("password", password);
        try {
            boolean login = react.userLogin(session);
            if (login) {
                String contextPath = req.getContextPath();
                req.setAttribute("information", null);
                resp.sendRedirect(contextPath + "/background/welcomepage.jsp");
            } else {
                req.setAttribute("information", "登录失败，登录信息错误");
                req.getRequestDispatcher("/UserInterface.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
