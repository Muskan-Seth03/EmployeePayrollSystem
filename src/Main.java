import java.util.ArrayList;

abstract class Employee{
    private final String name;
    private final int id;

    public Employee(String name, int id){
        this.name= name;
        this.id= id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name= " + name + ", id= "+ id + ", salary= " + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee{
    private final double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary= monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private final int hoursWorked;

    private final double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked= hoursWorked;
        this.hourlyRate= hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate* hoursWorked;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList= new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove= null;
        for(Employee employee: employeeList){
            if(employee.getId() == id){
                employeeToRemove= employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Muskan", 1, 70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("alice", 2, 6, 1000);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Intial employee detail: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining employee details: ");
        payrollSystem.displayEmployees();
    }
}