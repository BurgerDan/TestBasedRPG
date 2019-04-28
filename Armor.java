//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Armor extends Item
{
    protected int protection;
    
    //accessor method
    public int getProtection()
    {
        return protection;
    }
    //mutator method
    public void setProtection(int newProtection)
    {
        protection = newProtection;
    }
    public String toString()
    {
        String prot = "Armor name: " + name + "\nProtection amount" + protection;
        return prot;
    }
}
