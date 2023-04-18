package dao;

import pojo.UserInformation;

import java.sql.SQLException;

/**
 * #Author :Sino
 * #Date   :2021/11/13 1:42
 * #Describe:
 */
public interface UserDao {
    /**
     * 登录验证方法
     *
     * @param userName 用户输入用户名
     * @param password 用户输入密码
     * @return 校验结果
     * @throws SQLException
     */
    boolean login(String userName, String password) throws SQLException;

    /**
     * 注册方法
     *
     * @param information 用户注册信息
     * @return
     */
    boolean register(UserInformation information) throws SQLException;

    /**
     * 更改用户密码
     *
     * @param userName    用户名
     * @param newPassword 密码
     * @param validateAnswer  验证问题答案
     * @return 修改结果
     */
    boolean changePassword(String newPassword, String userName, String validQuestion, String validateAnswer) throws SQLException;

    /**
     * 查找用户在数据库中存储的验证问题序列号
     *
     * @param userName 用户名
     * @return 序列号索引
     */
    int searchTheValidQuestionIndex(String userName) throws SQLException;

    /**
     * 查找已经存在的用户名
     *
     * @param userName 待查找用户名
     * @return 是否存在，存在为true
     */
    boolean searchTheExistUserName(String userName) throws SQLException;
}
