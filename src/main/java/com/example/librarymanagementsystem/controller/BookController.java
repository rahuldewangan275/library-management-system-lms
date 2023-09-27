package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.exception.BookNotFoundException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add-book")
    public ResponseEntity addBook(@RequestBody  Book book){
        try{
            String response = bookService.addBook(book);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(AuthorNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

// delete a book

    @DeleteMapping("/delete-book")
    public String deleteBook(@RequestParam("id") int id){
        try{
            String response = bookService.deleteBook(id);
            return response;
        }catch(BookNotFoundException e){
            return e.getMessage();
        }
    }
    // give me names of all the books of a perticular genre

    @GetMapping("/get-books-by-genre-name")
    public List<String>getBooksByGenreName(@RequestParam("genre") Genre genre){

            List<String> books = bookService.getBooksByGenreName(genre);
            return books;

    }
    // books cost more than 500
    //no of pages b/w a and b
    // name of all authors who write perticular genre








}
