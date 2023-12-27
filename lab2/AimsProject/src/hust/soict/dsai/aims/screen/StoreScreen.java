package hust.soict.dsai.aims.screen;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.store.Store;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
	}
	
	
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		JMenuItem addDVDmenu = new JMenuItem("Add DVD");
		addDVDmenu.addActionListener(e->{
			AddDigitalVideoDiscToStore addDVDscreen = new AddDigitalVideoDiscToStore(store);
		});
		smUpdateStore.add(addDVDmenu);
		
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		JMenuItem menuCart = new JMenuItem("View Cart");
		menuCart.addActionListener(e-> {
			CartScreen cartScreen = new CartScreen(this.cart);
		});
		menu.add(menuCart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View Cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		cart.addActionListener(e->{
            CartScreen cartScreen = new CartScreen(this.cart);
        });
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;		
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,3,3));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i =0; i<mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i),this.cart);
			center.add(cell);
		}
			return center;
	}
	
	public static void main(String[] args) {
		Store store= new Store(9);
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
		StoreScreen storeScreen = new StoreScreen(store,cart);
	}
}
