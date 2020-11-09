
package dungeonrun.Characters;

import dungeonrun.Monsters.Creatures;


public class Heroes extends Creatures {
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

    
    public void Display(){
        
    }

}
