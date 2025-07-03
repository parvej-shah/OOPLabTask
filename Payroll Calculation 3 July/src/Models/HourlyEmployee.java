package Models;

public class HourlyEmployee extends Employee {
    private double hourlySalary;
    private double hoursWorked;
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,double hourlySalary, double hoursWorked,double salary) {
        super(firstName, lastName, socialSecurityNumber);
        if (hourlySalary < 0 || hoursWorked < 0 || hoursWorked > 168)
            throw new IllegalArgumentException("Hours Worked must be between 0 and 168 and hourly salary must be greater than 0");
        this.hourlySalary = hourlySalary;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        if(!numericInputValidation(hourlySalary, "Hourly salary"))
            this.hourlySalary = hourlySalary;
    }

    public double getHoursWorked() {
        return hoursWorked;
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
