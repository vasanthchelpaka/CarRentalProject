package com.CarRental.dao;

import com.CarRental.Controller.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserById(String userId);
}
