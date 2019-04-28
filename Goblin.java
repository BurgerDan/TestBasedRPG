//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Goblin extends Character
{
    Melee punch = new Melee();
    public Goblin(String name)
    {
        super(name);
        health = 25;
        stamina = 50;
    }
    public String toString() 
    {
        String stats=super.toString();
        return stats;
    }
    public String fight(Weapon wpn, Character foe)
    {
        
        foe.setHealth(foe.getHealth()-wpn.damage);
        return this.name + " uses their " + wpn;
        /*
        Item wpn = new Weapon();
        for(Item i : inventory)
        {
            if(inventory.contains(wpn))
            {
                System.out.println(this.name + "uses it's " + wpn);
            }
            else
            {   System.out.println(this.name + " swings it's fist");
                punch.Fist(1);
            }
        }*/
        
    }
    
}
