package app.converter;

import app.structure.xml.SpellBookXML;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Класс, обрабатывающий файлы формата XML.
 */
public final class XML implements IReader, IWriter{
    XmlMapper xmlMapper = new XmlMapper();

    @Override
    public SpellBookXML read(File inputFile) throws IOException {
        return xmlMapper.readValue(inputFile, SpellBookXML.class);
    }
    @Override
    public void write(SpellBookXML spells, File outputFile) throws IOException {
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, spells);
    }

}
