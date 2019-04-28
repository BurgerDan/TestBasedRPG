//Continued by: Danny Young
//CSC 325 HW 2

public class Fighter extends Character
{
    //private Melee wpn = new Melee();
    public Fighter(String name)
    {
        super(name);
        health = 120;
        totalHealth=120;
        stamina = 150;
        totalStamina = 150;
        str = 1;
        stam = 1;
        intel = 1;
    }
    public String toString() 
    {
        String stats=super.toString();
        return stats;
    }
    public void fight(Weapon wpn)
    {
        System.out.println(this.name + " uses their " + wpn);
    }
    
}
