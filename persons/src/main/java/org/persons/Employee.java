package org.persons;

public class Employee extends Person
{
    private String position;
    private double salary;
    Employee(){};
    Employee(String Name,String Surname,String Position,double Salary)
    {
        super(Name,Surname);
        position=Position;
        salary=Salary;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String getPosition() {
        return position;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee("+position+"): "+Integer.toString(getId())+". "+name+" "+surname;
    }
    public double getPaymentAmount() {
        return salary;
    }
}
