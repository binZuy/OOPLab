package hust.soict.dsai.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;


public class Store {
		private ArrayList<Media> itemsInStore = new ArrayList<Media>();
		
		public Store(int capacity) {// So luong DVD trong Cua hang
			itemsInStore = new  ArrayList<Media>();
		}
		
		// Them DVD vao danh sach DVD trong cua hang
		public void addMedia(Media media) {
				if(itemsInStore.add(media)) {
				System.out.println("Media added to store: " + media.toString());
				}
			else 
				System.out.println("Store is full. Cannot add more.");
		}
		
		// Xoa DVD trong danh sach cua cua hang
		public void removeMedia(int id) {
			for (Media media : itemsInStore) {
				if(media.getId() == id) {
					itemsInStore.remove(media);
					System.out.println("Media removed from store: " + media.toString());
					return;
				}
			}
			System.out.println("No matching DVD found in store with ID " + id);
		}
		
		// Hien thi so DVD trong cua hang
		public void displayItemsInStore() {
			System.out.println("List in the store: ");
			for (Media media: itemsInStore) { 
					System.out.println(media.getId() + ". " + media.toString());
			}
		}
}
		
