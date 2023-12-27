package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.cart.Cart;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart();
		CartScreenController cartScreenController = new CartScreenController(cart);
		cart.setCartScreenController(cartScreenController);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
        		"Animation", "Roger Allers", 87, 19.95f);
		Book book1 = new Book(7, "Test Java", "Research", 20.5f);
		CompactDisc cd1 = new CompactDisc(9, "Learning English", "Studying", 19.54f, 50, "Binzuy", "Minh Duy");
		cart.addMedia(dvd1);
		cart.addMedia(cd1);
		cart.addMedia(book1);
		cart.printCart();
		CartScreen cs = new CartScreen(cart);
		cs.setVisible(true);
	
	}
}
