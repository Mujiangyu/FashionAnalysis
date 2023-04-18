package serivice.serviceImpl;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import pojo.UserInformation;
import serivice.UserReact;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/16 9:34
 * #Describe:
 */
public class UserReactImpl implements UserReact {
    UserDao dao = new UserDaoImpl();

    @Override
    public boolean userLogin(HttpSession session) throws SQLException {
        String userName = (String) session.getAttribute("userName");
        String password = (String) session.getAttribute("password");
        boolean login = dao.login(userName, password);

        session.setAttribute("permission", login);
        return login;
    }

    @Override
    public boolean userRegister(UserInformation userInformation) throws SQLException {
        boolean exists = dao.searchTheExistUserName(userInformation.getName());
        if (exists)
            return false;
        return dao.register(userInformation);
    }

    @Override
    public boolean userChangePassword(String newPassword, String userName, String validQuestion, String validateAnswer) throws SQLException {
        return dao.changePassword(newPassword, userName, validQuestion, validateAnswer);
    }

    @Override
    public int searchTheValidQuestionIndex(String userName) throws SQLException {
        return dao.searchTheValidQuestionIndex(userName);
    }
}
