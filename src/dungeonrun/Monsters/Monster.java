package dungeonrun.Monsters;

public class Monster extends Creatures {
    public double frequency;
    public boolean alive;

    public Monster() {
        super();
        alive = true;
    }
    
    @Override
    public String[] displayStrings() {

        String[] ascii = {
        		"                   ",
        		"        ____       ",
        		"    .-,(_''_),-.   ",
        		"     £_£(),()/_/   ",
        		"       (,___,)     ",
        		"      ,-/`~`£-,___ ",
        		"     / /).:.('--._)",
        		"    {_[ (_,_)      ",
        		"        | Y |      ",
        		"        | | |      ",
        		"        | | |      ",
        		"        | | |      ",
        		"       /  |  £     ",
        		"       ''' '''     ",
        		"  ",
        		"  "};
        
        String[] fixedAscii = ascii;

        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            fixedAscii[i] = ascii[i].replace("£", "\\");
        }

        return fixedAscii;
    }

}
