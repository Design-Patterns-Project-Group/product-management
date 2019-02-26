import java.util.*;
import java.util.stream.Stream;

public class HighLevelEmployee implements IEmployee, IEmployeeBoss{
    private double salary;
    private String name; // of position

    private List<IEmployee> subordinates;

    HighLevelEmployee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
        this.subordinates = new ArrayList<>();
    }


    public double getControlSpanSalary() {
        Stream<IEmployee> stream1 = this.subordinates.stream();
        Stream<Double> stream2 = stream1.map(a -> a.getControlSpanSalary());
        return stream2.reduce(0.0, (a, b) -> a + b) + this.getSalary();
    };

    public void addSubordinate(IEmployee e) {
        this.subordinates.add(e);
    };

    public void removeSubordinate(IEmployee e) {
        // Todo: implement this
    };

    public IEmployee getSubordinate(int i) {
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

}