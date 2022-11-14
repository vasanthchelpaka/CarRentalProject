package com.CarRental.Controller.bean;

import java.time.LocalDate;

public class Hist {
    private String bookedfrom;
    private String bookedto;
    private String hashcode;
    private String userid;

    public String getBookedfrom() {
        return bookedfrom;
    }

    public void setBookedfrom(String bookedfrom) {
        this.bookedfrom = bookedfrom;
    }

    public String getBookedto() {
        return bookedto;
    }

    public void setBookedto(String bookedto) {
        this.bookedto = bookedto;
    }

    public String gethashcode() {
        return hashcode;
    }

    public void sethashcode(String hash) {
        this.hashcode = hash;
    }

    public String getuserid() {
        return userid;
    }

    public void setuserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Hist{" +
                "bookedfrom=" + bookedfrom +
                ", bookedto=" + bookedto +
                ", hashcode=" + hashcode +
                ", userid=" + userid+
                '}';
    }
}
