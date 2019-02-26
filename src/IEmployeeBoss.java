import java.util.List;

public interface IEmployeeBoss{
    public double getControlSpanSalary();
    public void addSubordinate(Employee e);
    public void removeSubordinate(Employee e);
    public Employee getSubordinate(int i);
    public List<Employee> getSubordinates();
}