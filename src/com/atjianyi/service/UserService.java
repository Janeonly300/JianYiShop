package com.atjianyi.service;

import com.atjianyi.domain.PageBean;
import com.atjianyi.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 用于添加用户
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 查询所有用户
     * 已过时
     * @return
     */
    @Deprecated
    List<User> selectAll();

    /**
     * 通过分页查询，以及模糊查询
     * @param curPageInt
     * @param i
     * @return PageBean<User>
     */
    PageBean<User> selectByLimit(int curPageInt, int i,String rName);

    /**
     * 通过Id查询用户
     * @param idInt
     * @return
     */
    User findUserById(int idInt);

    /**
     * 修改用户
     * @param updateUser
     * @return
     */
    int updateUser(User updateUser);

    /**
     * 通过Id删除用户
     * @param id
     */
    int delUserById(int id);

    /**
     * 通过用户名查找用户
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
    User loginByUserName(String username, String pwd);
}
