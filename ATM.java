import java.util.Scanner;

// Class 1: Represents the User's Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("✨ Successfully deposited: ₹%.2f\n", amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
            return false;
        } else if (amount > balance) {
            System.out.println("❌ Transaction Failed: Insufficient balance.");
            return false;
        } else {
            balance -= amount;
            System.out.printf("💸 Successfully withdrew: ₹%.2f\n", amount);
            return true;
        }
    }
}

// Class 2: Represents the ATM Machine User Interface
public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void startInterface() {
        int choice = 0;
        System.out.println("🏦 Welcome to the ATM System 🏦");

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit Terminal");
            System.out.print("Select an option (1-4): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                handleChoice(choice);
            } else {
                System.out.println("❌ Invalid option. Please enter a number between 1 and 4.");
                scanner.next(); // Clear invalid token
            }
        } while (choice != 4);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                performDeposit();
                break;
            case 3:
                performWithdrawal();
                break;
            case 4:
                System.out.println("👋 Thank you for using our ATM. Have a great day!");
                break;
            default:
                System.out.println("❌ Out of range. Please choose a valid menu item.");
        }
    }

    private void checkBalance() {
        System.out.printf("📊 Your Current Balance: ₹%.2f\n", userAccount.getBalance());
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            userAccount.deposit(amount);
        } else {
            System.out.println("❌ Invalid entry. Please enter a numerical money value.");
            scanner.next();
        }
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ₹");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            userAccount.withdraw(amount);
        } else {
            System.out.println("❌ Invalid entry. Please enter a numerical money value.");
            scanner.next();
        }
    }

    // Main method to bootstrap the application
    public static void main(String[] args) {
        // Initializing user account with a starting balance of ₹5000.00
        BankAccount account = new BankAccount(5000.00);
        ATM atmMachine = new ATM(account);
        atmMachine.startInterface();
    }
}
