package app.structure.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SpellTypeListJSON {
    @JsonProperty(value = "spellTypes")
    List<SpellTypeJSON> types;

    public SpellTypeListJSON()
    {
        types = new ArrayList<>();
    }
    public SpellTypeListJSON(List<SpellTypeJSON> types)
    {
        this.types = types;
    }
}
