package dungeonrun.Characters;

import dungeonrun.Monsters.Creatures;

public class Knight extends Heroes {

    public Knight(String playersName) {
        super(playersName);
        initiative = 5;
        toughness = 9;
        attack = 6;
        agility = 4;
    }
    

    public void specialAbility() {
        //"Shield block". Blocks first attack of every encounter
    }
    @Override
     public String toString(){
        return "Knight name is " + playersName + "\n";
    }
}
