package com.smartjob.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private Object data;
    private List<String> mensaje;

    public ApiResponse(Object data) {
        this.data = data;
        this.mensaje = null;
    }

    public ApiResponse(List<String> mensaje) {
        this.data = null;
        this.mensaje = mensaje;
    }

}