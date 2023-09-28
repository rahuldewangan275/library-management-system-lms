package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query("select b from Author b where b.emailId = :email")
    Author findBYEmail(String email);
}
