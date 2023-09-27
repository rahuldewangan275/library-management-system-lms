package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

 String name;

 int age;

 @Column(unique = true, nullable = false)
 String emailId;


 @UpdateTimestamp
Date lastActivity;

 @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
 List<Book> books = new ArrayList<>();


}
