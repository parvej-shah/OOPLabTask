public class CurrentAccount extends Account {
    
    public CurrentAccount(String id, String name) {
        super(id, name);
    }

    public CurrentAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    protected void performCredit(double amount) {
        balance += amount;
    }

    @Override
    protected boolean canDebit(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Available balance: $" + String.format("%.2f", balance));
            return false;
        }
        return true;
    }


    @Override
    protected boolean canTransfer(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance! Available balance: $" + String.format("%.2f", balance));
            return false;
        }
        return true;
    }


    @Override
    public String getAccountType() {
        return "Current Account";
    }
}
