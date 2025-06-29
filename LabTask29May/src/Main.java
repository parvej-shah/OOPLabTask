import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();
    
    static {accounts.add(new Account("1", "Parvej Shah", 1000.0));}

    public static void main(String[] args) {
        boolean isRunning = true;
        
        System.out.println("=== Welcome to IIT Bank Management System ===");
        
        while (isRunning) {
            displayMainMenu();
            int choice = getIntegerInput();
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    creditAmount();
                    break;
                case 3:
                    debitAmount();
                    break;
                case 4:
                    transferAmount();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    viewAllAccounts();
                    break;
                case 7:
                    isRunning = false;
                    System.out.println("Thank you for using IIT Bank Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option (1-7).");
            }
            
            if (isRunning) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine();
            }
        }
        
        sc.close();
    }


    static void displayMainMenu() {
        System.out.println("\n=============== IIT Bank Main Menu ===============");
        System.out.println("1. Create New Account");
        System.out.println("2. Credit Amount");
        System.out.println("3. Debit Amount");
        System.out.println("4. Transfer Amount");
        System.out.println("5. View Account Details");
        System.out.println("6. View All Accounts");
        System.out.println("7. Exit");
        System.out.println("=================================================");
        System.out.print("Enter your choice (1-7): ");
    }
    
    static int getIntegerInput() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (Exception e) {
                System.out.print("Invalid input! Please enter a number: ");
                sc.nextLine();
            }
        }
    }
    
    static double getDoubleInput() {
        while (true) {
            try {
                double input = sc.nextDouble();
                sc.nextLine();
                return input;
            } catch (Exception e) {
                System.out.print("Invalid input! Please enter a valid amount: ");
                sc.nextLine();
            }
        }
    }
    
    static Account findAccountById(String id) {
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }
    
    static boolean isAccountIdExists(String id) {
        return findAccountById(id) != null;
    }
    
    
    static void createAccount() {
        System.out.println("\n--- Create New Account ---");
        
        String id;
        do {
            System.out.print("Enter Account ID: ");
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Account ID cannot be empty!");
                continue;
            }
            if (isAccountIdExists(id)) {
                System.out.println("Account ID already exists! Please choose a different ID.");
            }
        } while (isAccountIdExists(id) || id.isEmpty());
        
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty! Enter Account Holder Name: ");
            name = sc.nextLine().trim();
        }
        
        System.out.print("Enter Initial Balance: ");
        double balance = getDoubleInput();
        while (balance < 0) {
            System.out.print("Initial balance cannot be negative! Enter Initial Balance: ");
            balance = getDoubleInput();
        }
        
        Account newAccount = new Account(id, name, balance);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
        System.out.println(newAccount);
    }
    
    static void creditAmount() {
        System.out.println("\n--- Credit Amount ---");
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine().trim();
        
        Account account = findAccountById(id);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter Amount to Credit: ");
        double amount = getDoubleInput();
        
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        
        double newBalance = account.credit(amount);
        System.out.println("Amount credited successfully!");
        System.out.println("New Balance: $" + String.format("%.2f", newBalance));
    }
    
    static void debitAmount() {
        System.out.println("\n--- Debit Amount ---");
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine().trim();
        
        Account account = findAccountById(id);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter Amount to Debit: ");
        double amount = getDoubleInput();
        
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        
        double oldBalance = account.getBalance();
        double newBalance = account.debit(amount);
        
        if (newBalance < oldBalance) {
            System.out.println("Amount debited successfully!");
            System.out.println("New Balance: $" + String.format("%.2f", newBalance));
        }
    }
    
    static void transferAmount() {
        System.out.println("\n--- Transfer Amount ---");
        System.out.print("Enter Sender Account ID: ");
        String senderId = sc.nextLine().trim();
        
        Account senderAccount = findAccountById(senderId);
        if (senderAccount == null) {
            System.out.println("Sender account not found!");
            return;
        }
        
        System.out.print("Enter Receiver Account ID: ");
        String receiverId = sc.nextLine().trim();
        
        Account receiverAccount = findAccountById(receiverId);
        if (receiverAccount == null) {
            System.out.println("Receiver account not found!");
            return;
        }
        
        if (senderId.equals(receiverId)) {
            System.out.println("Cannot transfer to the same account!");
            return;
        }
        
        System.out.print("Enter Amount to Transfer: ");
        double amount = getDoubleInput();
        
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        
        double oldSenderBalance = senderAccount.getBalance();
        double newSenderBalance = senderAccount.transferTo(receiverAccount, amount);
        
        if (newSenderBalance < oldSenderBalance) {
            System.out.println("Transfer completed successfully!");
            System.out.println("Sender Balance: $" + String.format("%.2f", newSenderBalance));
            System.out.println("Receiver Balance: $" + String.format("%.2f", receiverAccount.getBalance()));
        }
    }
    
    static void viewAccountDetails() {
        System.out.println("\n--- View Account Details ---");
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine().trim();
        
        Account account = findAccountById(id);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("\n--- Account Details ---");
        System.out.println(account);
    }
    
    static void viewAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        
        System.out.println("Total Accounts: " + accounts.size());
        System.out.println("-----------------------------------");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}