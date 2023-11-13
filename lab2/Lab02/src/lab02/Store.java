package lab02;

public class Store {
		private DigitalVideoDisc[] itemsInStore;
		private int itemCount;
		
		public Store(int capacity) {// So luong DVD trong Cua hang
			itemsInStore = new DigitalVideoDisc[capacity];
			itemCount =0;
		}
		
		// Them DVD vao danh sach DVD trong cua hang
		public void addDVD(DigitalVideoDisc dvd) {
			if (itemCount < itemsInStore.length) {
				itemsInStore[itemCount++] = dvd;
				System.out.println("DVD added to store: " + dvd.toString());
			}
			else 
				System.out.println("Store is full. Cannot add more DVDs.");
		}
		
		// Xoa DVD trong danh sach cua cua hang
		public void removeDVD(int id) {
			for (int i =0 ; i<itemsInStore.length ; i++) {
				if(itemsInStore[i] != null && itemsInStore[i].getId() == id) {
					System.out.println("DVD removed from store: " + itemsInStore[i].toString());
					for (int j =i; j <itemCount-1; j++) {
						itemsInStore[j] = itemsInStore[j+1];
					}
					itemsInStore[itemCount-1] = null;
					itemCount--;
					return;
				}
			}
			System.out.println("No matching DVD found in store with ID " + id);
		}
		
		// Hien thi so DVD trong cua hang
		public void displayItemsInStore() {
			for (int i = 0; i <itemCount ; i++) {
				if (itemsInStore[i] != null) {
					System.out.println((i+1) + ". " + itemsInStore[i].toString());
				}
			}
		}
}
		
