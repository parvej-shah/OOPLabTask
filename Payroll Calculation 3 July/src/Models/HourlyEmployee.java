package Models;

public class HourlyEmployee extends Employee {
    private final double hourlySalary = 10;
    private double hoursWorked;
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        if ( hoursWorked < 0 || hoursWorked > 168)
            throw new IllegalArgumentException("Hours Worked must be between 0 and 168");
        this.hoursWorked = hoursWorked;
    }

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber) {
        this(firstName, lastName, socialSecurityNumber, 0);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHoursWorked(double hoursWorked) {
        if(!numericInputValidation(hoursWorked, "Hours worked") && hoursWorked <=168)
            this.hoursWorked = hoursWorked;
    }

    @Override
    double earnings() {
        if(hoursWorked <= 40)
            return hoursWorked*hourlySalary;
        return hourlySalary*(hoursWorked - 40)*1.5 + hourlySalary*40;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWeekly Salary: " + hourlySalary + "\nHours Worked: " + hoursWorked + "\nTotal Earning: " + earnings();
    }
}
