import java.utils.*;

public class HighLevelEmployee implements IEmployee, IEmployeeBoss{
    private double salary;
    private String name; // of position

    private List<Employee> subordinates;

    HighLevelEmployee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
        this.subordinates = new ArrayList<>();
    }


    public double getControlSpanSalary() {
        return null;
    };

    public void addSubordinate(Employee e) {
        return null;
    };

    public void removeSubordinate(Employee e) {
        return null;
    };

    public Employee getSubordinate(int i) {
        return null;
    };

    private void setName(String name) {
        return null;
    }; // not the person's name rather the position
  
    private void setSalary(double salary) {
        return null;
    };

    public String getName() {
        return null;
    };

    public double getSalary() {
        return null;
    };

}