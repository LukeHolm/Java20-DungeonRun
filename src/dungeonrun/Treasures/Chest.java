package dungeonrun.Treasures;

public class Chest extends Treasure {

    public Chest() {
        treasureDescription = "a small treasure chest";
        name = "small treasure chest";
        value = 20;
        frequency = 0.02;        //frequency = 20%
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of"\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "                  ",
            "                  ", // 2
            "  ,------------,  ",
            " /______d_____/ £ ", // 4
            " £    £   /   £  )",
            "  £__£__db__/__£.'", // 6
            " ,----/888£----,| ",
            "|=='==8==='==|' | ", // 8
            "|    (d)     |  | ",
            "|            | _' ",
            "|------------|'   "}; // 10
        //   123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }

}
