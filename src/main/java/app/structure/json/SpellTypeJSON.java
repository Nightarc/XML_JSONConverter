package app.structure.json;

import lombok.Data;

import java.util.List;
@Data
public class SpellTypeJSON {
    String type;
    List<SpellJSON> spells;
}
