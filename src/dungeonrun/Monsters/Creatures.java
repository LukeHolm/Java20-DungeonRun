package dungeonrun.Monsters;

public class Creatures {
    public String creatureIsA;

    public int initiative;
    public int toughness;
    public int attack;
    public int agility;
    
 // Returning a String array, so creatures can be written row for row, with other figures further away on each row.
    public String[] displayStrings() {

        String[] ascii = {
            "         _______            ",
            "        /       \\           ",
            "       /         \\          ",
            "       |  O    O  |         ",
            "       \\         /          ", 
            "        \\       /           ", 
            "       /         \\          ", 
            "      /   Just    \\         ", 
            "     /  a silly    \\        ", 
            "    / figure for    \\       ", 
            "   /  test purposes  \\      ", 
            "   |      ______     |      ",
            "  __|     |    |    |__     ",
            " (_________)  (________)    "};
        
        return ascii;
    }
}
