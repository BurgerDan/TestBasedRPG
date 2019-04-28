//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Weapon extends Item
{
    protected int damage;
    
    public Weapon()
    {}
    public Weapon(String n, float p, float w, int s, int d)
    {
        name = n;
        price = p;
        weight = w;
        size = s;
        damage = d;
    }
    //accessor method
    public int getDamage()
    {
        return damage;
    }
    //mutator method
    public void setDamage(int newDamage)
    {
        damage = newDamage;
    }
    public String toString()
    {
        String wpn = "Weapon name: " + name + "\nDamage amount " + damage;
        return wpn;
    }
}
