package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Author;

public interface AuthorService {
    String addAuthor(Author author);

    Author getAuthor(int id);

    String updateAuthorEmail(int id, String email);
}
