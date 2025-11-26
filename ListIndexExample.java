import java.util.Scanner;

public class ListIndexExample {
    public static void main(String[] args) {
        String[] items = {"apple", "banana", "cherry", "dates"};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter index (0–3): ");
            int index = sc.nextInt();

            System.out.println("Item: " + items[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range.");
        }
        catch (Exception e) {
            System.out.println("Error: Invalid input.");
        }
    }
}
