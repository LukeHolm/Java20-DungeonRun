package dungeonrun;

public class Main {

    public static void main(String[] args) {
      StartMenu start = new StartMenu();
        start.main();
        //maps
        MapMenu play = new MapMenu();
        play.chooseMap();
        //end map

    }

}