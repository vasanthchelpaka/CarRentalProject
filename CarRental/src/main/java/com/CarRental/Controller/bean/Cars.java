package com.CarRental.Controller.bean;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class Cars {
    private String hashcode;
    private int carId;
    private int prize;
    private String company;
    private String model;
    private String type;
    private LocalDate bookto;
    private String fuel;
    private LocalDate bookfrom;

    public LocalDate getBookfrom() {
        return bookfrom;
    }

    public void setBookfrom(LocalDate bookfrom) {
        this.bookfrom = bookfrom;
    }

    public LocalDate getBookto() {
        return bookto;
    }

    public void setBookto(LocalDate bookto) {
        this.bookto = bookto;
    }


    public String gethashcode() {
        return hashcode;
    }

    public void sethashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "hashcode='" + hashcode + '\'' +
                ", carId=" + carId +
                ", prize=" + prize +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", bookto=" + bookto +
                ", fuel='" + fuel + '\'' +
                ", bookfrom=" + bookfrom +
                '}';
    }

    public class Sortbyroll implements Comparator<Cars>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Cars a, Cars b)
        {
            return a.prize - b.prize;
        }
    }
    public class Sortbyrolldesc implements Comparator<Cars>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Cars a, Cars b)
        {
            return  b.prize - a.prize;
        }
    }
}
