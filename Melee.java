//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Melee extends Weapon
{
    protected String damageType;
    
    public Melee()
    {}
    public Melee(String n, float p, float w, int s, int d)
    {
        name = n;
        price = p;
        weight = w;
        size = s;
        damage = d;
        damageType = "Bludgeoning";
    }
    public void Fist(int d)
    {
        name = "Fist";
        damage = d;
        damageType = "";
    }
    //accessor method
    public String getDamageType()
    {
        return damageType;
    }
    //mutator method
    public void setDamageType(String newDamageType)
    {
        damageType = newDamageType;
    }
    public String toString()
    {
        String dType = "Weapon name: " + name + "\nDamage type: " + damageType;
        return dType;
    }
}
