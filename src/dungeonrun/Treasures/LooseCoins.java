package dungeonrun.Treasures;

public class LooseCoins extends Treasure {
    public LooseCoins(){
        treasureDescription = "some loose coins";
        name = "loose coins";
        value = 2;
        frequency = 0.4;
    }
  
    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "    _____________ ",
            " __|_____________|", // 2
            "|_____________|__ ",
            "  _|_____________|", // 4
            " |_____________|  ",
            " |_____________|_ ", // 6
            " _|______________|",
            "|______________|  "};// 8
        //   123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }

}
