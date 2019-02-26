import java.util.*;
import java.util.stream.Stream;

public abstract class Employee implements IEmployee, IEmployeeBoss {
    private double salary;
    private String name; // of position

    public void setName(String name) {
        this.name = name;
    }; // not the person's name rather the position
  
    public void setSalary(double salary) {
        this.salary = salary;
    };

    public String getName() {
        return this.name;
    };

    public double getSalary() {
        return this.salary;
    };

    public String toString() {
        return this.getName();
    }

    private List<Employee> subordinates;

    public double getControlSpanSalary() {
        return 0.0;
    };

    public void addSubordinate(Employee e) {
    };

    public void removeSubordinate(Employee e) {
        // Todo: implement this
    };

    public Employee getSubordinate(int i) {
        return this.subordinates.get(i);
    };

    public List<Employee> getSubordinates() {
        return new ArrayList<Employee>();
    }

}