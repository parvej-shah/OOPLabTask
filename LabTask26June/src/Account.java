public abstract class Account {
    private final String id;
    private final String name;
    protected double balance = 0;

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


    public final double credit(double amount) {
        if (!validateAmount(amount, "Credit")) {
            return balance;
        }
        
        performCredit(amount);
        logTransaction("Credit", amount, balance);
        return balance;
    }

    public final double debit(double amount) {
        if (!validateAmount(amount, "Debit")) {
            return balance;
        }
        
        if (!canDebit(amount)) {
            return balance;
        }
        
        performDebit(amount);
        logTransaction("Debit", amount, balance);
        return balance;
    }

    public final double transferTo(Account another, double amount) {
        if (another == null) {
            System.out.println("Invalid target account!");
            return balance;
        }
        
        if (!validateAmount(amount, "Transfer")) {
            return balance;
        }
        
        if (!canTransfer(amount)) {
            return balance;
        }
        
        performTransfer(another, amount);
        System.out.println("Successfully transferred $" + String.format("%.2f", amount) +
                " from " + getAccountType() + " " + id + " to " + another.getAccountType() + " " + another.id);
        return balance;
    }

    protected void performDebit(double amount){
        balance -= amount;
    };

    protected void performTransfer(Account another, double amount) {
        performDebit(amount);
        another.credit(amount);
    }

    // Abstract methods that subclasses must implement
    protected abstract void performCredit(double amount);
    protected abstract boolean canDebit(double amount);
    protected abstract boolean canTransfer(double amount);
    public abstract String getAccountType();

    // Common utility methods
    protected boolean validateAmount(double amount, String operation) {
        if (amount <= 0) {
            System.out.println(operation + " amount must be positive!");
            return false;
        }
        return true;
    }

    protected void logTransaction(String type, double amount, double newBalance) {
    System.out.println("Successfully " + type.toLowerCase() + "ed $" + String.format("%.2f", amount) +
        " " + (type.equals("Credit") ? "to" : "from") + " " + getAccountType().toLowerCase() + " " + id +
        " | Balance: $" + String.format("%.2f", newBalance));
}



    // Helper method for subclasses to apply interest
    protected void applyInterest(double amount, double interestRate) {
        double interest = amount * interestRate;
        balance += interest;
        System.out.println("Interest applied: $" + String.format("%.2f", interest) + " (" + String.format("%.1f", interestRate * 100) + "%)");
    }

    @Override
    public String toString() {
        return String.format("%s[ID=%s, Name=%s, Balance=$%.2f]", getAccountType(), id, name, balance);
    }
}