package com.example.librarymanagementsystem.service;

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
    public String addStudent(Student student) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
      libraryCard.setStd(student);

        student.setLibraryCard(libraryCard);
        Student response = studentRepository.save(student);
        if(response != null){
            return "student added Successfully";
        }
        return "student not added";
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
