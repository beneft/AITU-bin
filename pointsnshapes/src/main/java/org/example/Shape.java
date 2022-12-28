package org.example;

import java.io.FileNotFoundException;
import java.util.*;

public class Shape
{
    private boolean hasChanges = false; //flagging if recalculation needed when extra points were added
    private List<Point> points;
    private List<Double> sides;
    private double perimeter = 0;
    private double longestSide = 0;
    private double averageOfSides = 0;
    Shape()
    {
        points= new LinkedList<Point>();
        sides= new LinkedList<Double>();
    }
    private Double[] makeLine(Point pt1, Point pt2) //forms coefficients of a straight line equation
    {
        Double[] koefs = new Double[3];
        koefs[0]=pt2.getX()-pt1.getX();
        koefs[1]=pt2.getY()-pt1.getY();
        koefs[2]=pt1.getY()*(pt2.getX()-pt1.getX())-pt1.getX()*(pt2.getY()-pt1.getY());
        return koefs;
    }
    private void calculateSides () //this method also checks if points line up
    {                              //it is assumed that all points listed in sequential order
        sides.clear();             //all line intersections and cases when a point is positioned on the previously drawn line are omitted
        Double[] line = makeLine(points.get(0),points.get(1));
        double distance = points.get(0).distance(points.get(1));
        ListIterator<Point> it = points.listIterator();
        it.next();
        Point previous = it.next();
        Point current = null;
        while (it.hasNext())
        {
        current = it.next();
        if (current.getY()*line[0]==current.getX()*line[1]+line[2]) //line equation
        {
            distance += previous.distance(current);
            previous = current;
        } else
        {
            sides.add(distance);
            distance = previous.distance(current);
            line = makeLine(previous,current);
            previous = current;
        }
        }
        current=points.get(0);
        if (current.getY()*line[0]==current.getX()*line[1]+line[2])
        {
            distance+=previous.distance(current);
            sides.add(distance);
        }
        else {
            sides.add(distance);
            sides.add(previous.distance(current));
        }
        hasChanges=false;
    }
    public void addPoint (Point pt)
    {
        points.add(pt);
        hasChanges = true;
    }
    public List<Point> getPoints ()
    {
        return this.points;
    }
    private double calculatePerimeter ()
    {
        if (hasChanges) calculateSides();
        double permetr =0;
        for (double value:
             sides) {
            permetr+=value;
        }
        return permetr;
    }
    private double getLongestSide()
    {
        if (hasChanges) calculateSides();
        double max = 0;
        for (double value:
                sides) {
            if (value>max)
            {
                max = value;
            }
        }
        return max;
    }
    private double getAverageSide()
    {
        if (hasChanges) calculateSides();
        double count =0;
        double sum = 0;
        for (double value:
                sides) {
            sum+=value;
            count++;
        }
        return sum/count;
    }
    public void cookShapeFrom(String path)  //make a shape and gather all data
    {
        Parser parser = new Parser();
        try {
            parser.readPointsFrom(path);
        } catch (FileNotFoundException e){e.printStackTrace();}
        while (parser.hasNextPoint())
        {
            this.addPoint(parser.parsePoint());
        }
        perimeter = calculatePerimeter();
        longestSide = getLongestSide();
        averageOfSides = getAverageSide();
    }

    @Override
    public String toString() {
        return "Shape:" +
                "\nperimeter= " + perimeter +
                "\nlongestSide= " + longestSide +
                "\naverageOfSides= " + averageOfSides +
                '\n'
                ;
    }
}
