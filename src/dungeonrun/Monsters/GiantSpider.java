package dungeonrun.Monsters;

import dungeonrun.Monsters.Monster;

public class GiantSpider extends Monster {
    
    public GiantSpider(){
        creatureIsA = "Giant Spider";

        initiative = 7;
        toughness = 1;
        attack = 2;
        agility = 3;
        frequency = 0.2;        //frequency = 20%
    }

    @Override
    public String toString() {
        return "GiantSpider";
    }
    
    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
        		 "                            ",
        		 "               )            ",
        		 "               (            ",
        		 "               )            ",
        		 "              (             ",//row 5
        		 "        /£  .-'''-.  /£     ",
        		 "       //££/  ...  £//££    ", 
        		 "       |/£| ,;;;;;, |/£|    ",
        		 "       //£££;-'''-;///££    ",
        		 "      //  £/   .   £/  ££   ",//row10
        		 "     (| ,-_| £ | / |_-, |)  ",
        		 "       //`__£.-.-./__`££    ",  
        		 "      // /.-(() ())-.£ ££   ",
        		 "     (£ |)   '---'   (| /)  ",
        		 "      ` (|           |) `   ",//row15
        		 "        (|           |)     ",
        		 "        (|           |)     ",
        		 "        £)           (/     ",                 
        		 "                            ",
        		 "                            ",//row20
        		 "                            "};
             //   1234567890123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}