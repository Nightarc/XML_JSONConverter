package app.structure.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class SpellBookXML {
    @JacksonXmlProperty(localName = "spell")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SpellXML> spells;
}
