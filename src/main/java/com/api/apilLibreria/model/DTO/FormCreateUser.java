package com.api.apilLibreria.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class FormCreateUser {
    private String name_client;
    private String last_name_client;
    private Date birthday_client;
    private String username;
    private String password;
    private String email;
    private Date account_creation_date;
    private String state_account;
}
