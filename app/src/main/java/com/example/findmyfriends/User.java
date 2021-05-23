package com.example.findmyfriends;

import java.io.Serializable;

public class User implements Serializable {
    String username;
    String mail;
    String phone;

    public User() {
    }

    public User(String  username, String mail, String phone) {
        this.username = username;
        this.mail = mail;
        this.phone = phone;
    }

    public String  getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
