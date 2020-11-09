package dungeonrun.Characters;

import dungeonrun.Monsters.Creatures;

public class Wizard extends Heroes {

    public Wizard(String playersName) {
        super(playersName);
        initiative = 6;
        toughness = 4;
        attack = 9;
        agility = 5;
    }
    
    
    public void specialAbility(){
        //"Ljussken". Wizard blinds monsters, therefore Wizard always has 80% chance to escape
    }
    @Override
     public String toString(){
        return "Wizard name is " + playersName + "\n";
    }
}
