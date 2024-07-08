package com.api.apilLibreria.repository;

import com.api.apilLibreria.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUBookRepository extends JpaRepository<BookModel, Long> {
}
