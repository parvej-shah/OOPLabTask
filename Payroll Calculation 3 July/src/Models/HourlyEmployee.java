package Models;

public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;
    
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hourlyWage, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        if (!numericInputValidation(hourlyWage, "Hourly wage"))
            throw new IllegalArgumentException("Hourly wage cannot be negative");
        if (hoursWorked < 0 || hoursWorked > 168)
            throw new IllegalArgumentException("Hours Worked must be between 0 and 168");
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber) {
        this(firstName, lastName, socialSecurityNumber, 10.0, 0);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

   public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHoursWorked(double hoursWorked) {
        if(numericInputValidation(hoursWorked, "Hours worked") && hoursWorked <=168)
            this.hoursWorked = hoursWorked;
    }
    public void setHourlyWage(double hourlyWage) {
        if(numericInputValidation(hourlyWage, "Hourly wage"))
            this.hourlyWage = hourlyWage;
    }

    @Override
    public double earnings() {
        if(hoursWorked <= 40)
            return hoursWorked * hourlyWage;
        return hourlyWage * 40 + (hoursWorked - 40) * hourlyWage * 1.5;
    }

    @Override
    public String toString() {
        return String.format("Hourly Employee: %s%nHourly Wage: $%.2f%nHours Worked: %.1f%nOvertime Hours: %.1f", 
                           super.toString(), hourlyWage, hoursWorked, 
                           hoursWorked > 40 ? hoursWorked - 40 : 0);
    }
    
}
