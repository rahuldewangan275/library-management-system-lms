package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.Enum.Genre;

import java.util.List;

public interface BookService { // create documentation
    BookResponse addBook(BookRequest bookRequest);
    String deleteBook(int id);
    List<String> getBooksByGenreName(Genre genre);
}
