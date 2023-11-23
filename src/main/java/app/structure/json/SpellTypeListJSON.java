package app.structure.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;

@Data
public class SpellTypeListJSON {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = WRAPPER_OBJECT)
    @JsonProperty(value = "spellTypes")
    List<SpellType> types;

    public SpellTypeListJSON()
    {
        types = new ArrayList<>();
    }
    public SpellTypeListJSON(List<SpellType> types)
    {
        this.types = types;
    }
}
