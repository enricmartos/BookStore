/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author Enric
 */
public class TestStore {
        public static void main(String[] args) {
            Catalog catalog = new Catalog();
            ShoppingCart shoppingCart = new ShoppingCart(catalog);
            
            BookStore bookstore = new BookStore(catalog, shoppingCart);
        }
    
}
