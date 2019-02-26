interface Employee{
    public String getName();
    public float getSalary();
    public double getControlSpanSalary();
    public void addSubordinate(Employee e);
    public void removeSubordinate(Employee e);
    public Employee getSubordinate(int i);
    public void print();
    // could also go and create getAllSubordinates Etc..
}

