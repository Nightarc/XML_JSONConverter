package app.structure.json;

import app.structure.xml.RarityXML;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Представляет класс заклинания с его характеристиками в формате JSON.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SpellJSON {
    int id;
    String name;
    int uses; // Количество использований
    int manacost; // Количество потребляемой маны
    int damage; // Урон наносимый
    int radius; // Радиус действия
    int speed; // Скорость полёта снаряда (если заклинание типа Снаряд)
    int lifetime; // Длительность полёта снаряда
    double castDelay; //Задержка перед использованием следующего
    double cooldown; // Перезарядка
    RarityXML rarity; // Шансы нахождения на определённых локациях

}
