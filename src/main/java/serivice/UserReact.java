package serivice;

import pojo.UserInformation;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/15 23:01
 * #Describe:
 */
public interface UserReact {
    /**
     * 从会话对象中检索用户登录信息，进行校验
     *
     * @param session 会话对象
     * @return 校验结果
     */
    boolean userLogin(HttpSession session) throws SQLException;

    /**
     * 用户注册
     *
     * @param userInformation 用户注册信息
     * @return 注册结果
     */
    boolean userRegister(UserInformation userInformation) throws SQLException;

    /**
     * 用户更改密码
     *
     * @param newPassword    新密码
     * @param userName       用户名
     * @param validateAnswer 验证问题答案
     * @return 更改结果
     */
    boolean userChangePassword(String newPassword, String userName, String validQuestion, String validateAnswer) throws SQLException;

    /**
     * 查找用户在数据库中存储的验证问题序列号
     *
     * @param userName 用户名
     * @return 序列号索引
     */
    int searchTheValidQuestionIndex(String userName) throws SQLException;
}
