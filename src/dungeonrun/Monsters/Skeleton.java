package dungeonrun.Monsters;

import dungeonrun.Monsters.Monster;

public class Skeleton extends Monster {

    public Skeleton(){
        creatureIsA = "Skeleton";

        initiative = 4;
        toughness = 2;
        attack = 3;
        agility = 3;
        frequency = 0.15;         //frequency = 15%
    }

    @Override
    public String toString() {
        return "Skeleton";
    }
}
