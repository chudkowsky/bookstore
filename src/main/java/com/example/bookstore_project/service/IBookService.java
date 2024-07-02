package com.example.bookstore_project.service;

import com.example.bookstore_project.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    void saveOrUpdate(Book book);
    Optional<Book> getById(int id);
    List<Book> getAll();
    void delete(int id);
}
