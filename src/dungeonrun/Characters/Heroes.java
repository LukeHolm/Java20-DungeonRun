
package dungeonrun.Characters;


public class Heroes {
    public String playersName;

    public Heroes(String playersName) {
        this.playersName = playersName;
    }

    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }
    
    public int initiative;
    public int toughness;
    public int attack;
    public int agility;
    
    public void Display(){
        
    }

}
