package Models;

abstract public class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        if (firstName == null || lastName == null || socialSecurityNumber == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    abstract public double earnings();

    // I was repeating this logic everywhere so I make it a reusable method
    protected boolean numericInputValidation(double input, String inputName) {
        if (input >= 0) {
            return true;
        }
        System.out.println(inputName+" cannot be negative");
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s (SSN: %s)", firstName, lastName, socialSecurityNumber);
    }
}
