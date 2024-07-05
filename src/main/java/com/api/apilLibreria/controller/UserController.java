package com.api.apilLibreria.controller;

import com.api.apilLibreria.model.ClientModel;
import com.api.apilLibreria.model.DTO.FormCreateUser;
import com.api.apilLibreria.model.UserModel;
import com.api.apilLibreria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public String saveUser(@RequestBody FormCreateUser rq){
        this.userService.saveUser(rq);
        return "Usuario Creado Exitosamente!";
    }
}


