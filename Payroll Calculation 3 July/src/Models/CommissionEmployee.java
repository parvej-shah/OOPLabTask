package Models;

public class CommissionEmployee extends Employee {
    private final double commissionRate = 0.10; //10%
    private double grossSales;
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        if (!numericInputValidation(grossSales,"Gross sales"))
            throw new IllegalArgumentException("Gross Sales must be greater than 0");
        this.grossSales = grossSales;
    }

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber) {
        this(firstName, lastName, socialSecurityNumber, 0);
    }


    @Override
    double earnings() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCommission Rate: " + commissionRate + "\nGross Sales: "+grossSales +"\nEarnings: " + earnings();
    }
}
