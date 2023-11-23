package app;

import java.io.*;

import app.converter.XMLtoJSON;
import lombok.val;

public class Main {
    public static void main(String[] args) {
        val input = "src/test/resources/SingleSpell.xml";
        File file = new File(input);

        XMLtoJSON converter = new XMLtoJSON();
        try {
            System.out.println(converter.read(file));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }




}
