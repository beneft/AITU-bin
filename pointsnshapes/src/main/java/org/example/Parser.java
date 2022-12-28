package org.example;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Parser {
    private Scanner scanner = null;
    public Point parsePoint()       //each line with every call, one by one
    {
        if (scanner!=null && scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            int size = line.length();
            String x="";
            String y="";
            int cursor=0;
            while (line.charAt(cursor)!=',')        //well, no .split for this one
            {
                x=x+line.charAt(cursor);
                cursor++;
            }
            cursor+=2;
            while (cursor<size)
            {
                y=y+line.charAt(cursor);
                cursor++;
            }
            return new Point(Double.parseDouble(x),Double.parseDouble(y));
        } else {
            return null;
        }
    }
    public void readPointsFrom (String path) throws FileNotFoundException
    {
        File file = new File(path);
        scanner = new Scanner(file);
    }
    public boolean hasNextPoint ()
    {
        return scanner.hasNextLine();
    }
}
