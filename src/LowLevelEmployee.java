import java.util.*;

public class LowLevelEmployee implements IEmployee{
    
    private double salary;
    private String name; // of position

    LowLevelEmployee(String name, double salary) {
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

    
}