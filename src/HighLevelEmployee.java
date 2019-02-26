import java.util.*;
import java.util.stream.Stream;

public class HighLevelEmployee extends Employee {
    private double salary;
    private String name; // of position

    private List<Employee> subordinates;

    HighLevelEmployee(String name, double salary) {
        super();
        this.setName(name);
        this.setSalary(salary);
        this.subordinates = new ArrayList<>();
    }


    public double getControlSpanSalary() {
        Stream<Employee> stream1 = this.subordinates.stream();
        Stream<Double> stream2 = stream1.map(a -> a.getControlSpanSalary());
        return stream2.reduce(0.0, (a, b) -> a + b) + this.getSalary();
    };

    public void addSubordinate(Employee e) {
        this.subordinates.add(e);
    };

    public void removeSubordinate(Employee e) {
        // Todo: implement this
    };

    public Employee getSubordinate(int i) {
        return this.subordinates.get(i);
    };

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

    public List<Employee> getSubordinates() {
        return this.subordinates;
    }

}