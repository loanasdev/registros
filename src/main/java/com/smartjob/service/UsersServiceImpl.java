package com.smartjob.service;

import com.smartjob.models.Users;
import com.smartjob.repository.IUsersRepository;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService {

    private final IUsersRepository usersRepository;
    //private final IPhoneRepository phoneRepository;
    private final ModelMapper modelMapper;


    @Override
    public Users save(Users users) {

        users.setCreated(LocalDateTime.now());
        users.setModified(LocalDateTime.now());
        users.setLast_login(LocalDateTime.now());
        users.setIsactve(true);

        return usersRepository.save(users);
    }

    @Override
    public List<Users> findall() {
        return usersRepository.findAll();
    }

}
