package app.converter;

import app.structure.xml.SpellBookXML;
import app.structure.xml.SpellXML;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLtoJSON implements IReader, IWriter{
    XmlMapper mapper = new XmlMapper();

    @Override
    public List<SpellXML> read(File inputFile) throws IOException {
        return mapper.readValue(inputFile, SpellBookXML.class).getSpells();
    }
    @Override
    public void write(List<SpellXML> spells, String outputFile) {

    }

}
