package app.converter;

import app.structure.xml.SpellBookXML;

import java.io.File;
import java.io.IOException;

public interface IWriter {
    void write(SpellBookXML spells, File outputFile) throws IOException;
}
