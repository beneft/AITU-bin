package org.persons;

import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Employee("Hamster","Hamsterson","Pet",1000000));
        list.add(new Student("Gordon","Freeman",2));
        list.add(new Employee("Marty","McFly","Time Traveler",40000));
        list.add(new Student("Porter","Robinson",4));
        Collections.sort(list);
        printData(list);
    }
    public static void printData(Iterable<Person> List)
    {
        for (Person value : List)
        {
            System.out.println(value.toString() +" earns "+ Double.toString(value.getPaymentAmount())+" tenge");
        }
    }
}
