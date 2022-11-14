package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.Hist;
import com.CarRental.dao.HistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistServiceImpl implements HistService{
    @Autowired
    HistDao histDao;

    @Override
    public List<Hist> getHistByHashId(int hashcode){
        List<Hist> his=histDao.getHistById(hashcode);
        return his;


    }
}
