package com.smartjob.repository;

import com.smartjob.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
    boolean existsByUsername(String username);

    Users findByEmail(String email);
    boolean existsByEmail(String email);

}
