package com.smartjob.service;

import com.smartjob.models.Users;

import java.util.List;

public interface IUsersService {

    Users save(Users user);

    List<Users> findall();

}
