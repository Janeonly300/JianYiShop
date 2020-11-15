package com.atjianyi.test;

import com.atjianyi.dao.impl.UserDaoImpl;
import com.atjianyi.domain.PageBean;
import com.atjianyi.domain.User;
import com.atjianyi.service.impl.UserServiceImpl;
import com.atjianyi.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 简一
 * @className JDBConnectionTest
 * @Date 2020/11/8 19:13
 **/
public class JDBConnectionTest {
    @Test
    public void textConnection() throws SQLException {
        Connection connn = JDBCUtils.getConnection();
        System.out.println(connn);
    }

    @Test
    public void textSelectAll() throws SQLException {
        List<User> list = new UserDaoImpl().selectAll();
    }

    @Test
    public void testQueryPage(){
        PageBean<User> pageBean = new UserServiceImpl().selectByLimit(1, 6, "");
        pageBean.getmList().forEach(System.out::println);
    }

    @Test
    public void testFindUserByid(){
        User userById = new UserServiceImpl().findUserById(1);
        System.out.println(userById);
    }
}
