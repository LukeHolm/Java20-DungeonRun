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
    
    @Override
    public String[] displayStrings() {

        String[] ascii = {
        		"\n         /^\\    ",
        		"\n    /\\   \"V\"  ",
        		"\n   /__\\   I     ",
        		"\n  //..\\\\  I    ",
        		"\n  \\].`[/  I     ",
        		"\n  /l\\/j\\  (]    ",
        		"\n /. ~~ ,\\/I     ",
        		"\n \\\\L__j^\\/I   ",
        		"\n  \\/--v}  I     ",
        		"\n  |    |  I      ",
        		"\n  |    l  I      ",
        		"\n_/j  L l\\_!     "};
             
        return ascii;
    }
}
