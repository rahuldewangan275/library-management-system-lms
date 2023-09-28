package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService ;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse response = studentService.addStudent(studentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-info")
    public ResponseEntity getStudent (@RequestParam("id") int regNo){
        Student response = studentService.getStudent(regNo);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }
       return new ResponseEntity<>("invalid regNo!!",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("regNo") int regNo){
        Boolean response = studentService.deleteStudent(regNo);
        if(response == true ){
            return new ResponseEntity<>("successfully Deleted", HttpStatus.FOUND);
        }
        return new ResponseEntity<>("regNo not found",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-all-males")
    public List<String> getAllMales(){
        List<String> li = studentService.getAllMales();
        return li;
    }
}
