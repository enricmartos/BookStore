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
import java.util.Locale;
import static practica4.BookCollection.readCatalog;

/**
 *
 * @author Enric
 */
public class ShoppingCart extends BookCollection implements ShoppingCartInterface {
    private Catalog catalog;
    private double totalPrice;
    
    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        //The class ShoppingCart has to add an instance of Stock to
        //its collection for each book in the catalog, initially with
        //a number of copies equal to 0 (representing the fact
        //that the user has not selected any copy).
        //Hauria de ser TRUE
        //catalog.parseCatalog(true); //Parsejem el Catalog
        
        //Posem copies a 0
        
        totalPrice = 0;
    }
    
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
            
            int copies = 0;
            
            Stock stock = new Stock(book, copies, price, currency);
            
            collection.add(stock); //Afegim l'stock creat al Hashet de BookCollection
        }
    }
    
    //USER MAKES AN ORDER
    //Afegir un nombre de còpies d'un cert llibre al carret vol dir que les estem 
    //treient de l'stock.
    @Override
    public void addCopies( int numberOfCopies, String booktitle ) {
	Stock stock = getStock( booktitle );
        //System.out.println(collection.size());
        stock.setCopies(numberOfCopies);
        //Fem el setter de copies a numberOfCopies
        totalPrice += stock.totalPrice();
        //System.out.println(totalPrice);
        //Restar el nombre de copies adquirides al carret al cataleg
        catalog.removeCopies(numberOfCopies, booktitle);
        
	//stock.removeCopies( numberOfCopies );
        //L'afegim al carret de compra, representat pel hashset colection heredat de
        //BookCollection
        //collection.add(stock);
    }

    //USER CANCELS AN ORDER
    //Treure un nombre de còpies d'un cert llibre del carret vol dir que les estem 
    //afegint (retornant) a l'stock.
    @Override
    public void removeCopies( int numberOfCopies, String booktitle ) {
	Stock stock = getStock( booktitle );
        //El cancel es fa sobre tota la comanda
        totalPrice = 0;
        //Si fos un cancel per cada llibre seria 
        //totalPrice -= numberOfCopies;
	catalog.addCopies( numberOfCopies, booktitle );
    }

    
    @Override
    public double totalPrice() {
        //Provisional
        //return 1000;
        return totalPrice;
    }
    
    @Override
    public String checkout() {
        //stock.removeCopies( numberOfCopies );
        // create a currency for uk locale
        Locale locale = Locale.GERMANY;
        Currency curr = Currency.getInstance(locale);
        return Payment.getTheInstance().doPayment(1234, "Rafel Martos", totalPrice() , curr );
    }
    
}
