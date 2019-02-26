public interface IEmployeeBoss{
    public double getControlSpanSalary();
    public void addSubordinate(IEmployee e);
    public void removeSubordinate(IEmployee e);
    public IEmployee getSubordinate(int i);
    // could also go and create getAllSubordinates Etc..
}