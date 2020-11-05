package dungeonrun.Monsters;

import dungeonrun.Monsters.Monsters;

public class Orc extends Monsters {
    
    public Orc() {
        creatureIsA = "Orc";

        initiative = 6;
        toughness = 3;
        attack = 4;
        agility = 4;
        frequency = 0.1;         //frequency = 10%

    }
}
