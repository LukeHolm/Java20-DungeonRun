package dungeonrun.Characters;

import dungeonrun.Monsters.Creatures;

public class Wizard extends Creatures {
    
    public Wizard (){
        creatureIsA = "Wizard";

        initiative = 6;
        toughness = 4;
        attack = 9;
        agility = 5;
    }
    public void specialAbility(){
        //"Ljussken". Wizard blinds monsters, therefore Wizard always has 80% chance to escape
    }
}
