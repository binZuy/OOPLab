package hust.soict.dsai.aims;

//import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import java.util.Collections;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.store.Store;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("---------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("---------------------------");
		System.out.println("Choose option from 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("---------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. back");
		System.out.println("---------------------------");
		System.out.println("Choose option from 0-1-2-3-4");
	}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("---------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("---------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("---------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("---------------------------");
		System.out.println("Choose option from 0-1-2-3-4-5");
	}
	
	public static void viewStore(Store store, Cart cart, Scanner scanner) {
		int choice;
	    do {
	    	storeMenu();
	    	System.out.print("Your choice: ");
	    	choice = scanner.nextInt();    
	    	switch (choice) {
	    	case 1:
	        // See a media's details
	    		seeMediaDetails(store, cart, scanner);
	    		break;
	        case 2:
	        // Add a media to cart
	        	addMediaToCart(store, cart, scanner);
	        	break;
	        case 3:
	        // Play a media
	        	//playMedia(store, scanner);
	        	break;
	        case 4:
	        // See current cart
	        	seeCurrentCart(store, cart, scanner);
	        	break;
	        case 0:
	        	System.out.println("Returning to the main menu.");
	        	break;
	        default:
	        System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 0);
	    }
		
	public static void seeMediaDetails(Store store,Cart cart, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();
		boolean found = false;
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				System.out.print("Media details:");
				System.out.println(media.toString());
		int mediaDetailsChoice;
		do {
			mediaDetailsMenu();
			System.out.print("Your choice: ");
			mediaDetailsChoice = scanner.nextInt();
			switch (mediaDetailsChoice) {
			case 1:
				addMediaToCart(store,cart,scanner);
				break;
			case 2: 
				// play 
				break; 
			case 0: 
				// back 
				System.out.println("Returning to the store menu. ");
				break;
			default: 
				System.out.println("Invalid choice, please choose again.");
			}
		}while(mediaDetailsChoice!=0);
		found = true;
		break;
			}
		}
		if (!found) {
			System.out.println("No media is found with the title"+ title);
		}
	}
	
	public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
		scanner.nextLine();
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();
		boolean found = false;
		for (Media media : store.getItemsInStore()) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				try {
					cart.addMedia(media);
				} catch (LimitExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No media is found with the title"+ title); 
		}
	}
    
    public static void seeCurrentCart(Store store, Cart cart, Scanner scanner) {
    	int seeCartChoice;
    	do {
    		cartMenu();
    		System.out.print("Your choice: ");
    		seeCartChoice = scanner.nextInt();
    		switch(seeCartChoice) {
    		case 1: 
    			filterCart(cart,scanner);
    			break;
    		case 2:
    			sortCart(cart,scanner);
    			break;
    		case 3: 
    			System.out.print("Enter the id to remove: ");
    			int id =scanner.nextInt();
    			cart.removeMedia(id);
    			break;
    		case 4: 
    			//playMedia(store,scanner);
    			break;
    		case 5: 
    			System.out.println("Your order is created.");
    			cart.emptyCart();
    			break;
    		default: 
    			System.out.println("Invalid choice, choose again.");    
    			}
    	}while(seeCartChoice!= 0);
    }
    
    public static void filterCart(Cart cart, Scanner scanner) {
    	int filterChoice;
    	do {
    		System.out.println("Option: ");
        	System.out.println("---------------------------");
        	System.out.println("1. Filter by title");
        	System.out.println("2. Filter by ID");
        	System.out.println("0. Back");
        	System.out.println("---------------------------");
        	System.out.println("Choose option from 0-1-2");
        	System.out.print("Your choice: ");
    		filterChoice = scanner.nextInt();
    		scanner.nextLine();
    		switch(filterChoice) {
    		case 1: 
    			System.out.print("Enter the title: ");
    			String title1 = scanner.nextLine();
    			cart.searchByTitle(title1);
    			break;
    		case 2: 
    			System.out.print("Enter the id: ");
    			int id = scanner.nextInt();
    			cart.searchById(id);
    			break;
    		case 0: 
    			System.out.println("Returning to the cart menu.");
    			break;
    		default: 
    			System.out.println("Invalid choice, choose again.");
    		}
    	}while(filterChoice!= 0);
    }
    
    public static void sortCart(Cart cart, Scanner scanner) {
    	int sortChoice;
    	do {
    		System.out.println("Option: ");
        	System.out.println("---------------------------");
        	System.out.println("1. Sort by title");
        	System.out.println("2. Sort by cost");
        	System.out.println("0. Back");
        	System.out.println("---------------------------");
        	System.out.println("Choose option from 0-1-2");
        	System.out.print("Your choice: ");
    		sortChoice = scanner.nextInt();
    		switch(sortChoice) {
    		case 1: 
    			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
    			for (Media med : cart.getItemsOrdered()) {
    				System.out.println(med.toString());
    			}
    			break;
    		case 2: 
    			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
    			for (Media med : cart.getItemsOrdered()) {
    				System.out.println(med.toString());
    			}
    			break;
    		case 0: 
    			System.out.println("Returning to the cart menu.");
    			break;
    		default: 
    			System.out.println("Invalid choice, choose again.");
    		}
    	}while(sortChoice!= 0);
    }
    
    public static void updateStore(Store store, Scanner scanner) {
    	int updateStoreChoice;
    	do {
    		System.out.println("Option: ");
        	System.out.println("---------------------------");
        	System.out.println("1. Add a media to store");
        	System.out.println("2. Remove a media from store");
        	System.out.println("0. Back");
        	System.out.println("---------------------------");
        	System.out.println("Choose option from 0-1-2");
        	System.out.print("Your choice: ");
    		updateStoreChoice = scanner.nextInt();
    		switch(updateStoreChoice) {
    		case 1: 
    			addMediatoStore(store,scanner);
    			break;
    		case 2: 
    			removeMediafromStore(store, scanner);
    			break;
    		case 0: 
    			System.out.println("Returning to the main menu.");
    			break;
    		default: 
    			System.out.println("Invalid choice, choose again.");
    		}
    	}while(updateStoreChoice!= 0);
    }
    
    public static void addMediatoStore(Store store, Scanner scanner) {
    	System.out.print("Enter the id of media: ");
    	int id = scanner.nextInt();    	
    	scanner.nextLine();
    	System.out.println("Enter the title of media: ");
    	String title = scanner.nextLine();
    	System.out.print("Enter the category of media: ");
    	String category = scanner.nextLine();
    	System.out.println("Enter the cost of media: ");
    	float cost = scanner.nextFloat();
    	scanner.nextLine();
    	System.out.println("Enter the media type: ");
    	System.out.println("1. DVD ");
    	System.out.println("2. CD");
    	System.out.println("3. Book");
    	System.out.print("Your choice: ");
    	int mediaChoice = scanner.nextInt();
    	switch(mediaChoice) {
    	case 1 : 
    		DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,cost);
    		dvd.setId(id);
    		store.addMedia(dvd);
    		break;
    	case 2 : 
    		System.out.print("Enter the lenght of CD: ");
    		int length = scanner.nextInt();
    		scanner.nextLine();
    		System.out.print("Enter the director of media: ");
        	String director = scanner.nextLine();
        	System.out.print("Enter the artist of media: ");
        	String artist = scanner.nextLine();
    		CompactDisc cd = new CompactDisc(id, title,category,cost,length,director,artist);
    		store.addMedia(cd);
    		break;
    	case 3 : 
    		Book book = new Book(id,title,category,cost);
    		System.out.print("Enter the number of authors: ");
    		int numb = scanner.nextInt();
    		scanner.nextLine();
    		for(int i = 0; i < numb; i++) {
    		System.out.print("Enter name of author: ");
    		String author = scanner.nextLine();
    		book.addAuthor(author);
    		}
    		store.addMedia(book);
    		break;
    	}
    }
    
    public static void removeMediafromStore(Store store, Scanner scanner) {
    	System.out.print("Enter the id to remove: ");
    	int id = scanner.nextInt();
    	store.removeMedia(id);
    }
    
		public static void main(String[] args) {
			// TODO Auto-generated method stub 
			Scanner scanner = new Scanner(System.in);
			Store store = new Store(20);
			Cart cart = new Cart();
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
		        		"Animation", "Roger Allers", 87, 19.95f);
		    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
		        		"Science Fiction", "George Lucas", 87, 24.95f);
		    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
		        		"Animation", 18.99f);		// Them moi 1 dvd
		    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers 1", 
		        		"Action", "Joss Whedon", 87, 20.55f);	// Them moi 1 dvd
		    DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers 2", 
		        		"Action", "Joss Whedon", 87, 20.55f);	// Them moi 1 dvd
		    DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers 3", 
		        		"Action", "Joss Whedon", 87, 20.55f);
		    Book book1 = new Book(7, "Test Java", "Research", 20.5f);
		    Book book2 = new Book(8, "Test Java 2", "Research", 22f);
		    book1.addAuthor("BinZuy");
		    book1.addAuthor("Minh Duy");
		    book2.addAuthor("Duy Minh");
		    book2.addAuthor("N.M.D");
		    CompactDisc cd1 = new CompactDisc(9, "Learning English", "Studying", 19.54f, 50, "Binzuy", "Minh Duy");
		    Track track1 = new Track("Learning English", 25);
		    Track track2 = new Track("Learning English 2", 25);
		    cd1.addTrack(track1);
		    CompactDisc cd2 = new CompactDisc(10, "Learning English 2", "Studying", 19.55f, 50, "Binzuy", "Minh Duy");
		    cd2.addTrack(track2);		
			store.addMedia(dvd1);
			store.addMedia(dvd2);
			store.addMedia(dvd3);
			store.addMedia(dvd4);
			store.addMedia(dvd5);
			store.addMedia(dvd6);
			store.addMedia(book1);
			store.addMedia(book2);
			store.addMedia(cd1);
			store.addMedia(cd2);
			store.displayItemsInStore();
			 int choice;
		        do {
		            showMenu();
		            System.out.print("Your choice: ");
		            choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    viewStore(store, cart, scanner);
		                    break;
		                case 2:
		                    updateStore(store, scanner);
		                    break;
		                case 3:
		                    seeCurrentCart(store, cart, scanner);
		                    break;
		                case 0:
		                    System.out.println("Exiting AIMS. Goodbye!");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		            }
		        } while (choice != 0);
		        scanner.close();
		}
}
