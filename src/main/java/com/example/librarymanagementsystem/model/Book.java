package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String title;

    int pages;

    @Enumerated(EnumType.STRING)
    Genre genre;

    double cost;

    boolean IsIssued;

    @ManyToOne
    @JoinColumn // adding fk
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
