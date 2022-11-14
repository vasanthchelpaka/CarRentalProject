package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.User;
import com.CarRental.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;


    @Override
    public List<Cars> getCarByCarId(LocalDate bookfrom, LocalDate bookto,String type) {
        System.out.println("Service Layer"+bookfrom);
        System.out.println("Service Layer"+bookto);
     //   Cars car = carDao.getCarById(bookfrom, bookto);
        List<Cars> car=carDao.getCarById(bookfrom,bookto,type);

        return car;
    }
}

