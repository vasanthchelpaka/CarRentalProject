package com.CarRental.service;

import com.CarRental.Controller.bean.User;
import com.CarRental.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserId(String userId){
        User user=userDao.getUserById(userId);
        return user;
    }
}
