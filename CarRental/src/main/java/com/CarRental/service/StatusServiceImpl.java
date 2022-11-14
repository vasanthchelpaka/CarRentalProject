package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.dao.StatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class StatusServiceImpl implements StatusService{
    @Autowired
    StatusDao statusDao;

    @Override
    public List<Cars> statusOfcar(int carId,int hashcode) {
        List<Cars> car=statusDao.updateStatus(carId,hashcode);
        return car;
    }
}
