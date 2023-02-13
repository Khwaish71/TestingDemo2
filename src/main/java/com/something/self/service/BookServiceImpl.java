package com.something.self.service;

import com.something.self.model.Book;
import com.something.self.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Book> FindAllBooks() {
        return libraryRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> book2= libraryRepository.findById(id);
        return book2.get();
    }

    @Override
    public Book getBookByName(String name) {
        return libraryRepository.findByName(name);

    }
    @Override
    public void saveBook(Book book) {
        libraryRepository.save(book);
    }

    @Override
    public Book updateBook(int id,Book book) {
    Book book2=libraryRepository.findById(id).get();
    book2.setAuthor(book.getAuthor());
    book2.setName(book.getName());
    return libraryRepository.save(book2);
    }

    @Override
    public void deleteBook(int id) {
    libraryRepository.deleteById(id);
    }
}
