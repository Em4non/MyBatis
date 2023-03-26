package org.learn.dao;

import org.learn.pojo.User;

import java.util.List;

/**
 * IntelliJ IDEA
 *
 * @author Em4non E-mail:kaifenglin@126.com
 * @project_name MyBatis
 * @package org.learn.dao
 * @className userDao
 * @date 2023/3/23 11:50
 */
public interface userMapper {
    //查询所有用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //插入用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);

}
