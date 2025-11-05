import java.util.Scanner;

// Base class Account
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String type, double bal) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = bal;
    }

    // a) Accept deposit and update balance
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // b) Display balance
    void displayBalance() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }
}

// Savings Account Class
class Sav_acct extends Account {
    final double interestRate = 0.05; // 5% interest rate

    Sav_acct(String name, int accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    // c) Compute and deposit compound interest
    void computeAndDepositInterest() {
        double interest = balance * Math.pow((1 + interestRate / 4), 4) - balance; // quarterly compound interest
        balance += interest;
        System.out.println("Interest Added: " + interest);
    }

    // d) Withdraw and update balance
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
}

// Current Account Class
class Cur_acct extends Account {
    final double minBalance = 1000.0;
    final double serviceCharge = 100.0;

    Cur_acct(String name, int accNo, double bal) {
        super(name, accNo, "Current", bal);
    }

    // d) Withdraw and update balance, check minimum balance
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        }
    }

    void checkMinimumBalance() {
        if (balance < minBalance) {
            System.out.println("⚠️ Balance below minimum! Service charge imposed: " + serviceCharge);
            balance -= serviceCharge;
        }
    }
}

// Main class (not public — so file name can be lab5account.java)
class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Savings Account object
        Sav_acct s1 = new Sav_acct("Amit", 101, 5000);
        System.out.println("=== SAVINGS ACCOUNT OPERATIONS ===");
        s1.displayBalance();
        s1.computeAndDepositInterest();
        s1.deposit(2000);
        s1.withdraw(1500);
        s1.displayBalance();

        System.out.println("\n-------------------------------\n");

        // Create Current Account object
        Cur_acct c1 = new Cur_acct("Ravi", 202, 2000);
        System.out.println("=== CURRENT ACCOUNT OPERATIONS ===");
        c1.displayBalance();
        c1.withdraw(1200);
        c1.withdraw(500);
        c1.deposit(1000);
        c1.displayBalance();

        sc.close();
    }
}
