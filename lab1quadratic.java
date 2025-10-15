import java.util.Scanner;

public class lab1quadratic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficient a:");
        double a = scanner.nextDouble();

        System.out.println("Enter coefficient b:");
        double b = scanner.nextDouble();

        System.out.println("Enter coefficient c:");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Coefficient 'a' cannot be zero for a quadratic equation.");
        } else {
            if (discriminant > 0) {
                // Two distinct real roots
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Roots are real and distinct:");
                System.out.println("Root 1 = " + root1);
                System.out.println("Root 2 = " + root2);
            } else if (discriminant == 0) {
                // One real root (roots are equal)
                double root = -b / (2 * a);
                System.out.println("Roots are real and equal:");
                System.out.println("Root = " + root);
            } else {
                // Complex roots
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                System.out.println("Roots are complex and imaginary:");
                System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
                System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
            }
        }

        scanner.close();
    }
}
