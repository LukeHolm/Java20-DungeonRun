package dungeonrun;

public class GiantSpider extends Monsters {
    
    public GiantSpider(){
        creatureIsA = "Giant Spider";

        initiative = 7;
        toughness = 1;
        attack = 2;
        agility = 3;
        frequency = 0.2;        //frequency = 20%
    }
}