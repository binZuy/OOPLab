package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JTextField;

public class AWTAccumulator extends Frame{
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;


	public AWTAccumulator() {
		setLayout(new GridLayout(2,2));
		add(new Label("Enter an inter: "));
		tfInput =new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		add(new Label("The Accumulated sum: "));
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		setTitle("AWT Accumulator");
		setSize(350,120);
		setVisible(true);
	}
	
	//public static void main(String[] args) {
		//new AWTAccumulator();
	//}
	
	private class TFInputListener implements ActionListener{
		public void  actionPerformed(ActionEvent ext) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfOutput.setText("");
			tfOutput.setText(sum +"");
		}
	}
}
