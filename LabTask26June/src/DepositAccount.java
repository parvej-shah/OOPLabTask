public class DepositAccount extends Account {
    private static final double INTEREST_RATE = 0.07; // 7%
    private static final int REQUIRED_INSTALLMENTS = 5;
    private int installments = 0;

    public DepositAccount(String id, String name) {
        super(id, name);
    }

    public DepositAccount(String id, String name, double balance) {
        super(id, name);
        if (balance > 0) {
            credit(balance); // Using credit to properly apply interest and count installment
        }
    }

    @Override
    protected void performCredit(double amount) {
        balance += amount;
        applyInterest(amount, INTEREST_RATE);
        installments++;
        System.out.println("Installment " + installments + " of " + REQUIRED_INSTALLMENTS + " completed.");
        
        if (installments >= REQUIRED_INSTALLMENTS) {
            System.out.println("All installments completed! You can now withdraw from this account.");
        } else {
            System.out.println("You need " + (REQUIRED_INSTALLMENTS - installments) + " more installments before withdrawal is allowed.");
        }
    }

    @Override
    protected boolean canDebit(double amount) {
        if (installments < REQUIRED_INSTALLMENTS) {
            System.out.println("Cannot withdraw! You need to complete " + (REQUIRED_INSTALLMENTS - installments) + 
                             " more installments before withdrawal is allowed.");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Insufficient balance! Available balance: $" + String.format("%.2f", balance));
            return false;
        }
        return true;
    }


    @Override
    protected boolean canTransfer(double amount) {
        System.out.println("Transfer not allowed from Deposit Premium Account!");
        return false;
    }


    @Override
    public String getAccountType() {
        return "Deposit Premium Account";
    }

    public int getInstallments() {
        return installments;
    }

    public int getRemainingInstallments() {
        return Math.max(0, REQUIRED_INSTALLMENTS - installments);
    }

    public boolean canWithdraw() {
        return installments >= REQUIRED_INSTALLMENTS;
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
