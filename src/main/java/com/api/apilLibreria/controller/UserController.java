package com.api.apilLibreria.controller;

import com.api.apilLibreria.model.DTO.FormCreateUser;
import com.api.apilLibreria.model.DTO.LoginDTO;
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

    @PostMapping("validateUser")
    public String validateUser(@RequestBody LoginDTO rq){
        String username = rq.getUsername();
        String password = rq.getPassword();

        boolean isValid = userService.validate_user_pass(username, password);

        if(isValid){
            return "valid";
        }else {
            return "invalid";
        }
    }
}