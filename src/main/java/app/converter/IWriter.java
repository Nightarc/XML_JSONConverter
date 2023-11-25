package app.converter;

import app.structure.xml.SpellBookXML;

import java.io.File;
import java.io.IOException;

/**
 * Интерфейс определяет метод записи в какой-то конкретный формат файлов.
 */
public interface IWriter {
    void write(SpellBookXML spells, File outputFile) throws IOException;
}
