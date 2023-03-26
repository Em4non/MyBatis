package org.learn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * IntelliJ IDEA
 *
 * @author Em4non E-mail:kaifenglin@126.com
 * @project_name MyBatis
 * @package org.learn.utils
 * @className MyBatisUtils
 * @date 2023/3/23 10:43
 */
public class MyBatisUtils {
    //新建一个SqlSession工厂类,用于创建SqlSession实例
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //读取mybatis的配置文件，其中包括数据库的各项配置信息
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //获取SqlSession连接
    //SqlSession提供了在数据库执行Sql语句的全部方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

}
