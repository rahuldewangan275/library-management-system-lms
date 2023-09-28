package com.example.librarymanagementsystem.DTO.requestDTO;

import com.example.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    String title;
    int pages;
    Genre genre;
    double cost;
    String authorEmail;
}
