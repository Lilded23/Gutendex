package com.example.Gutendex.repository;


import com.example.Gutendex.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
