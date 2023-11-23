package app.structure.json;

import app.structure.xml.RarityXML;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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
