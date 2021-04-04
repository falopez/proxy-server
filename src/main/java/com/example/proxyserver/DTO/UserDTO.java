package com.example.proxyserver.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String documentNumber;
    private String birthdate;
    private String firstName;
    private String lastName;
    private String email;
    private String sexo;

}
