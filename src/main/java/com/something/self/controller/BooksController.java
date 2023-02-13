package com.something.self.controller;

import com.something.self.model.Book;
import com.something.self.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all-books")
    List<Book> getAllBooks(){
        return bookService.FindAllBooks();
    }
    @GetMapping("/book-by-id/{id}")
    Book getBookById(@PathVariable int id){
        return  bookService.getBookById(id);
    }

    @GetMapping("/book-by-name/{name}")
    Book getBookByName(@PathVariable String name){
    return bookService.getBookByName(name);
    }

    @PostMapping("/save-books")
    void saveBooks(@Valid @RequestBody Book book ){
    bookService.saveBook(book);
    }

    @PutMapping("/update-book/{id}")
    Book updateBookById(@PathVariable int id,@RequestBody Book book){
    return  bookService.updateBook(id,book);
    }

    @DeleteMapping("/delete-book/{id}")
    void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}
