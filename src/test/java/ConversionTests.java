import app.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTests {
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
    void FileHandlingError()
    {
        String[] args = {"src/test/resources/WrongSpellXML.xml", "src/test/resources/jsonExample.json"};
        Main.main(args);
        assertEquals("Произошла ошибка при чтении/записи файла", err.toString().trim());
    }

    @Test
    void EmptyFileReading()
    {
        String[] args = {"src/test/resources/EmptySpellXML.xml", "src/test/resources/jsonExample.json"};

        Main.main(args);
        assertEquals("Ошибка: пустой файл для чтения", err.toString().trim());
    }

    @Test
    void EmptyExistingFileWrite()
    {
        String[] args = {"src/test/resources/SpellXML.xml", "src/test/resources/jsonEmpty.json"};
        Main.main(args);

        File output = new File(args[1]);
        try {
            assertNotSame("", new BufferedReader(new FileReader(output)).readLine());
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    //Error while trying to open file for write with wrong permissions(read only flag)
    @Test
    void FailOpeningFileForWrite()
    {
        String[] args = {"src/test/resources/SpellXML.xml", "src/test/resources/jsonEmptyProtected.json"};
        Main.main(args);
        assertEquals("src\\test\\resources\\jsonEmptyProtected.json (Отказано в доступе)", err.toString().trim());
    }
}
