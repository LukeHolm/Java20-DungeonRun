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

    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getMapPosX() {
        return mapPosX;
    }

    public void setMapPosX(int mapPosX) {
        this.mapPosX = mapPosX;
    }

    public int getMapPosY() {
        return mapPosY;
    }

    public void setMapPosY(int mapPosY) {
        this.mapPosY = mapPosY;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    public int getGiantSpidersKilled() {
        return giantSpidersKilled;
    }

    public void setGiantSpidersKilled(int giantSpidersKilled) {
        this.giantSpidersKilled = giantSpidersKilled;
    }

    public int getSkeletonsKilled() {
        return skeletonsKilled;
    }

    public void setSkeletonsKilled(int skeletonsKilled) {
        this.skeletonsKilled = skeletonsKilled;
    }

    public int getOrcsKilled() {
        return orcsKilled;
    }

    public void setOrcsKilled(int orcsKilled) {
        this.orcsKilled = orcsKilled;
    }

    public int getTrollsKilled() {
        return trollsKilled;
    }

    public void setTrollsKilled(int trollsKilled) {
        this.trollsKilled = trollsKilled;
    }

    /* public void fightMonsters(Map map) {
        
        // TODO: overide this nethod in the three Hero classes
        // System.out.println("Code for Fighting monsters is not quite linked in yet, pretending a bit now...");
        for (Monster monster : map.rooms[mapPosX][mapPosY].monsters) {
            System.out.println("Fighting " + monster.getClass().getSimpleName() + "... and you won!");
            // System.out.println("Press <enter> to continue");
        }
        System.out.println("Congratulations, you have defeated all monsters in this room!");
        //map.rooms[mapPosX][mapPosY].monsters.clear();
    }*/
    
    // Returning a String array, so characgters can be written row for row, with other figures further away on each row.
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
            "   /  test purposes, \\      ", 
            "  | will be overridden|     ",
            "  | in Knight, Wizard |     ",
            "  | and Thief.java    |     ",
            "   |      ______     |      ",
            "  __|     |    |    |__     ",
            " (_________)  (________)    "};
        
        return ascii;
    }
}
