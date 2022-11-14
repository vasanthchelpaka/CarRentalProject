package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.dao.PrizeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PrizeServiceImpl implements PrizeService{

    @Autowired
    PrizeDao prizeDao;

    @Override
    public List<Cars> getCarsSorted( String sort) {
        List<Cars> car=prizeDao.getCarsAfterSort(sort);

        return car;
    }
}
