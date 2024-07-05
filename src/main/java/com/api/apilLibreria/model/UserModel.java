package com.api.apilLibreria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@Data
@Entity
@Table(name = "user")

public class UserModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String state_account;
    @Column
    private Date account_creation_date;
    @Column
    private Integer fk_id_client;
    @Column
    private Integer try_counts = 0;
}
