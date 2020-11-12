package dungeonrun.Characters;

import dungeonrun.Monsters.Creatures;

public class Thief extends Heroes {

    public Thief(String playersName) {
        super(playersName);
        initiative = 7;
        toughness = 5;
        attack = 5;
        agility = 7;
    }
    
    
    public void specialAbility(){
        //"Critical hit". Theif has 25% chance to do double damage every time Thief attacks.
    }
    @Override
     public String toString(){
        return "Thief name is " + playersName + "\n";
    }
    
    @Override
    public String[] displayStrings() {

        String[] ascii = {
        		   "          \\\\\\\\		",
        		   "           \\c .(	",
        		   "            \\ _/	",
        		   "         ___/(  /(	",
        		   "        /--/ \\\\//	",
        		   "    __ )/ /\\/ \\/	",
        		   "   `-.\\  //\\\\		",
        		   "      \\\\//  \\\\		",
        		   "       \\/    \\\\		",
        		   "              \\\\	",
        		   "              '--`	"};
             
        return ascii;
    }
    
}
