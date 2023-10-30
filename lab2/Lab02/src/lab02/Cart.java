package lab02;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {	// kiem tra xem so luong >20 hay ko
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("DVD " + disc.getTitle() + " is added");	// Them DVD thanh cong
		}
		else 
			System.out.println("Cart is full");	// Khong them dc DVD
	}
	
	/* Xoa phan tu i trong itemsOrder roi day cac phan tu sau len*/
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {	
		if(qtyOrdered > 0) {
			for (int i =0; i< qtyOrdered; i++) {
				if (itemsOrdered[i].equals(disc)) {	// Neu co trong gio 
					for (int j = i; j<qtyOrdered -1 ; j++) 		
						itemsOrdered[j] = itemsOrdered[j+1];
					qtyOrdered--;
					System.out.println("DVD " + itemsOrdered[i].getTitle() + " is removed");
					return;
				}
			}
		}
		else 
			System.out.println("Your cart is empty, cant be removed"); // Neu gio empty
	}
	
	/* Tinh tong tien */
	public float totalCost() {
		float total= 0F;
		for (int i =0 ; i < qtyOrdered; i++ ) {//In ra list order
			System.out.println((i+1)+"\t"+itemsOrdered[i].getTitle()+"\t"+itemsOrdered[i].getCost());
			total+= itemsOrdered[i].getCost();
		}
		return total;
	}
	
}
	