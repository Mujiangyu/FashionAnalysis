package dao.daoImpl;

import dao.UserDao;
import pojo.UserInformation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/13 11:58
 * #Describe:
 */
public class UserDaoImpl extends MySQLBaseDao implements UserDao {

    @Override
    public boolean login(String userName, String password) throws SQLException {
        boolean flag = false;
        ResultSet resultSet = query("tbl_userinfo", userName);
        if (resultSet.next()) {
            boolean userNameValid = userName.equals(resultSet.getString("user_name"));
            boolean passwordValid = password.equals(resultSet.getString("user_password"));
            flag = userNameValid && passwordValid;
        }

        return flag;
    }

    @Override
    public boolean register(UserInformation information) throws SQLException {
        int rows = insert("tbl_userinfo",
                information.getName(),
                information.getPassword(),
                information.getBirthday(),
                information.getEmail(),
                String.valueOf(information.getQuestion().ordinal()),
                information.getAnswer());

        return (rows > 0);
    }

    @Override
    public boolean changePassword(String newPassword, String userName, String validQuestion, String validateAnswer) throws SQLException {
        int rows = update("tbl_userinfo", newPassword, userName, validQuestion, validateAnswer);

        return (rows > 0);
    }

    @Override
    public int searchTheValidQuestionIndex(String userName) throws SQLException {
        ResultSet resultSet = query("tbl_userinfo", userName);
        if (resultSet.next()) {
            String indexString = resultSet.getString("valid_question");
            return Integer.parseInt(indexString);
        } else {
            throw new RuntimeException("No such a user...");
        }
    }

    @Override
    public boolean searchTheExistUserName(String userName) throws SQLException {
        ResultSet resultSet = query("tbl_userinfo", userName);
        return resultSet.next();
    }
}
