package dungeonrun.Treasures;

public class LooseCoins extends Treasure {

    public LooseCoins() {
        treasureDescription = "some loose coins";
        name = "loose coins";
        value = 2;
        frequency = 0.4;
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "        _____     ",
            "       /     £    ", // 2
            "      |       |   ",
            "   ____£_____/__  ", // 4
            "  /     £ /     £ ",
            " |       |       |", // 6
            "  £_____/ £_____/ ", 
            " /     £  /     £ ", // 8
            "|       ||       |", 
            " £_____/  £_____/ "};// 10
        //   123456789012345678       
        
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }

}
