package com.example.proxyserver.controller;

import com.example.proxyserver.DTO.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(){
        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(UserDTO.builder().documentNumber("1061730197").birthdate("1990-05-16")
                .email("andresbox5@gmail.com").firstName("Fabian").lastName("Lopez").sexo("M").build());
        userDTOS.add(UserDTO.builder().documentNumber("9876545678").birthdate("1992-06-15")
                .email("oma72@gmail.com").firstName("Omaira").lastName("Galindez").sexo("F").build());
        return userDTOS;
    }

}
