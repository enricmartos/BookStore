/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Currency;

/**
 *
 * @author Enric
 */
public class Stock implements StockInterface {
    
    private Book book;
    private int copies;
    private double price;
    private Currency currency;
    
    public Stock(Book book, int copies, double price, Currency currency) {
        this.book = book;
        this.copies = copies;
        this.price = price;
        this.currency = currency;
    }
    
    public Book getBook() {
        return book;
    }

    @Override
    public String getBooktitle() {
        return book.getTitle();
    }

    @Override
    public int numberOfCopies() {
        return copies;
    }

    @Override
    public void addCopies(int numberOfCopies) {
        copies += numberOfCopies;
    }

    @Override
    public void removeCopies(int numberOfCopies) {
        copies -= numberOfCopies;
    }

    @Override
    public double totalPrice() {
        return price*copies;
    }
    
    //SETTERS
    public void setCopies(int numberOfCopies) {
        copies = numberOfCopies;
    }
    
}
