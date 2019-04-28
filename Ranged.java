//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Ranged extends Weapon
{
    protected String ammo;
    
    public Ranged()
    {}
    public Ranged(String n, float p, float w, int s, int d, String am)
    {
        name = n;
        price = p;
        weight = w;
        size = s;
        damage = d;
        ammo = am;
    }
    //accessor method
    public String getAmmo()
    {
        return ammo;
    }
    //mutator method
    public void setAmmo(String newAmmo)
    {
        ammo = newAmmo;
    }
    public String toString()
    {
        String am = "Weapon name: " + name + "\nAmmo type: " + ammo;
        return am;
    }
}
