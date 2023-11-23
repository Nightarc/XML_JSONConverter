package app.converter;

import app.structure.xml.SpellBookXML;

import java.io.File;
import java.io.IOException;


public interface IReader {
    SpellBookXML read(File inputFile) throws IOException;
}
