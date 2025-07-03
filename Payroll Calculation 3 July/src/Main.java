import Models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {
        employees.add(new SalariedEmployee("Parvej","Shah","SSNII",2000 ));
        employees.add(new HourlyEmployee("Parvej","Shah Hourly","SSNIIHOurly",30));
        employees.add(new HourlyEmployee("Parvej","Shah Hourly 40+ hour","SSNIIHOurly",50));
        employees.add(new CommissionEmployee("Parvej","Shah Commission","SSNIIHOurly",300));
        employees.add(new BasePlusCommissionEmployee("Parvej","Shah Hourly Commission + Base","SSNIIHOurly",350,10000));
        employees.add(new BasePlusCommissionEmployee("Parvej","Shah Hourly Commission + Base2","SSNIIHOurly",400,1000));
        for (Employee employee : employees) {
            if (employee instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) employee).setBaseSalary(((BasePlusCommissionEmployee) employee).getBaseSalary()*1.10);
            }
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        for (Employee employee : employees) {
            System.out.println("Earnings: "+employee.earnings());
        }
    }
}