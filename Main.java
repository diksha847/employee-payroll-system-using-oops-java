import java.util.ArrayList;
import java.util.List;
abstract class Employee
{
    private String name;
    private int id;

    public Employee(String name,int id)
    {
        this.name=name;
        this.id=id;
}

public String getName()
{
    return name;
}
public int getid()
{
    return id;
}

public abstract double CalculateSalary();

@Override
public String toString()
{
    return "Employee [name=" +name + " , id=" + id + " , salary=" + CalculateSalary() +" ]";
}

}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary)
    {
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public  double CalculateSalary()
    {
        return monthlySalary;
    }


}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate)
    {
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    @Override
    public  double CalculateSalary()
    {
        return hourlyRate*hoursWorked;
    }
}
    class PayrollSystem {
        private List<Employee> employeeList;

        public PayrollSystem()
        {
            employeeList = new ArrayList<>();
        }
    
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
      Employee employeeToRemove = null;
      for(Employee employee : employeeList)
      {
        if(employee.getid()==id)
        {
            employeeToRemove=employee;
            break;
        }
      }
      if(employeeToRemove !=null)
      {
        employeeList.remove(employeeToRemove);
      }

    }
    public void displayEmployees()
    {
        for(Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }
}
public class Main{
    public static void main(String[] args) {
        PayrollSystem payrollSystem =new PayrollSystem();

        FullTimeEmployee emp1= new FullTimeEmployee("ramesh", 101, 34000);
        PartTimeEmployee emp2= new PartTimeEmployee("reena", 202, 20, 400);
        
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("initial employees");
                System.out.println(emp1);
                                System.out.println(emp2);


        System.out.println(emp2);
        payrollSystem.removeEmployee(202);
        System.out.println("final employees");
                System.out.println(emp1);

      }
}



