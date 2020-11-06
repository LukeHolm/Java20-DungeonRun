package dungeonrun;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Map1 extends MapStart {

    Scanner input = new Scanner(System.in);

    public Map1(int sizeX, int sizeY) {
        
        Room[][] map = new Room[sizeX][sizeY];
        
        for (int k = 0; k < map.length; k++) {
            for (int l = 0; l < map.length; l++) {
                map[k][l] = new Room();  
            }      
        }
    }
    
    public void draw() {
        System.out.println("Draw rhe map");
    }
}
