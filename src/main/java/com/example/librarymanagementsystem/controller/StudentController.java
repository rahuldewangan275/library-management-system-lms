package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse response = studentServiceImpl.addStudent(studentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-info")
    public ResponseEntity getStudent (@RequestParam("id") int regNo){
        StudentResponse response = studentServiceImpl.getStudent(regNo);
        if(response != null){
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }
       return new ResponseEntity<>("invalid regNo!!",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("regNo") int regNo){
        Boolean response = studentServiceImpl.deleteStudent(regNo);
        if(response == true ){
            return new ResponseEntity<>("successfully Deleted", HttpStatus.FOUND);
        }
        return new ResponseEntity<>("regNo not found",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-all-males")
    public List<String> getAllMales(){
        List<String> li = studentServiceImpl.getAllMales();
        return li;
    }
}
