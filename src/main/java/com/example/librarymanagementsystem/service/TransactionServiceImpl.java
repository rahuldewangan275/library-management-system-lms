package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.responseDTO.IssueBookResponse;
import com.example.librarymanagementsystem.Enum.TransactionStatus;
import com.example.librarymanagementsystem.exception.BookNotAvailableException;
import com.example.librarymanagementsystem.exception.BookNotFoundException;
import com.example.librarymanagementsystem.exception.StudentNotFoundException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.model.Transaction;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentRepository studentRepository;

    public IssueBookResponse issueBook(int bookId, int studentId) {
               //check book present or not
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("Error:Invalid Book Id");
        }

                //check student
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isEmpty()){
         throw new StudentNotFoundException("Invalid Student Id");
        }

        if(optionalBook.get().isIsIssued()){ // if true
            throw new BookNotAvailableException("Book is Already Issued");
        }

        Book book = optionalBook.get();
        Student student = optionalStudent.get();
        LibraryCard libraryCard = student.getLibraryCard();
        // transaction occur
        Transaction transaction =  Transaction.builder()
                                  .transactionNum(String.valueOf(UUID.randomUUID()))
                                  .transactionStatus(TransactionStatus.SUCCESS)
                                  .book(book)
                                  .libraryCard(libraryCard)
                                  .build();

         Transaction savedTransaction = transactionRepository.save(transaction);

         //update Book
         book.setIsIssued(true);
         book.getTransactions().add(savedTransaction);
         // card changes
         libraryCard.getTransactions().add(transaction);
         student.getLibraryCard().getTransactions().add(transaction);

        Student savedStudent = studentRepository.save(student); // student and transaction
        Book savedBook = bookRepository.save(book); //  book and transaction

        //prepare response
        return IssueBookResponse.builder()
                .transactionNum(savedTransaction.getTransactionNum())
                .date(savedTransaction.getDate())
                .transactionStatus(savedTransaction.getTransactionStatus())
                .bookName(savedBook.getTitle())
                .authorName(savedBook.getAuthor().getName())
                .cardNo(savedStudent.getLibraryCard().getCardNo())
                .studentName(savedStudent.getName())
                .build();
    }
}
