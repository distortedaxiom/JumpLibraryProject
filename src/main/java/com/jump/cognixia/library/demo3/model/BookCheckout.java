package com.jump.cognixia.library.demo3.model;

import java.sql.Date;

public class BookCheckout {
    private int checkoutId;
    private int patronId;
    private int isbn;
    private Date checkOutDate;
    private Date dueDate;
    private Date returnDate;

    public BookCheckout(int checkoutId, int patronId, int isbn, Date checkOutDate, Date dueDate, Date returnDate) {
        this.checkoutId = checkoutId;
        this.patronId = patronId;
        this.isbn = isbn;
        this.checkOutDate = checkOutDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public BookCheckout(Date checkOutDate, Date returnDate) {
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
    }

    public BookCheckout() {

    }

    public int getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(int checkoutId) {
        this.checkoutId = checkoutId;
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BookCheckout{" +
                "checkoutId=" + checkoutId +
                ", patronId=" + patronId +
                ", isbn=" + isbn +
                ", checkOutDate=" + checkOutDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
