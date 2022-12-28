package org.example;

public class AssignmentOne
{
    public static void main(String[] args)
    {
        Shape firstshape = new Shape();
        Shape secondshape = new Shape();
        firstshape.cookShapeFrom("file1.txt");
        System.out.println("[1] " + firstshape.toString());
        secondshape.cookShapeFrom("file2.txt");
        System.out.println("[2] " + secondshape.toString());
    }
}