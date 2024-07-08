package com.api.apilLibreria.controller;

import com.api.apilLibreria.model.BookModel;
import com.api.apilLibreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ArrayList<BookModel> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookModel addBook(@RequestBody BookModel rq){
        return this.bookService.saveBook(rq);
    }

    @PutMapping
    public BookModel updateBook(@RequestBody BookModel rq){
        return this.bookService.updateBookById(rq);
    }

    @DeleteMapping
    public String deleteBook(@RequestBody Long rq){
        this.bookService.deleteBook(rq);
        return "Book deleted successfully";
    }
}