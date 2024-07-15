package com.example.Gutendex.controller;

import com.example.Gutendex.model.Book;
import com.example.Gutendex.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam String title) {
        return bookService.searchAndSaveBookByTitle(title);
    }
}
