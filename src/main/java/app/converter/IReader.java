package app.converter;

import app.structure.xml.SpellBookXML;

import java.io.File;
import java.io.IOException;

/**
 * Интерфейс определяет метод чтения какого-то конкретного формата файлов.
 */
public interface IReader {
    SpellBookXML read(File inputFile) throws IOException;
}
