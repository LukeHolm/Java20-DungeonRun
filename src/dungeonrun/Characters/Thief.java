public class Thief extends Creatures {
    
    public Thief(){
        creatureIsA = "Theif";

        initiative = 7;
        toughness = 5;
        attack = 5;
        agility = 7;
    }
    public void specialAbility(){
        //"Critical hit". Theif has 25% chance to do double damage every time Thief attacks.
    }
}
