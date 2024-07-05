package com.api.apilLibreria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name= "client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_client;
    @Column
    private String name_client;
    @Column
    private String last_name_client;
    @Column
    private Date birthday_client;
}
