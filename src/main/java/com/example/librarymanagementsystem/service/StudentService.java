package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse addStudent(StudentRequest studentRequest);
    StudentResponse getStudent(int regNo);
    Boolean deleteStudent(int regNo);
    List<String> getAllMales();
}
