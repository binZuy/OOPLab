package exercise;
import java.util.Scanner;
public class DisplayStars {
	public static void main(String[] args) {
		Scanner nhapdulieu = new Scanner(System.in);
		System.out.println("n = ");
		int iInt = nhapdulieu.nextInt();
		int i,j,k;
		for (i = 1; i <= iInt; i++) {
			for (k = iInt-i; k>=1; k--){
				System.out.print(" ");
				}
			for (j = 1; j < 2*i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.exit(0);
	}
}