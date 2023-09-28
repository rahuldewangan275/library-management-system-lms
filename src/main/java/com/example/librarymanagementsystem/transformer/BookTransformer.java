package com.example.librarymanagementsystem.transformer;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.model.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookTransformer {
    public static Book BookRequestToBook(BookRequest bookRequest){
        return Book.builder()
                .title(bookRequest.getTitle())
                .pages(bookRequest.getPages())
                .genre(bookRequest.getGenre())
                .cost(bookRequest.getCost())
                .build();
    }

    public static BookResponse BookToBookResponse(Book book){
        return BookResponse.builder()
                .title(book.getTitle())
                .pages(book.getPages())
                .genre(book.getGenre())
                .cost(book.getCost())
                .authorName(book.getAuthor().getName())
                .build();
    }
}
