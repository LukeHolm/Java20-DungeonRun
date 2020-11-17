package dungeonrun.Monsters;

import dungeonrun.Map;

public class GiantSpider extends Monster {

    public GiantSpider() {
        creatureIsA = "Giant Spider";

        initiative = 7;
        toughness = 1;
        attack = 2;
        agility = 3;
        frequency = 0.2;        //frequency = 20%
    }

    @Override
    public String toString() {
        return "GiantSpider";
    }

    @Override
    public String[] displayStrings() {
        // Here you can use "£" instead of "\\" so the rows lines up, and it will be replaced with "\" in the code below 
        String[] ascii = {
            "             (              ",
            "              )             ",
            "             (              ",
            "              )             ",
            "       _     (       _      ",//row 5
            "      / £  .-'''-.  / £     ",
            "     // ££/  ...  £// ££    ",
            "    // /£| ,;;;;;, |/£ ££   ",
            "   // //£££;-'''-;///££ ££  ",
            "   | //  £/   .   £/  ££ |  ",//row10
            "    // ,-_| £ | / |_-, ££   ",
            "   // //`__£.-.-./__`££ ££  ",
            "  (| // /.-o() ()o-.£ ££ |) ",
            "    // //  '{|-|}' ££ ££    ",
            "   // //    || ||    ££ ££  ",//row15
            "  // //     £| |/     ££ ££ ",
            "  ` (|                 |) ´ ",
            "     ££               //    ",
            "      ££             //     ",
            "       ££           //      ",//row20
            "        £)         (/       "};
        //   1234567890123456789012345678
        
       String[] color = {
            "             m              ",
            "              m             ",
            "             m              ",
            "              m             ",
            "       _     m       r      ",//row 5
            "      / £  .-'''-.  / £     ",
            "     // ££/  ...  £// ££    ",
            "    // /£| ,;;;;;, |/£ ££   ",
            "   // //£££;-'''-;///££ ££  ",
            "   | //  £/   .   £/  ££ |  ",//row10
            "    // ,-_| £ | / |_-, ££   ",
            "   // //`__£.-.-./__`££ ££  ",
            "  (| // /.-zy) ()zr.£ ££ |) ",
            "    // //  'm|rm}r ££ ££    ",
            "   // //    m| ||    r£ ££  ",//row15
            "  // //     m| |/     r£ ££ ",
            "  ` (|                 |) ´ ",
            "     ££               //    ",
            "      ££             //     ",
            "       ££           //      ",//row20
            "        £)         (/       "};
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
                chr = color[row].charAt(x);

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
