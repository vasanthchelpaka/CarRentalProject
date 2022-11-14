package com.CarRental.dao;

import com.CarRental.Controller.bean.Cars;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CarDao {
    List<Cars> getCarById(LocalDate bookfrom, LocalDate bookto,String type);
}
