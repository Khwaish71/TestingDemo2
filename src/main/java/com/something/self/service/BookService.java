package com.something.self.service;

import com.something.self.model.Book;

import java.util.List;

public interface BookService {
    List<Book> FindAllBooks();

    Book getBookById(int id);

    Book getBookByName(String name);

    void saveBook(Book book);

    Book updateBook(int id, Book book);

    void deleteBook(int id);
}
