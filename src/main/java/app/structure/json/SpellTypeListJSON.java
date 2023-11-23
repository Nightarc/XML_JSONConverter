package app.structure.json;

import lombok.Data;

import java.util.Map;

@Data
public class SpellTypeListJSON {
    Map<String, SpellTypeJSON> types;
}
