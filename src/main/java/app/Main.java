package app;

import java.io.*;

import app.converter.JSON;
import app.converter.XML;

/**
 * Основной класс
 */
public class Main {
    enum convertType
    {
        XML_TO_JSON,
        JSON_TO_XML,
        INVALID
    }
    public static void main(String[] args) {
        XML xmlHelper = new XML();
        JSON jsonHelper = new JSON();

        if(args.length == 2)
        {
            try {
                File inputFile = new File(args[0]);
                File outputFile = new File(args[1]);
                switch(defineConversionType(args))
                {
                    case XML_TO_JSON -> jsonHelper.write(xmlHelper.read(inputFile), outputFile);
                    case JSON_TO_XML -> xmlHelper.write(jsonHelper.read(inputFile), outputFile);
                    default -> System.out.println("Такой тип преобразования не поддерживается.");
                }
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        else
        {
            System.err.println("Use: .jar <input-file> <output-file>");
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
