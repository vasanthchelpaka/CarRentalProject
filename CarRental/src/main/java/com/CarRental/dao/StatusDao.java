package com.CarRental.dao;

import com.CarRental.Controller.bean.Cars;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StatusDao {

    List<Cars> updateStatus(int carId,int hashcode);
}
