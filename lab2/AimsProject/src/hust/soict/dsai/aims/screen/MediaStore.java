package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.naming.LimitExceededException;
import javax.swing.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.cart.Cart;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	public MediaStore(Media media,Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN , 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btAddToCart = new JButton("Add to cart");
		btAddToCart.addActionListener(e->{
			try {
				cart.addMedia(this.media);
			} catch (LimitExceededException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        });
		container.add(btAddToCart);
		if(media instanceof Playable) {
			container.add(new JButton("Play"));
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
