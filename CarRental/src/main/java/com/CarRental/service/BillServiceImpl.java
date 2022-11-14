package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.User;
import com.CarRental.dao.BillDao;
import com.CarRental.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDao billDao;

    @Override
    public List<Cars> getBillByCarId(Integer Id){
        List<Cars> bill= billDao.getBillById(Id);
        return bill;
    }
}
