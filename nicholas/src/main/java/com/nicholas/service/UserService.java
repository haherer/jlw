package com.nicholas.service;


import com.nicholas.domain.User;

public interface UserService {

    Integer addUser(String account , String password);

    Integer login(String account , String password);

    User query(String account);

}
