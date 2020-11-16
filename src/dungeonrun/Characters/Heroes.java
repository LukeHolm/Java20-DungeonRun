package dungeonrun.Characters;
import dungeonrun.Monsters.Creatures;
public class Heroes extends Creatures {

    public String playersName;
    public int highScore;
    public int mapPosX;
    public int mapPosY;
    public int playedGames;
    public int totalGold;
    public int giantSpidersKilled;
    public int skeletonsKilled;
    public int orcsKilled;
    public int trollsKilled;
    public int lastPosY;
    public int lastPosX;

    public Heroes(String playersName) {
        this.playersName = playersName;
        // Initialise variables
        highScore = 0;
        mapPosX = 0;
        mapPosY = 0;
        playedGames = 0;
        totalGold = 0;
        giantSpidersKilled = 0;
        skeletonsKilled = 0;
        orcsKilled = 0;
        trollsKilled = 0;
    }

    // Returning a String array, so characgters can be written row for row, with other figures further away on each row.
    public String[] displayStrings() {
        // Characters like '\' and '" 'messes upp the line lengths, since you need to write \\ and \" to get them in a string. 
        // Kan use '£' for '\' and '§' for '"' here, because of the replacement code below.
        String[] ascii = {
                "         §§§§§§§            ",
                "        /       £           ",
                "       /         £          ",
                "       |    O    O|         ",
                "       £       J /          ", // Row 5
                "        £       /           ",
                "       /         b          ",
                "      /   Just    £         ",
                "     /  a silly    b        ",
                "    / figure for    £       ", // Row 10
                "   /  test purposes, b      ",
                "  | will be overridden|     ",
                "  | in Knight, Wizard |     ",
                "  | and Thief.java    |     ",
                "   |      ______     |      ", // Row 15
                "    >     |    |    <       ",
                "    >     |    |    <       ",
                "    (     |    |    )       ",
                "     £    |    |   /        ",
                "  ___>    |    |   <___     ", // Row 20
                " d_________]  [________b    "};
        //   1234567890123456789012345678
        // Replace '£' with '\' and replace '§' with '"'
        for (int i = 0;
             i < ascii.length;
             i++) {
            ascii[i] = ascii[i].replace("£", "\\");
            ascii[i] = ascii[i].replace("§", "\"");
        }
        return ascii;
    }
}
