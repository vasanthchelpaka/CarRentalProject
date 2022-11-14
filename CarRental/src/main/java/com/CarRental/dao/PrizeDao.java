package com.CarRental.dao;

import com.CarRental.Controller.bean.Cars;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PrizeDao {
    List<Cars> getCarsAfterSort(String sort);
}
