package com.api.apilLibreria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id_book;
    @Column
    private String title_book;
    @Column
    private String synopsis_book;
    @Column
    private String amount_book;
    @Column
    private String state_book;
    @Column
    private String price_book;
    @Column
    private Integer fk_id_autor;
}
