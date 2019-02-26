public interface IEmployeeBoss{
    public double getControlSpanSalary();
    public void addSubordinate(Employee e);
    public void removeSubordinate(Employee e);
    public Employee getSubordinate(int i);
    // could also go and create getAllSubordinates Etc..
}