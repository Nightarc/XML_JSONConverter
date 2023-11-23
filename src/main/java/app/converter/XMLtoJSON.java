package app.converter;

import app.structure.json.SpellJSON;
import app.structure.json.SpellTypeJSON;
import app.structure.json.SpellTypeListJSON;
import app.structure.xml.SpellBookXML;
import app.structure.xml.SpellXML;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class XMLtoJSON implements IReader, IWriter{
    ObjectMapper jsonMapper = new ObjectMapper();
    XmlMapper xmlMapper = new XmlMapper();

    @Override
    public List<SpellXML> read(File inputFile) throws IOException {
        return xmlMapper.readValue(inputFile, SpellBookXML.class).getSpells();
    }
    @Override
    public void write(List<SpellXML> spells, File outputFile) throws IOException {
        Map<String, List<SpellJSON>> typeMap = new HashMap<>();
        spells.forEach(spellXML -> typeMap.computeIfAbsent(spellXML.getType(), type -> new ArrayList<>())
                .add(SpellJSON.builder()
                        .id(spellXML.getId())
                        .name(spellXML.getName())
                        .uses(spellXML.getUses())
                        .manacost(spellXML.getManacost())
                        .damage(spellXML.getDamage())
                        .radius(spellXML.getRadius())
                        .speed(spellXML.getSpeed())
                        .lifetime(spellXML.getLifetime())
                        .castDelay(spellXML.getCastDelay())
                        .cooldown(spellXML.getCooldown())
                        .rarity(spellXML.getRarity())
                        .build()));

        SpellTypeListJSON spellTypes = new SpellTypeListJSON();
        typeMap.forEach((mapKey, mapValue) -> spellTypes.getTypes().add(
                SpellTypeJSON.builder()
                        .type(mapKey)
                        .spells(mapValue)
                        .build()));
        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, spellTypes);

    }

}
