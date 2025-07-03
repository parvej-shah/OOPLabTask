package Models;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        if (weeklySalary < 0)
            throw new IllegalArgumentException("Weekly salary cannot be negative");
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void updateWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0){
            System.out.println("Weekly salary cannot be negative");
            return;
        }
        this.weeklySalary = weeklySalary;
    }

    @Override
    double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWeekly salary: " + weeklySalary;
    }
}
