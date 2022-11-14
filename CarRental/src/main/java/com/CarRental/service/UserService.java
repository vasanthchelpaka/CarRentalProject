package com.CarRental.service;

import com.CarRental.Controller.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public interface UserService {
    User getUserByUserId(String userId);
}
