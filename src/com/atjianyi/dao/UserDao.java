package com.atjianyi.dao;

import com.atjianyi.domain.User;

import java.util.List;

public interface UserDao {
    boolean insertUser(User user);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll() ;

    /**
     * 查询总页数
     * @return
     */
    int selectCount(String rname);

    /**
     * 查询分页结果
     * @param begin
     * @param pageSize
     * @return
     */
    List<User> selectLimitUser(int begin, int pageSize,String rName);

    /**
     * 通过Id查询出对象
     * @param idInt
     * @return
     */
    User findUserById(int idInt);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delUserById(int id);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    int findUserByUserName(String username);

    /**
     * 用户登陆
     * @param username
     * @param pwd
     * @return
     */
    User login(String username, String pwd);
}

