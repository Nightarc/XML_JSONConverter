package app;

import java.io.*;

import app.converter.XMLtoJSON;
import lombok.val;

public class Main {
    public static void main(String[] args) {
        val input = "src/test/resources/SpellXML.xml";
        val output = "src/test/resources/outputJSON.json";
        File inputFile = new File(input);
        File outputFile = new File(output);

        XMLtoJSON converter = new XMLtoJSON();
        try {
            System.out.println(converter.read(inputFile));
            converter.write(converter.read(inputFile), outputFile);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }




}
