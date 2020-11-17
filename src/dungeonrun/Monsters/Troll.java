package dungeonrun.Monsters;

import dungeonrun.Map;

public class Troll extends Monster {

    public Troll() {
        creatureIsA = "Troll";

        initiative = 2;
        toughness = 4;
        attack = 7;
        agility = 2;
        frequency = 0.05;         //frequency = 5%
    }

    @Override
    public String toString() {
        return "Troll";
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "          ..                ",
            "        .:::.               ",
            "       .:£:/:.              ",
            "     .:£:£:/:/:.            ",
            "    ..:£:£:/:/:..           ",//row5
            "    :.:£:£:/:/:.:           ",
            "   :=.' -   - '.=:          ",
            "   '=(£ 9   9 /)='          ",
            "      (  (_)  )             ",
            "      /`-vvv-'£             ",//row10
            "     /         £     (      ",
            "    / /|,,,,,|£ £ )  )  )   ",
            "   /_//       ££_£  (  (    ",
            "  /_//   /^£   ££_£  )  )   ", 
            "  WW(   (   )   )WW (  (    ",//row15
            "   | £,,,£ /,,,/  )  )  )   ",
            "   |  |  | |  |,----------, ",
            "   O  |  | |  |d          b ",
            "      |  | |  | £        /  ",
            "    __|  | |  |__£______/   ",//row20
            "   (______Y______)=======   "};
        //   1234567890123456789012345678

        String[] colors= {
            "          ..                ",
            "        .:::.               ",
            "       .:£:/:.              ",
            "     .:£:£:/:/:.            ",
            "    ..:£:£:/:/:..           ",//row5
            "    :.:£:£:/:/:.:           ",
            "   :=.' -   - '.=:          ",
            "   '=(£ y   9 r)='          ",
            "      (  (_)  )             ",
            "      /`-***-'£             ",//row10
            "     /         £            ",
            "    / /|,,,,,|£ £ m  )  )   ",
            "   /_//       ££_£  m  (    ",
            "  /_//   /^£   ££_£  m  )   ", 
            "  WW(   (   )   )WW m  (    ",//row15
            "   m r,,,£ /,,,/  m  )  )   ",
            "   m  r  | |  |m----------, ",
            "   m  r  | |  |m          * ",
            "      |  | |  | m        /  ",
            "    __|  | |  |__m______/   ",//row20
            "   (______Y______)y======   "};
        //   1234567890123456789012345678
        
        String str;
        String[] coloredAscii = new String[ascii.length];
        char chr;
        for (int row = 0; row < ascii.length; row++) {
            // Replace '£' with '\' and replace '§' with '"'
            ascii[row] = ascii[row].replace("£", "\\");
            ascii[row] = ascii[row].replace("§", "\"");

            str = "";
            for (int x = 0; x < ascii[row].length(); x++) {

                // Get the corresponding location in the color strings, and check if it's lower case letter
                chr = colors[row].charAt(x);

                if (Character.isLowerCase(chr)) {
                    //  Lookup the corresponding color code, and add it to the output string
                    str += Map.colorLookup[(int) (chr - 'a')];
                }
                // Always add the chracter from the ascii strings
                str += ascii[row].charAt(x);
            }
            coloredAscii[row] = str;
        }
        return coloredAscii;
    }
}
