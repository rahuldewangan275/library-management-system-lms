package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add-author")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String response = authorService.addAuthor(author);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/get-author-by-id")
    public ResponseEntity getAuthor(@RequestParam int id){
        Author response = authorService.getAuthor(id);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    //update email id of an author
    @PutMapping("/update-author-email")
    public String updateAuthorEmail(@RequestParam("id") int id, @RequestParam("email") String email){
     try {
         String response = authorService.updateAuthorEmail(id, email);
         return response;
     }catch(AuthorNotFoundException e){
         return e.getMessage();
     }
    }
}
