package dungeonrun;

public class Knight extends Creatures {
    
    public Knight(){
        creatureIsA = "Knight";

        initiative = 5;
        toughness = 9;
        attack = 6;
        agility = 4;
        
       
               
    }
    public void specialAbility() {
        //"Shield block". Blocks first attack of every encounter
    }
}
