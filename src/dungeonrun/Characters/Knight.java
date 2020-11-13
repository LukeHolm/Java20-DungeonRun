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
    
    @Override
    public String[] displayStrings() {

        String[] ascii = {
        	    "|£             //             ",
        		" ££           _!_             ",
        		"  ££         /___£            ",
        		"   ££        [+++]            ",
        		"    ££    _ _£^^^/_ _         ",
        		"     ££/ (    '-'  ( )        ",
        		"     /( £/ | {&}   /£ £       ",
        		"       £  / £     / _> )      ", 
        		"        ''`  >:::;-'`'''-.    ",
        		"            /:::/         £   ",
        		"           /  /||   {&}   |   ",
        		"          (  / (£         /   ",
        		"          / /   £'-.___.-'    ",
        		"        _/ /     £ £          ",
        		"       /___|    /___|         "};
    
        String[] fixedAscii = ascii;

        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }

        return fixedAscii;
    }
}
