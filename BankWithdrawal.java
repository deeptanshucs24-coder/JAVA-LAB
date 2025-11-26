import java.util.Scanner;

public class BankWithdrawal {
    public static void main(String[] args) {
        double balance = 5000;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            if (amount > balance) {
                System.out.println("Error: Insufficient balance.");
            }
            else if (amount <= 0) {
                System.out.println("Error: Enter a positive amount.");
            }
            else {
                balance -= amount;
                System.out.println("Withdrawal successful!");
                System.out.println("Remaining Balance: " + balance);
            }
        }
        catch (Exception e) {
            System.out.println("Error: Enter numbers only.");
        }
    }
}
