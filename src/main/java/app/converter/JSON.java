package app.converter;

import app.structure.json.SpellJSON;
import app.structure.json.SpellType;
import app.structure.json.SpellTypeListJSON;
import app.structure.xml.SpellBookXML;
import app.structure.xml.SpellXML;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JSON implements IReader, IWriter {
    ObjectMapper jsonMapper = new ObjectMapper();
    @Override
    public SpellBookXML read(File inputFile) throws IOException {
        return new SpellBookXML(
                jsonMapper.readValue(inputFile, SpellTypeListJSON.class).getTypes()
                .stream()
                .flatMap(spellType -> spellType.getSpells().stream()
                    .map(spellJSON -> SpellXML.builder()
                            .id(spellJSON.getId())
                            .name(spellJSON.getName())
                            .uses(spellJSON.getUses())
                            .type(spellType.getName())
                            .manacost(spellJSON.getManacost())
                            .damage(spellJSON.getDamage())
                            .radius(spellJSON.getRadius())
                            .speed(spellJSON.getSpeed())
                            .lifetime(spellJSON.getLifetime())
                            .castDelay(spellJSON.getCastDelay())
                            .cooldown(spellJSON.getCooldown())
                            .rarity(spellJSON.getRarity())
                            .build())
                )
                .toList()
        );

    }
    @Override
    public void write(SpellBookXML spells, File outputFile) throws IOException {
        Map<String, List<SpellJSON>> typeMap = new HashMap<>();
        spells.getSpells().
                forEach(spellXML -> typeMap.computeIfAbsent(spellXML.getType(), type -> new ArrayList<>())
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
                SpellType.builder()
                        .name(mapKey)
                        .spells(mapValue)
                        .build()));
        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, spellTypes);

    }
}
