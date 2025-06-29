public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.025; // 2.5%
    private static final double MINIMUM_BALANCE = 1000.0;

    public SavingsAccount(String id, String name) {
        super(id, name, MINIMUM_BALANCE);
    }

    public SavingsAccount(String id, String name, double balance) {
        super(id, name, Math.max(balance, MINIMUM_BALANCE));
    }

    @Override
    protected void performCredit(double amount) {
        balance += amount;
        applyInterest(amount, INTEREST_RATE);
    }

    @Override
    protected boolean canDebit(double amount) {
        double availableBalance = balance - MINIMUM_BALANCE;
        if (amount > availableBalance) {
            System.out.println("Insufficient balance! Minimum balance of $" + String.format("%.2f", MINIMUM_BALANCE) + 
                             " must be maintained. Available for withdrawal: $" + String.format("%.2f", availableBalance));
            return false;
        }
        return true;
    }


    @Override
    protected boolean canTransfer(double amount) {
        double availableBalance = balance - MINIMUM_BALANCE;
        if (amount > availableBalance) {
            System.out.println("Insufficient balance! Minimum balance of $" + String.format("%.2f", MINIMUM_BALANCE) + 
                             " must be maintained. Available for transfer: $" + String.format("%.2f", availableBalance));
            return false;
        }
        return true;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }

    public double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
