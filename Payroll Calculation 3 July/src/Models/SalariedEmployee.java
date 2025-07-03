package Models;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        if (weeklySalary < 0)
            throw new IllegalArgumentException("Weekly salary cannot be negative");
        this.weeklySalary = weeklySalary;
    }
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber) {
        this(firstName, lastName, socialSecurityNumber, 0.0);
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void updateWeeklySalary(double weeklySalary) {
        if (numericInputValidation(weeklySalary, "Weekly salary"))
            this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWeekly salary: " + weeklySalary;
    }
}
