import app.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainTests {
    private final PrintStream systemOut = System.out;
    private final PrintStream systemErr = System.err;
    private ByteArrayOutputStream err;
    private ByteArrayOutputStream out;

    @BeforeEach
    public void setupStreams()
    {
        err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreStreams()
    {
        System.setOut(systemOut);
        System.setOut(systemErr);
    }
    @Test
    void MainWithZeroInsufficientArguments()
    {
         try
         {
             String[] args = new String[0];
             Main.main(args);

             assertEquals("Использование: .jar <input-file> <output-file>", err.toString().trim());
         }
         catch(Exception e)
         {
             System.err.println(e.getMessage());
         }
    }

    @Test
    void MainWithSufficientArguments()
    {
        try
        {
            String[] args = {"src/test/resources/SpellXML.xml", "src/test/resources/outputTestJSON.json"};
            Main.main(args);

            assertTrue(Files.exists(Path.of("src/test/resources/outputTestJSON.json")));
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }


    @Test
    void MainWithTooManyArguments()
    {
        String[] args = {"src/test/resources/SpellXML.xml", "src/test/resources/outputTestJSON.json", "src/test/resources/SpellXML.xml"};
        Main.main(args);

        assertTrue(Files.exists(Path.of("src/test/resources/outputTestJSON.json")));

    }
    @Test
    void FilesNotFoundTest()
    {
        String[] args = {"xmlExample.xml", "jsonExample.json"};
        Main.main(args);
        assertEquals("xmlExample.xml (Не удается найти указанный файл)", err.toString().trim());

    }




}
