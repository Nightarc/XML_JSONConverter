package app;

import java.io.*;

import app.converter.JSON;
import app.converter.XML;

public class Main {
    enum convertType
    {
        XML_TO_JSON,
        JSON_TO_XML,
        INVALID
    }
    public static void main(String[] args) {
        XML XMLHelper = new XML();
        JSON JSONHelper = new JSON();

        if(args.length == 2)
        {
            try {
                File inputFile = new File(args[0]);
                File outputFile = new File(args[1]);
                switch(defineConversionType(args))
                {
                    case XML_TO_JSON -> JSONHelper.write(XMLHelper.read(inputFile), outputFile);
                    case JSON_TO_XML -> XMLHelper.write(JSONHelper.read(inputFile), outputFile);
                    default -> System.out.println("Такой тип преобразования не поддерживается.");
                }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Use: .jar <input-file> <output-file>");
        }
    }

    public static convertType defineConversionType(String[] args)
    {
        if (args[0].endsWith(".xml") && args[1].endsWith(".json")) {
            return convertType.XML_TO_JSON;

        }
        if (args[0].endsWith(".json") && args[1].endsWith(".xml")) {
            return convertType.JSON_TO_XML;
        }

        return convertType.INVALID;
    }
}
