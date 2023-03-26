package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.learn.dao.userMapper;
import org.learn.pojo.User;
import org.learn.utils.MyBatisUtils;

import java.util.List;

/**
 * IntelliJ IDEA
 *
 * @author Em4non E-mail:kaifenglin@126.com
 * @project_name MyBatis
 * @package PACKAGE_NAME
 * @className org.learn.dao.MyTest
 * @date 2023/3/23 16:14
 */
public class MyTest {
    @Test
    public void selectUser(){
        //获取到一个Sql的Session对象
        SqlSession sqlSession = MyBatisUtils.getSession();

        //获取对应的Mapper，让映射器通过命名空间和方法名称找到对应的SQL，发送给数据库执行后返回结果
        userMapper userMapper=sqlSession.getMapper(userMapper.class);
        List<User> userList=userMapper.getUserList();
        for (User user: userList) {
            System.out.println(user);
        }
        //关闭Session会话
        sqlSession.close();


    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user=mapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void addUser(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int i = mapper.addUser(new User("ran",4,"123456"));
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void updateUser(){
        SqlSession sqlSession=MyBatisUtils.getSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int i=mapper.updateUser(new User("lira",5,"666666"));
        if(i==1) System.out.println("success!");
        sqlSession.commit();
    }


    @Test
    public void deleteUser(){
        SqlSession sqlSession= MyBatisUtils.getSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.deleteUser(6);
        sqlSession.commit();

    }
}





















