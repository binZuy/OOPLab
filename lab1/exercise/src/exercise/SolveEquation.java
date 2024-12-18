package exercise;
import java.util.Scanner;

public class SolveEquation {
    public static void main(String[] args) {
        System.out.println("Equation as 'a * x + b = 0', please enter constants:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("a = ");
        double a = scanner.nextDouble();

        System.out.print("b = ");
        double b = scanner.nextDouble();
        scanner.close();
        if (a != 0) {
            double solution = -b / a;
            System.out.println("The solution is: " + solution);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
        System.exit(0);
    }
}
