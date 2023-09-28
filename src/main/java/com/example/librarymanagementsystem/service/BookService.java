package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.exception.BookNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public BookResponse addBook(BookRequest bookRequest) {


        // converting dto to Book Object(Model Object)
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPages(bookRequest.getPages());
        book.setGenre(bookRequest.getGenre());
        book.setCost(bookRequest.getCost());

        // finding author present or not
        Optional<Author> authorOptional = Optional.ofNullable(authorRepository.findBYEmail(bookRequest.getAuthorEmail()));
        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid Author Id");
        }

        Author author = authorOptional.get();
        book.setAuthor(author);
        author.getBooks().add(book);
        authorRepository.save(author); // saved both author and book

        //converting book(model) object to response dto
        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle(book.getTitle());
        bookResponse.setPages(book.getPages());
        bookResponse.setGenre(book.getGenre());
        bookResponse.setCost(book.getCost());
        bookResponse.setAuthorName(author.getName());

        return bookResponse;
    }

    public String deleteBook(int id) {
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isEmpty()){
            throw new BookNotFoundException("Invalid Book Id");
        }
        bookRepository.deleteById(id);
        return "Successfully Deleted";
    }

    public List<String> getBooksByGenreName(Genre genre) {
        //way 1
//       List<Book> books =  bookRepository.findAll();
//       List<String> titles = new ArrayList<>();
//       for(Book book : books){
//           if(book.getGenre().equals(genre)){
//               titles.add(book.getTitle());
//           }
//       }
//       return titles;

        //way2
        List<Book> books =  bookRepository.findByGenre(genre);
        List<String> titles = new ArrayList<>();
        for(Book book : books){
            titles.add(book.getTitle());
        }
        return titles;
    }
}
