package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String title;

    int pages;

    @Enumerated(EnumType.STRING)
    Genre genre;

    double cost;

    boolean issued;

    @ManyToOne
    @JoinColumn // adding fk
    Author author;
}