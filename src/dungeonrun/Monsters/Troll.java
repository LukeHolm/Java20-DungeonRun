package dungeonrun;

import dungeonrun.Monsters.Monsters;

public class Troll extends Monsters {
    
    public Troll (){
        creatureIsA = "Troll";

        initiative = 2;
        toughness = 4;
        attack = 7;
        agility = 2;
        frequency = 0.05;         //frequency = 5%
    }
}
