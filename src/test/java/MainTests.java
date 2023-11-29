import app.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainTests {
    private final PrintStream systemErr = System.err;
    private ByteArrayOutputStream err;

    @BeforeEach
    public void setupStreams()
    {
        err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreStreams()
    {
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

    @Test
    void UnsupportedFiles()
    {
        String[] args = {"pdfExample.pdf", "jsonExample.json"};
        Main.main(args);
        assertEquals("Такой тип преобразования не поддерживается.", err.toString().trim());

    }

    @Test
    void MainWithWrongArguments()
    {
        String[] args = {"TotallyAFile", "LooksLikeAFile"};
        Main.main(args);
        assertEquals("Такой тип преобразования не поддерживается.", err.toString().trim());

    }
}
