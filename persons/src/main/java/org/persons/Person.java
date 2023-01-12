package org.persons;

import org.jetbrains.annotations.NotNull;

public abstract class Person implements Payable,Comparable<Person>
{
    private int id;
    private static int idgen = 0;
    protected String name;
    protected String surname;
    Person()
    {
        idgen++;
        id=idgen;
    };
    Person(String Name,String Surname)
    {
        idgen++;
        id=idgen;
        name= Name;
        surname = Surname;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPosition()
    {
      return "Abstract position :) (check this method overriding)";
    }
    @Override
    public String toString() {
        return "THIS IS ABSTRACT CLASS YOU DUMB (check this method overriding)";
    }
    public int compareTo(@NotNull Person other_p)
    {
        return (int)(this.getPaymentAmount()- other_p.getPaymentAmount());
    }
}
