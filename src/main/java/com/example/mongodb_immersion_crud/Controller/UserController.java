package com.example.mongodb_immersion_crud.Controller;


import com.example.mongodb_immersion_crud.Models.User;
import com.example.mongodb_immersion_crud.Service.UserService;
import com.example.mongodb_immersion_crud.dto.UserWithAddressesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping(value = "/api/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping(value = "/api/user")
    public User saveUserWithAddresses(@RequestBody UserWithAddressesDTO userWithAddressesDTO) {
        return service.saveUserWithAddresses(userWithAddressesDTO);
    }



    @PutMapping("/{id}")
    public User updateUserWithAddress(@PathVariable String id, @RequestBody UserWithAddressesDTO userWithAddressesDTO) {
        System.out.print(userWithAddressesDTO);
        return service.updateUserWithAddresses(id, userWithAddressesDTO);
    }


}
