package com.CarRental.dao;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.Hist;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistDao {
    List<Hist> getHistById(int hashcode);
}
