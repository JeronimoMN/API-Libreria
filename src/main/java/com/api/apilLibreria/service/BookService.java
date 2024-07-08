package com.api.apilLibreria.service;

import com.api.apilLibreria.model.BookModel;
import com.api.apilLibreria.repository.IUBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    private IUBookRepository bookRepository;

    public ArrayList<BookModel> getAllBooks() {
        return (ArrayList<BookModel>) bookRepository.findAll();
    }

    public BookModel saveBook(BookModel rq) {
        return bookRepository.save(rq);
    }

    public BookModel updateBookById(BookModel rq) {
        BookModel book = new BookModel();

        book = bookRepository.getReferenceById(rq.getId_book());
        book.setTitle_book(rq.getTitle_book());
        book.setSynopsis_book(rq.getSynopsis_book());
        book.setAmount_book(rq.getAmount_book());
        book.setState_book(rq.getState_book());
        book.setPrice_book(rq.getPrice_book());
        book.setFk_id_autor(rq.getFk_id_autor());

        return bookRepository.save(book);
    }

    public void deleteBook(Long rq) {
        bookRepository.deleteById(rq);
    }
}