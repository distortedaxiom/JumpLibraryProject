package com.cognixia.jump.model;

import java.sql.Date;
import java.time.LocalDate;

public class Book {
    private int isbn;
    private String title;
    private String description;
    private boolean rented;
    private Date addedToLibrary;

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    private Date checkoutDate;
    private Date returnDate;

    public Book(int isbn, String title, String description, boolean rented, Date addedToLibrary) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.rented = rented;
        this.addedToLibrary = addedToLibrary;
    }

    public Book(int isbn, String title, String description) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
    }

    public Book(int isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public Book(int isbn, String title, Date checkOutDate, Date returnDate) {
        this.isbn = isbn;
        this.title = title;
        BookCheckout bookCheckout = new BookCheckout(checkOutDate, returnDate);
        this.checkoutDate = bookCheckout.getCheckOutDate();
        this.returnDate = bookCheckout.getReturnDate();
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Date getAddedToLibrary() {
        return addedToLibrary;
    }

    public void setAddedToLibrary(Date addedToLibrary) {
        this.addedToLibrary = addedToLibrary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rented=" + rented +
                ", addedToLibrary=" + addedToLibrary +
                '}';
    }
}
