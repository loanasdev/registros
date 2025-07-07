package com.smartjob.repository;

import com.smartjob.models.Phone;
import com.smartjob.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, String> {

}
