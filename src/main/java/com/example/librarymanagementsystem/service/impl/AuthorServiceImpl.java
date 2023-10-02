package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
       Author aut = authorRepository.save(author);
       return "Author saved successfully!!";
    }

    public Author getAuthor(int id) {

        Optional<Author> opt = authorRepository.findById(id);
        if(opt.isEmpty()){
            throw new AuthorNotFoundException("Inavlid Author Id !!");
        }
        return opt.get();
    }

    public String updateAuthorEmail(int id, String email) {
        Optional<Author> optional = authorRepository.findById(id);
        if(optional.isEmpty()){
            throw new AuthorNotFoundException("Invalid Author Id");
        }
        Author author = optional.get();
        author.setEmailId(email);
        authorRepository.save(author); // updated email

        return "Author's email id updated Successfully";
    }
}
