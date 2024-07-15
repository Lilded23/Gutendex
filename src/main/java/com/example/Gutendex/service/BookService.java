package com.example.Gutendex.service;

import com.example.Gutendex.client.GutendexClient;
import com.example.Gutendex.model.Book;
import com.example.Gutendex.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final GutendexClient gutendexClient;

    public BookService(BookRepository bookRepository, GutendexClient gutendexClient) {
        this.bookRepository = bookRepository;
        this.gutendexClient = gutendexClient;
    }

    public List<Book> searchAndSaveBookByTitle(String title) {
        try {
            Book book = gutendexClient.searchBookByTitle(title);
            bookRepository.save(book);
            return List.of(book);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}
