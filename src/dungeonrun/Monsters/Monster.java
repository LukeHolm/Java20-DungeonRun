package dungeonrun.Monsters;

public class Monster extends Creatures {
    public double frequency;
    public boolean alive;

    public Monster() {
        super();
        alive = true;
    }
    
 // Returning a String array, so monster can be written row for row, with other figures further away on each row.
    public String[] displayStrings() {

        String[] ascii = {
        		"        ____			",
        		"    .-,(_''_),-.		",
        		"     \\_\\(),()/_/		",
        		"       (,___,)			",
        		"      ,-/`~`\\-,___	",
        		"     / /).:.('--._)	",
        		"    {_[ (_,_)			",
        		"        | Y |			",
        		"        | | |        	",
        		"       /  |  \\		",
        		"       \"\"\" \"\"\"  	"};
        
        return ascii;
    }

}
