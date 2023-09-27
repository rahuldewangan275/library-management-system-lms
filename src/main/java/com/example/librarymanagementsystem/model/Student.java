package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@FieldDefaults(level = AccessLevel.PRIVATE) // no need to weite private again and again
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
    public class Student{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int regNo; // primary key


    @Column(name = "student_info")
    String name;
    int age;
    @Column(unique = true , nullable = false)
    String email;
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "std",cascade = CascadeType.ALL) // "std is ref variable of obj of Student created in LibraryCard
    LibraryCard libraryCard;  // parent to child
}
