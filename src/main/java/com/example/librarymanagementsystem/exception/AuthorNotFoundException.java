package com.example.librarymanagementsystem.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String msg){
        super(msg);
    }
}
