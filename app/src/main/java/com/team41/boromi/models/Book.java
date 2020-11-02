package com.team41.boromi.models;

import androidx.annotation.Nullable;

import static com.team41.boromi.constants.CommonConstants.BookStatus;
import static com.team41.boromi.constants.CommonConstants.BookWorkflowStage;

import java.io.Serializable;
import java.util.UUID;

/**
 * A model class storing an information on the book And on which stage the book is currently in
 */
public class Book implements Serializable {

  // SerialVersionUID generated by Android Studio
  private static final long serialVersionUID = -5427418813071062937L;

  private String img64;
  private String bookId = UUID.randomUUID().toString();
  private String owner;
  private String borrower;
  private String ISBN;
  private String title;
  private String author;
  private String desc;
  private BookStatus status;
  private BookWorkflowStage workflow;

  // TODO
  // I didn't include logic for the requesters/borrowers/img/location
  // To allow the person implementing that logic to decide how they want to do it.
  // You can go through the BookRequests, then only do a read on DB
  // If a user wants more info on a book, or you can store all the requester usernames here..
  // And wipe them on each acceptance.

  /**
   * A no-argument constructor required by firestore to serialize data
   */
  public Book() {
  }

  public Book(String owner, String title, String author, String ISBN) {
    this.owner = owner;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.bookId = UUID.randomUUID().toString();
    this.borrower = null;
    this.status = BookStatus.AVAILABLE;
    this.workflow = BookWorkflowStage.AVAILABLE;
  }

  public Book(String owner, String title, String author, String ISBN, BookStatus status) {
    this.owner = owner;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.status = status;
    this.bookId = UUID.randomUUID().toString();
    this.borrower = null;
    this.workflow = BookWorkflowStage.AVAILABLE;
  }

  public Book(String owner, String title, String author, String ISBN, BookWorkflowStage workflow) {
    this.owner = owner;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.workflow = workflow;
    this.bookId = UUID.randomUUID().toString();
    this.borrower = null;
    this.status = BookStatus.AVAILABLE;
  }

  /**
   * When UUID not specified, we generate a random UUID to identify the book
   *
   * @param owner
   */
  public Book(String owner) {
    this.bookId = UUID.randomUUID().toString();
    this.owner = owner;
    this.status = BookStatus.AVAILABLE;
    this.workflow = BookWorkflowStage.AVAILABLE;
  }

  public Book(String owner, String bookId) {
    this.bookId = bookId;
    this.owner = owner;
    this.status = BookStatus.AVAILABLE;
  }

  public Book(
          String owner,
          String title,
          String author,
          String ISBN,
          BookStatus status,
          BookWorkflowStage workflow
  ) {
    this.owner = owner;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.status = status;
    this.workflow = workflow;
    this.bookId = UUID.randomUUID().toString();
    this.borrower = null;
  }

  public Book(
          String owner,
          String title,
          String author,
          String ISBN,
          BookStatus status,
          String borrower
  ) {
    this.owner = owner;
    this.borrower = borrower;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.status = status;
    this.bookId = UUID.randomUUID().toString();
    this.workflow = BookWorkflowStage.AVAILABLE;
  }

  public Book(
          String owner,
          String title,
          String author,
          String ISBN,
          BookWorkflowStage workflow,
          String borrower
  ) {
    this.owner = owner;
    this.borrower = borrower;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.workflow = workflow;
    this.bookId = UUID.randomUUID().toString();
    this.status = BookStatus.AVAILABLE;
  }

  public Book(
          String owner,
          String title,
          String author,
          String ISBN,
          BookStatus status,
          BookWorkflowStage workflow,
          String borrower
  ) {
    this.owner = owner;
    this.borrower = borrower;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.workflow = workflow;
    this.status = status;
    this.bookId = UUID.randomUUID().toString();
  }

  // Setters / Getters Start
  public String getBookId() {
    return bookId;
  }

  public String getOwner() {
    return owner;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public BookStatus getStatus() {
    return status;
  }

  public void setStatus(BookStatus status) {
    this.status = status;
  }

  public BookWorkflowStage getWorkflow() {
    return workflow;
  }

  public void setWorkflow(BookWorkflowStage workflow) {
    this.workflow = workflow;
  }

  public String getBorrower() {
    return borrower;
  }

  public void setBorrower(String borrower) {
    this.borrower = borrower;
  }

  public String getImg64() {
    return img64;
  }

  public void setImg64(String img64) {
    this.img64 = img64;
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    if(obj instanceof String) {
      if(bookId.compareTo((String) obj) == 0) {
        return true;
      }
    } else if (obj instanceof Book) {
      if(bookId.compareTo(((Book) obj).getBookId()) == 0) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    return bookId.hashCode();
  }
}
