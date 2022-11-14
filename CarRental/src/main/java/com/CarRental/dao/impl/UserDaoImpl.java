package com.CarRental.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.CarRental.Controller.bean.User;
import com.CarRental.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public User getUserById(String userId) {
        String sql="select user_pass from user where user_id=? ";

        return getJdbcTemplate().queryForObject(sql,new Object[] {userId},new RowMapper<User>(){

            @Override
            public  User mapRow(ResultSet rs,int rowNum) throws SQLException{
                User user=new User();
                user.setUser(userId);
                user.setPassword(rs.getString(1));
                return user;
            }
        });

    }
}
