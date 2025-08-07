public class Account {
    private final String id;
    private final String name;
    private double balance = 0;

    public Account(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be null or empty");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    public Account(String id, String name, double balance) {
        this(id, name);
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = balance;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }


    public double credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully credited $" + String.format("%.2f", amount) + " to account " + id);
        } else {
            System.out.println("Credit amount must be positive!");
        }
        return balance;
    }

    public double debit(double amount) {
        if (amount <= 0) {
            System.out.println("Debit amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Available balance: $" + String.format("%.2f", balance));
        } else {
            balance -= amount;
            System.out.println("Successfully debited $" + String.format("%.2f", amount) + " from account " + id);
        }
        return balance;
    }


    public double transferTo(Account another, double amount) {
        if (another == null) {
            System.out.println("Invalid target account!");
            return balance;
        }
        
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Available balance: $" + String.format("%.2f", balance));
        } else {
            this.balance -= amount;
            another.balance += amount;
            System.out.println("Successfully transferred $" + String.format("%.2f", amount) + 
                             " from account " + this.id + " to account " + another.id);
        }
        return balance;
    }


    @Override
    public String toString() {
        return String.format("Account[ID=%s, Name=%s, Balance=$%.2f]", id, name, balance);
    }
}