package dao.daoImpl;

import org.junit.Assert;
import org.junit.Test;
import pojo.UserInformation;
import pojo.ValidationQuestion;

import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/13 18:49
 * #Describe:
 */
public class TestUserDaoImpl {
    private UserDaoImpl dao = new UserDaoImpl();

    @Test
    public void testLogin() {
        String userName = "root";
        String password = "root";
        boolean login = false;
        try {
            login = dao.login(userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Assert.assertTrue(login);
    }

    @Test
    public void testRegister() {
        UserInformation information = new UserInformation();
        information.setName("Jimmy");
        information.setPassword("123123");
        information.setBirthday("2020-10-1");
        information.setEmail("Jimmy@qq.com");
        information.setQuestion(ValidationQuestion.FATHER_NAME);
        information.setAnswer("the god");
        boolean register = false;
        try {
            register = dao.register(information);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Assert.assertTrue(register);
    }

    @Test
    public void testChangePassword() {
        String userName = "Jimmy";
        String newPassword = "23333";
        String question = "1";
        String answer = "the god";
        boolean result = false;
        try {
            result = dao.changePassword(newPassword, userName, question, answer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
