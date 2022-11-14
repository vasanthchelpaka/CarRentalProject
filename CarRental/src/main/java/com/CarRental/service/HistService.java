package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.Hist;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface HistService {

    public List<Hist> getHistByHashId(int hashcode);
}
