package app.structure.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Представляет класс контейнер заклинаний одного типа в формате JSON.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpellType {
    String name;
    List<SpellJSON> spells;

}
