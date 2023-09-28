package com.example.librarymanagementsystem.DTO.requestDTO;

import com.example.librarymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    String name;
    int age;
    String email;
    Gender gender;
}
