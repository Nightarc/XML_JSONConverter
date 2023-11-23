package app.converter;

import app.structure.xml.SpellXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IReader {
    List<SpellXML> read(File inputFile) throws IOException;
}
