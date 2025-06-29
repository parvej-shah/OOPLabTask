import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    static {
        accounts.add(new CurrentAccount("C001", "Sajib", 1000.0));
    }

    public static void main(String[] args) {
        System.out.println("IIT Bank Management System");
        
        while (true) {
            System.out.println("\n1. Create Account  2. Credit  3. Debit  4. Transfer  5. View Account  6. View All  7. Exit");
            System.out.print("Choice: ");
            int choice = getIntegerInput();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: creditAmount(); break;
                case 3: debitAmount(); break;
                case 4: transferAmount(); break;
                case 5: viewAccountDetails(); break;
                case 6: viewAllAccounts(); break;
                case 7: System.out.println("Thank you!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static int getIntegerInput() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid input: ");
                sc.nextLine();
            }
        }
    }

    static double getDoubleInput() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.print("Invalid amount: ");
                sc.nextLine();
            }
        }
    }

    static Account findAccount(String id) {
        for (Account account : accounts) {
            if (account.getId().equals(id)) return account;
        }
        return null;
    }

    static void createAccount() {
        System.out.print("Account ID: ");
        String id = sc.next();
        if (findAccount(id) != null) {
            System.out.println("ID already exists!");
            return;
        }
        
        System.out.print("Name: ");
        String name = sc.next();
        
        System.out.println("1. Current  2. Savings  3. Deposit");
        System.out.print("Type: ");
        int type = getIntegerInput();
        
        System.out.print("Initial amount: $");
        double amount = getDoubleInput();
        
        Account account = null;
        switch (type) {
            case 1: account = new CurrentAccount(id, name, amount); break;
            case 2: account = amount >= 1000 ? new SavingsAccount(id, name, amount) : null; break;
            case 3: account = amount > 0 ? new DepositAccount(id, name, amount) : null; break;
        }
        
        if (account != null) {
            accounts.add(account);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Invalid amount for account type!");
        }
    }

    static void creditAmount() {
        System.out.print("Account ID: ");
        Account account = findAccount(sc.next());
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Amount: $");
        double amount = getDoubleInput();
        if (amount > 0) {
            account.credit(amount);
            System.out.println("Credited successfully! New balance: $" + account.getBalance());
        }
    }

    static void debitAmount() {
        System.out.print("Account ID: ");
        Account account = findAccount(sc.next());
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Amount: $");
        double amount = getDoubleInput();
        double oldBalance = account.getBalance();
        account.debit(amount);
        
        if (account.getBalance() < oldBalance) {
            System.out.println("Debited successfully! New balance: $" + account.getBalance());
        } else {
            System.out.println("Transaction failed!");
        }
    }

    static void transferAmount() {
        System.out.print("From Account ID: ");
        Account from = findAccount(sc.next());
        System.out.print("To Account ID: ");
        Account to = findAccount(sc.next());
        
        if (from == null || to == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Amount: $");
        double amount = getDoubleInput();
        double oldBalance = from.getBalance();
        from.transferTo(to, amount);
        
        if (from.getBalance() < oldBalance) {
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed!");
        }
    }

    static void viewAccountDetails() {
        System.out.print("Account ID: ");
        Account account = findAccount(sc.next());
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Type: " + account.getAccountType());
        System.out.println("ID: " + account.getId());
        System.out.println("Name: " + account.getName());
        System.out.println("Balance: $" + account.getBalance());
    }

    static void viewAllAccounts() {
        System.out.println("\nAll Accounts:");
        for (Account account : accounts) {
            System.out.println(account.getId() + " - " + account.getName() + 
                             " (" + account.getAccountType() + ") - $" + account.getBalance());
        }
    }
}