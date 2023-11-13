package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.disc.*;

public class Aims {

		public static void main(String[] args) {
			// TODO Auto-generated method stub 
			Cart anOrder = new Cart();
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
	        		"Animation", "Roger Allers", 87, 19.95f);
	        anOrder.addDigitalVideoDisc(dvd1); // Them moi 1 dvd 
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
	        		"Science Fiction", "George Lucas", 87, 24.95f);
	        anOrder.addDigitalVideoDisc(dvd2); // Them moi 1 dvd
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
	        		"Animation", 18.99f);		// Them moi 1 dvd
	        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers 1", 
	        		"Action", "Joss Whedon", 87, 20.55f);	// Them moi 1 dvd
	        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers 2", 
	        		"Action", "Joss Whedon", 87, 20.55f);	// Them moi 1 dvd
	        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers 3", 
	        		"Action", "Joss Whedon", 87, 20.55f);	// Them moi 1 dvd
	        DigitalVideoDisc dvdList[] = {dvd4,dvd5};
	        anOrder.addDigitalVideoDisc(dvd3); 
	        anOrder.addDigitalVideoDisc(dvdList); // Them 1 list cac dvd
	        anOrder.removeDigitalVideoDisc(dvd3); // Xoa 1 dvd
	        anOrder.addDigitalVideoDisc(dvd3, dvd6);	// Them 2 dvd rieng le
	        System.out.println("Total Cost is: " + anOrder.totalCost());// In ra tong tien
		}
}
