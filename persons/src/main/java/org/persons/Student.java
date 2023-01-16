package org.persons;

public class Student extends Person
{
    private double gpa;
    final double stipend = 36660.00;
    Student(){};
    Student(String Name,String Surname,double Gpa)
    {
        super(Name,Surname);
        gpa=Gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public double getGpa() {
        return gpa;
    }
    @Override
    public String getPosition() {
        return "Student";
    }
    @Override
    public String toString() {
        return "Student: "+super.toString();
    }
    public double getPaymentAmount() {
        if (gpa>2.67)
        {
            return stipend;
        }
        else
        {
            return 0;
        }
    }
}
