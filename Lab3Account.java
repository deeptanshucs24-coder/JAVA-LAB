import java.util.Scanner;

public class Lab3Account {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input initial account details
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        double balance = 0;
        while (true) {
            System.out.print("Enter initial balance: ");
            if(scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                if(balance < 0) {
                    System.out.println("Balance cannot be negative. Try again.");
                    scanner.nextLine(); // consume newline
                } else {
                    scanner.nextLine(); // consume newline
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard invalid input
            }
        }

        Account acc = new Account(accountNumber, balance);

        System.out.println("\nAccount created successfully!");
        System.out.println(acc);

        // Interactive menu for deposit and withdrawal
        while(true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Account Details");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = 0;

            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // discard invalid input
                continue;
            }

            switch(choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    if(scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        acc.deposit(amount);
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    if(scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        acc.withdraw(amount);
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.println(acc);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1 to 4.");
            }
        }
    }
}

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if(accountNumber != null && !accountNumber.trim().isEmpty()) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Invalid account number.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nBalance: $" + balance;
    }
}
