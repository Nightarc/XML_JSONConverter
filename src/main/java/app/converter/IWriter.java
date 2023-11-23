package app.converter;

import app.structure.xml.SpellXML;

import java.util.List;

public interface IWriter {
    void write(List<SpellXML> spells, String outputFile);
}
