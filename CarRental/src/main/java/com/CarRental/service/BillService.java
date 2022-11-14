package com.CarRental.service;

import com.CarRental.Controller.bean.Cars;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BillService {
    List<Cars> getBillByCarId(Integer id);
}
