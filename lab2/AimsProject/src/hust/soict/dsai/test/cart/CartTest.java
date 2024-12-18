package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.cart.Cart;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
        		"Animation", "Roger Allers", 87, 19.95f);// Tao moi 1 dvd
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
        		"Science Fiction", "George Lucas", 87, 24.95f);// Tao moi 1 dvd
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
        		"Animation", 18.99f);		// Tao moi 1 dvd
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers 1", 
        		"Action", "Joss Whedon", 87, 20.55f);	// Tao moi 1 dvd
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers 2", 
        		"Action", "Joss Whedon", 87, 20.55f);	// Tao moi 1 dvd
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers 3", 
        		"Action", "Joss Whedon", 87, 20.55f);	// Tao moi 1 dvd
        DigitalVideoDisc dvdList[] = {dvd1,dvd2,dvd3,dvd4,dvd5,dvd6};
        cart.addMedia(dvdList);	// Them 1 list dvd vao gio hang
        cart.printCart();
        System.out.println("Search DVD by ID: 2");
        cart.searchById(2);
        System.out.println("Search DVD by ID: 7");
        cart.searchById(7);
        System.out.println("Search DVD by Title: Avengers 2");
        cart.searchByTitle("Avengers 1");
        System.out.println("Search DVD by Title: Avengers 4");
        cart.searchByTitle("Avengers 4");
	}

}
