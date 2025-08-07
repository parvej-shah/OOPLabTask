package Models;

public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber) {
        this(firstName, lastName, socialSecurityNumber,0,0);
    }

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales);
        if (!numericInputValidation(baseSalary, "Base Salary"))
            throw new IllegalArgumentException("Base Salary should be greater than 0.");
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (numericInputValidation(baseSalary, "Base Salary"))
            this.baseSalary = baseSalary;
    }

    public void increaseBaseSalary() {
        this.baseSalary =  this.baseSalary*1.10;
    }

    @Override
    public double earnings() {
        return super.earnings() + baseSalary;
    }

    @Override
    public String toString() {
        return String.format("Base Plus %s%nBase Salary: $%.2f%n", 
                           super.toString(), baseSalary);
    }
}
