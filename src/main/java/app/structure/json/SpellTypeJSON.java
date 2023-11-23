package app.structure.json;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SpellTypeJSON {
    String type;
    List<SpellJSON> spells;

}
