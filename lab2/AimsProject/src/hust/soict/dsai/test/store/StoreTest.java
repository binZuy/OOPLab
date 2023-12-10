package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.store.*;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store(3);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
        		"Animation", "Roger Allers", 87, 19.95f);// Tao moi 1 dvd
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
        		"Science Fiction", "George Lucas", 87, 24.95f);// Tao moi 1 dvd
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
        		"Animation", 18.99f);		// Tao moi 1 dvd
        // Them DVD vao cua hang
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        // Hien thi danh sach DVD trong cua hang
        store.displayItemsInStore();
        
        // Xoa 1 DVD trong danh sach cua hang
        store.removeMedia(2);
        store.removeMedia(4);
        
        // Hien thi DVD
        store.displayItemsInStore();
	}

}
