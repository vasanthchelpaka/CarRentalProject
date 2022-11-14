package com.CarRental.Controller.bean;

public class User {
    private String userId;
    private String password;

    public String getUser() {
        return userId;
    }

    public void setUser(String user) {
        this.userId = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
