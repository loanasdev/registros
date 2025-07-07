package com.smartjob.dtos;

import com.smartjob.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private String idPhone;

    private Users user;

    private Integer number;

    private String citycode;

    private String contrycode;

}
