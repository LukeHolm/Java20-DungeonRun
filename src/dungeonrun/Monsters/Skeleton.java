package DungeonRun;


public class Skeleton extends Monsters{
    
    public Skeleton(){
        creatureIsA = "Skeleton";

        initiative = 4;
        toughness = 2;
        attack = 3;
        agility = 3;
        frequency = 0.15;         //frequency = 15%
    }
}
