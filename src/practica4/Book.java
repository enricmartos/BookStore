/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Date;

/**
 *
 * @author Enric
 */
public class Book {
    private String title;
    private String author;
    private Date publicationDate;
    private String publicationPlace;
    private long ISBN;
    
    public Book(String title, String author, Date publicationDate, String publicationPlace, long ISBN) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.publicationPlace = publicationPlace;
        this.ISBN = ISBN;
    }
    //GETTERS
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Date getPublicationDate() {
        return publicationDate;
    }
    
    public String getPublicationPlace() {
        return publicationPlace;
    }
    
    public long getISBN() {
        return ISBN;
    }

    

}
