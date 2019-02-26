public class LowLevelEmployee implements IEmployee{
    
    private double salary;
    private String name; // of position

    LowLevelEmployee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
    }

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