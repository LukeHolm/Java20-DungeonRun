package dungeonrun.Treasures;

public class Treasure {

    public String treasureDescription;
    public String name;
    public int value;
    public double frequency;

    // Returning a String array of the treaasiures looks, so characters can be written row for row, with other things further away on each row.
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "     ________     ",
            "    /   Just £    ", // 2
            "   /  a silly £   ",
            "  / figure for £  ", // 4
            " /test purposes £ ",
            "| will be        |", // 6
            "| overrridden    |",
            " £______________/ "}; // 8
        //   123456789012345678
        // Replace "£" with "\"
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = ascii[i].replace("£", "\\");
        }
        return ascii;
    }
}
