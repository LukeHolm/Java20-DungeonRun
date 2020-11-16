package dungeonrun.Monsters;
public class Skeleton extends Monster {

    public Skeleton(){
        creatureIsA = "Skeleton";

        initiative = 4;
        toughness = 2;
        attack = 3;
        agility = 3;
        frequency = 0.15;         //frequency = 15%
    }

    @Override
    public String toString() {
        return "Skeleton";
    }
    
    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
          		"                            ", 
         		"                            ",
        		"          .-.               ",
        		"         (o.o)              ",
        		"          |=|               ", //row 5
        		"           |                ",        		
        		"         __|__              ",
        		"       //.=|=.££            ",
        		"      // .=|=. ££           ",
        		"      ££ .=|=. //           ", //row 10
        		"       ££(_=_)//            ",
        		"        (:| |:)             ",
        		"         || ||              ",
        		"         || ||              ",        		
        		"         () ()              ", //row 15
        		"         || ||              ",  
        		"         || ||              ",        		      		
        		"         || ||              ",
        		"        ==' '==             ",
        		"                            ",//row 20
        		"                            "};
            //   1234567890123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}
