package app.converter;

import app.structure.xml.SpellXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IWriter {
    void write(List<SpellXML> spells, File outputFile) throws IOException;
}
