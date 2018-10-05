/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Enric
 */
public class Catalog extends BookCollection {
    
    public Catalog() {}
    
    public void parseCatalog() {
        LinkedList< String[] > books = new LinkedList< String[] >();
        books = readCatalog("books.xml");
        
        //Llegim per columnes
        for(int i = 0; i < books.size(); i++) {
            String title = books.get(i)[0];
            String author = books.get(i)[1];
            Date date = new Date();
            try { 
                date = new SimpleDateFormat().parse( books.get(i)[2] ); 
            } // Date instance
            catch( Exception e ) {
            }
            String publicationPlace = books.get(i)[3];
            long ISBN = Long.parseLong( books.get(i)[4] ); // convert to long
            
            Book book = new Book(title, author, date, publicationPlace, ISBN);
            
            double price = Double.parseDouble( books.get(i)[5] ); // convert to double
            Currency currency = Currency.getInstance( books.get(i)[6] ); // Currency instance
            
            
            int copies = Integer.parseInt( books.get(i)[7] );
             // convert to int
            
            Stock stock = new Stock(book, copies, price, currency);
            
            collection.add(stock); //Afegim l'stock creat al Hashet de BookCollection
        }
    }
    
    public void printCatalog() {
        // create an iterator
        Iterator iterator = collection.iterator(); 
        // check values
        while (iterator.hasNext()){
            System.out.println("Value: "+ iterator.next() + " ");  
        }
    }
    
}
