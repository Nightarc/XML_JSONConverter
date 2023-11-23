package app;

import java.io.*;

import app.converter.JSON;
import app.converter.XML;
import lombok.val;

public class Main {
    public static void main(String[] args) {
        val xmlInput = "src/test/resources/SpellXML.xml";
        val jsonInput = "src/test/resources/outputJSON.json";
        val jsonOutput = "src/test/resources/outputJSON.json";
        val xmlOutput = "src/test/resources/outputTestXML.xml";
        File xmlInputFile = new File(xmlInput);
        File jsonInputFile = new File(jsonInput);
        File xmlOutputFile = new File(xmlOutput);
        File jsonOutputFile = new File(jsonOutput);

        XML xmlConverter = new XML();
        JSON jsonConverter = new JSON();
        try {
            jsonConverter.write(xmlConverter.read(xmlInputFile), jsonOutputFile);
            xmlConverter.write(jsonConverter.read(jsonInputFile), xmlOutputFile);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }




}
