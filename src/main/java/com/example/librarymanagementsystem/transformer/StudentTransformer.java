package com.example.librarymanagementsystem.transformer;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.model.Student;
import lombok.experimental.UtilityClass;

@UtilityClass // utility class is a class which can not be instantiated
public class StudentTransformer {
    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return Student.builder().name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }
    public static StudentResponse StudentToStudentResponse(Student student){
        // using builder to make our work easy. convert Student to StudentResponse
        return StudentResponse.builder()
                .name(student.getName())
                .age(student.getAge())
                .message("Successful")
                .build();
    }
}
