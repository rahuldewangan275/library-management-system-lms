package com.example.librarymanagementsystem.DTO.requestDTO;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    String name;
    int age;
    String emailId;
}
