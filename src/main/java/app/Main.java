package app;

import java.io.*;

import app.converter.XML;
import lombok.val;

public class Main {
    public static void main(String[] args) {
        val input = "src/test/resources/outputJSON.json";
        val output = "src/test/resources/outputTestXML.xml";
        File inputFile = new File(input);
        File outputFile = new File(output);

        XML xmlConverter = new XML();
        try {
            xmlConverter.write(xmlConverter.read(inputFile), outputFile);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }




}
