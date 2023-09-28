package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setGender(studentRequest.getGender());
        student.setEmail(studentRequest.getEmail());


        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStd(student);

        student.setLibraryCard(libraryCard);

        Student response = studentRepository.save(student);

        if(response != null){
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setAge(student.getAge() );
            studentResponse.setName(response.getName());
            studentResponse.setMessage("student added successfully");
            return studentResponse;
        }
        return null;
    }


    public Student getStudent(int regNo) {
        try{
            Optional<Student> optional = studentRepository.findById(regNo);
            if(optional.isPresent()){
                return optional.get(); // return Student Object
            }
        }catch(Exception e){
            return null;
        }

        return null;
    }

    public Boolean deleteStudent(int regNo) {
        // delete when present
        Optional<Student> optional = studentRepository.findById(regNo);
        if(optional.isPresent()){
            studentRepository.deleteById(regNo);
            return true;
        }
        return false;
    }

    public List<String> getAllMales() {
        List<Student> li = studentRepository.findByGender(Gender.MALE);
        List<String> students = new ArrayList<>();
        for(Student std : li){
            String nameOfStudent = std.getName();
            students.add(nameOfStudent);
        }
        return students;
    }
}
