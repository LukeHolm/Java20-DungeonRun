package dungeonrun.Characters;

import dungeonrun.Monsters.Creatures;

public class Heroes extends Creatures {

    public String playersName;
    public int highScore;
    public int mapPosX;
    public int mapPosY;
    public int playedGames;
    public int totalValuePointsEver;
    public int killedGiantSpidersEver;
    public int killedSkeletonsEver;
    public int killedOrcsEver;
    public int killedTrollsEver;

    public Heroes(String playersName) {
        this.playersName = playersName;
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

    public int getTotalValuePointsEver() {
        return totalValuePointsEver;
    }

    public void setTotalValuePointsEver(int totalValuePointsEver) {
        this.totalValuePointsEver = totalValuePointsEver;
    }

    public int getKilledGiantSpidersEver() {
        return killedGiantSpidersEver;
    }

    public void setKilledGiantSpidersEver(int killedGiantSpidersEver) {
        this.killedGiantSpidersEver = killedGiantSpidersEver;
    }

    public int getKilledSkeletonsEver() {
        return killedSkeletonsEver;
    }

    public void setKilledSkeletonsEver(int killedSkeletonsEver) {
        this.killedSkeletonsEver = killedSkeletonsEver;
    }

    public int getKilledOrcsEver() {
        return killedOrcsEver;
    }

    public void setKilledOrcsEver(int killedOrcsEver) {
        this.killedOrcsEver = killedOrcsEver;
    }

    public int getKilledTrollsEver() {
        return killedTrollsEver;
    }

    public void setKilledTrollsEver(int killedTrollsEver) {
        this.killedTrollsEver = killedTrollsEver;
    }

    public void Display() {

    }

}
