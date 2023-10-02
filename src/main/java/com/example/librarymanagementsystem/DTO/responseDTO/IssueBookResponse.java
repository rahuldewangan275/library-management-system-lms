package com.example.librarymanagementsystem.DTO.responseDTO;

import com.example.librarymanagementsystem.Enum.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueBookResponse {

    String transactionNum; //UUID
    Date date;
    TransactionStatus transactionStatus;

    // book details to show
    String bookName;
    String authorName;

    //Library Card details to show
    String cardNo; // random number generated
     String studentName;

}
