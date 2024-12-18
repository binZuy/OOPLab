package hust.soict.dsai.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.CartScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private CartScreenController cartScreenController;
	
	public void setCartScreenController(CartScreenController cartScreenController) {
        this.cartScreenController = cartScreenController;
    }
	// add Media and Remove Media methods
	public void addMedia(Media media) throws LimitExceededException{
		if(itemsOrdered.size()< MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " is added successfully.");
		
		}
		else {
			throw new LimitExceededException("ERROR: The number of "+ "media has reached its limit");
		}
	}
	
	public void removeMedia(int id) {
		boolean found =false;
		for(Media media : itemsOrdered)
		{
			if(media.getId() == id) {
			System.out.println(media.getTitle() + " removed from the Cart.");
			found = true;
			itemsOrdered.remove(media);
			//notifyObservers();
			break;
			}
		}
		if(!found) {
			System.out.println("Media with id " + id + " is not found in the Cart.");
		}
	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
	}
	
	/* Tinh tong tien */
	public float totalCost() {
		float total= 0F;
		for (Media media : itemsOrdered) {//In ra list order
			//System.out.println((i+1)+"\t"+itemsOrdered[i].getTitle()+"\t"+itemsOrdered[i].getCost());
			total+= media.getCost();
		}
		return total;
	}
	
	// Method Overloading 
		public void addMedia(Media mediaList[]) {
			if(itemsOrdered.size() + mediaList.length <= MAX_NUMBERS_ORDERED) {
				for (int i = 0; i< mediaList.length ; i++) {
					itemsOrdered.add(mediaList[i]);
				}
				System.out.println("DVDs in the list are added.");
			}
			else 
				System.out.println("Your cart is almost full.");
		}
		
		public void addMedia(Media media1, Media media2) {
			if(itemsOrdered.size() + 2 <= MAX_NUMBERS_ORDERED) {
					itemsOrdered.add(media1);
					itemsOrdered.add(media2);
				System.out.println("DVD " + media1.getTitle()+ " and " + media2.getTitle() + 
						" are added.");
			}
			else 
				System.out.println("Your cart is almost full.");
		}
		
	// Tao method print Cart
		public void printCart() {
			System.out.println("********************Cart********************");
			System.out.println("Ordered Items:");
			for (Media media : itemsOrdered) {
				System.out.printf("%d. %s", media.getId(), media.toString());
				System.out.printf("\n");
			}
			System.out.printf("Total cost: %.2f $\n", totalCost());
			System.out.println("********************************************");
		}
		
		// Tim DVD bang ID
		public void searchById(int id) {
			for (Media media : itemsOrdered) {
				if (media.getId() == id) {
					System.out.println("Media found: " + media.toString());
					return;
				}
			}
			// Neu khong co dvd thoa man
			System.out.println("No matching Media found with ID "+ id);
		}
		
		// Tim DVD bang Title
		public void searchByTitle(String title) {
		        boolean found = false;
		        for (Media media : itemsOrdered) {
		            if (media.getTitle() == title ) {
		                System.out.println("Matching Media found: " + media.toString());
		                found = true;
		                break;
		            }
		        }
		        if (!found) { // Neu khong co dvd thoa man
		            System.out.println("No matching Media found with Title " + title);
		        }
		}
		
		// dem so DVD trong cart
		public int getNumberOfDVDsInCart() {
	        int dvdCount = 0;
	        for (Media media : itemsOrdered) {
	            if (media instanceof DigitalVideoDisc) {
	                dvdCount++;
	            }
	        }
	        return dvdCount;
	    }
		
		// Empty cart
		public void emptyCart() {
			itemsOrdered.clear();
			System.out.println("Your cart is empty now.");
		}
		
		// getItemsOrdered method
		public ObservableList<Media> getItemsOrdered() {
			return itemsOrdered;
		}
		
		private void notifyObservers() {
			if (cartScreenController != null) {
	            cartScreenController.updateTotalCost(this);
	        }
		}
}
	