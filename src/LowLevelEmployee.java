import java.util.*;

public class LowLevelEmployee extends Employee {
    
    private double salary;
    private String name; // of position

    public LowLevelEmployee(String name, double salary) {
        super();
        this.setName(name);
        this.setSalary(salary);
    }

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

    public double getControlSpanSalary() {
        return this.getSalary();
    }

    public String toString() {
        return this.getName();
    }
    
}