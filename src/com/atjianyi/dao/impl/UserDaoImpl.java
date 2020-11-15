package com.atjianyi.dao.impl;

import com.atjianyi.dao.UserDao;
import com.atjianyi.domain.User;
import com.atjianyi.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 简一
 * @className UserDaoImpl
 * @Date 2020/11/8 19:32
 **/
public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner();
    private Connection conn;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into USER () values(null,?,?,?,?,?,?,?,?,?,?) ";
            int update = queryRunner.update(conn,sql, user.getUserName(), user.getName(), user.getUserPwd(), user.getUserSex(), user.getUserBirth(), user.getUserIdenityCode()
                    , user.getUserEmail(), user.getUserPone(), user.getUserAddress(), user.getUserStatus());
            if(update>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAll()  {
        List<User> users = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql ="select  id id,             \n" +
                    "name   name,          \n" +
                    "user_address  userAddress,   \n" +
                    "user_birth  userBirth,     \n" +
                    "user_email  userEmail,     \n" +
                    "user_idenity_code userIdenityCode,\n" +
                    "user_name   userName,     \n" +
                    "user_phone   userPone,    \n" +
                    "user_pwd  userPwd,       \n" +
                    "user_sex  userSex,       \n" +
                    "user_status  userStatus    \n from user";
            users = queryRunner.query(conn, sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    /**
     * 查询总页数
     * @return
     */
    @Override
    public int selectCount(String rname) {
        long totalCount = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select count(*) from user where 1=1 ";
            StringBuilder builder = new StringBuilder(sql);
            String where =null;
            if(rname!=null && rname.length()>0){
                builder.append(" and user_name like ?");
                where = "%"+rname+"%";
                sql = builder.toString();
                totalCount = queryRunner.query(conn, sql, new ScalarHandler<Long>(),where);
            }else{
                totalCount = queryRunner.query(conn, sql, new ScalarHandler<Long>());
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return (int)totalCount;
    }

    /**
     * 分页查询名数据，返回结果
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<User> selectLimitUser(int begin, int pageSize,String rName) {
        List<User> query = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql ="select  id id,             \n" +
                    "name   name,          \n" +
                    "user_address  userAddress,   \n" +
                    "user_birth  userBirth,     \n" +
                    "user_email  userEmail,     \n" +
                    "user_idenity_code userIdenityCode,\n" +
                    "user_name   userName,     \n" +
                    "user_phone   userPone,    \n" +
                    "user_pwd  userPwd,       \n" +
                    "user_sex  userSex,       \n" +
                    "user_status  userStatus    \n from user where 1 = 1 ";
            StringBuilder builder = new StringBuilder(sql);
            List<Object> params = new ArrayList<>();
            if(rName!=null && rName.length()>0){
                builder.append(" and user_name like ? ");
                params.add("%"+rName+"%");
            }
            builder.append(" limit ? , ? ");
            params.add(begin);
            params.add(pageSize);
            sql = builder.toString();

            query = queryRunner.query(conn, sql, new BeanListHandler<User>
                    (User.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return query;

    }

    /**
     * 根据Id找出User
     * @param idInt
     * @return
     */
    @Override
    public User findUserById(int idInt) {
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql ="select  id id,             \n" +
                    "name   name,          \n" +
                    "user_address  userAddress,   \n" +
                    "user_birth  userBirth,     \n" +
                    "user_email  userEmail,     \n" +
                    "user_idenity_code userIdenityCode,\n" +
                    "user_name   userName,     \n" +
                    "user_phone   userPone,    \n" +
                    "user_pwd  userPwd,       \n" +
                    "user_sex  userSex,       \n" +
                    "user_status  userStatus    \n from user where id = ?";
            user = queryRunner.query(conn, sql, new BeanHandler<>(User.class), idInt);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return user;

    }

    @Override
    public int updateUser(User user) {
        Connection conn = null;
        int update = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update user set user_name = ? , user_name = ?,user_pwd = ?,user_sex = ? ,user_birth = ?,user_email = ?, user_phone = ?,user_address =? " +
                    "where id = ? ";
            update = queryRunner.update(conn, sql, user.getName(), user.getUserName(), user.getUserPwd(), user.getUserSex(), user.getUserBirth(), user.getUserEmail(), user.getUserPone(), user.getUserAddress()
                    , user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return update;
    }

    @Override
    public int delUserById(int id) {
        int update = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from user where id = ?";
            update = queryRunner.update(conn, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return update;
    }

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @Override
    public int findUserByUserName(String username) {
        List<User> query = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select user_name userName from user where user_name = ?";
            query = queryRunner.query(conn, sql, new BeanListHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return query.size(); //返回多少条数据

    }

    @Override
    public User login(String username, String pwd) {
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select  id id,             \n" +
                    "name   name,          \n" +
                    "user_address  userAddress,   \n" +
                    "user_birth  userBirth,     \n" +
                    "user_email  userEmail,     \n" +
                    "user_idenity_code userIdenityCode,\n" +
                    "user_name   userName,     \n" +
                    "user_phone   userPone,    \n" +
                    "user_pwd  userPwd,       \n" +
                    "user_sex  userSex,       \n" +
                    "user_status  userStatus    \n from user where user_name = ? and user_pwd = ?";
            user = queryRunner.query(conn, sql, new BeanHandler<>(User.class), username, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
