package app.structure.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

/**
 * Представляет класс, содержащий в себе шансы нахождения заклинания на определённых локациях в формате XML.
 */
//@Builder
@Data
public class RarityXML {
    @JacksonXmlProperty(localName = "tier")
    @JacksonXmlElementWrapper(useWrapping = false)
   // @Singular
    List<TierXML> rarityTiers;
}
