package exercise;

import javax.swing.JOptionPane;
public class CalcTwoNumbers{
	public static void main(String[] args){
		String strNum1,strNum2;
		String strNoti = "You've just entered: ";
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNoti += strNum1 + " and ";
		double num1 = Double.parseDouble(strNum1);
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		strNoti += strNum2;
		double num2 = Double.parseDouble(strNum2);
		double sum = num1+num2;
		double difference = (num1 -num2);
		if (difference <0) difference = -difference;
		double product= num1 *num2;
		double quotient = num1 /num2;
	JOptionPane.showMessageDialog(null, strNoti, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
	JOptionPane.showMessageDialog(null, "Sum = "+ sum + "\n"+ "Diffence = "+ difference +"\n" + "Product = " + product + "\n"+ "Quotient = "+ quotient, "Calculate", JOptionPane.INFORMATION_MESSAGE );
	System.exit(0);
	}
}