package com.atjianyi.service.impl;

import com.atjianyi.dao.UserDao;
import com.atjianyi.dao.impl.UserDaoImpl;
import com.atjianyi.domain.PageBean;
import com.atjianyi.domain.User;
import com.atjianyi.service.UserService;

import java.util.List;

/**
 * @author 简一
 * @className UserServiceImpl
 * @Date 2020/11/8 19:32
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {
        boolean b = userDao.insertUser(user);
        return b;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    @Deprecated
    public List<User> selectAll() {
      return userDao.selectAll();
    }

    /**
     * 分页查询
     * @param curPageInt
     * @param
     * @return
     */
    @Override
    public PageBean<User> selectByLimit(int curPageInt, int pageSize,String rName) {
        PageBean<User> pageBean = new PageBean<>();
        //查询总记录数
        int totalCount = userDao.selectCount(rName);
        pageBean.setTotalCount(totalCount);
        pageBean.setPageSize(pageSize);
        int totalPage = totalCount/pageSize;
        if(totalCount%pageSize !=0){ //如果有多余的数据
            totalPage += 1;
        }
        if(curPageInt >totalPage){ //如果当前页面大于总页面
            curPageInt = totalPage;
        }
        pageBean.setCurPage(curPageInt);
        pageBean.setTotalPage(totalPage);

        int begin = curPageInt*pageSize - pageSize; //limit从哪开始
        List<User> users = userDao.selectLimitUser(begin,pageSize, rName);
        pageBean.setmList(users);
        return pageBean;
    }

    @Override
    public User findUserById(int idInt) {
        return userDao.findUserById(idInt);
    }

    /**
     * 修改用户
     * @param updateUser
     * @return
     */
    @Override
    public int updateUser(User updateUser) {
        int i = userDao.updateUser(updateUser);
        return i;
    }

    /**
     * 通过Id删除用户
     * @param id
     * @return
     */
    @Override
    public int delUserById(int id) {
        int k = 0;
        if(id>0){
           k = userDao.delUserById(id);
        }
        return k;

    }

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @Override
    public int findUserByUserName(String username) {
        int row = 0;
        row = userDao.findUserByUserName(username);
        return row;
    }

    /**
     * 用户登陆页面
     * @param username
     * @param pwd
     * @return
     */
    @Override
    public User loginByUserName(String username, String pwd) {
        return userDao.login(username,pwd);
    }
}
