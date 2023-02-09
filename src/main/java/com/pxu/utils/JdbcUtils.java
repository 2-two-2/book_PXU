package com.pxu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


/**
 * @author
 * @Date:2022/11/10-16:15
 */
public class JdbcUtils {

    public static DruidPooledConnection getConnection(){
        ApplicationContext app  = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource druidDataSource = app.getBean(DruidDataSource.class);
        DruidPooledConnection connection = null;
        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close();
        }
        return connection;
    }

    private static void close() {

    }
}

