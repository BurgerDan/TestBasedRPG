///Continued by: Danny Young
//CSC 325 HW 2

public class Liquids extends Item implements Consumables
{
    protected int heals;
    protected int recovers;
    protected int regains;
    
    public Liquids(String n, float p, float w, int s, int heal, int recov, int regain)
    {
        name = n;
        price = p;
        weight = w;
        size = s;
        heals = heal;
        recovers = recov;
        regains = regain;
    }
    public void consume(String n)
    {
        System.out.println(n + " drinks a " + this.name);
    }
    
    //getters
    public int getHeals()
    {
        return heals;
    }
    public int getRecovers()
    {
        return recovers;
    }
    public int getRegains()
    {
        return regains;
    }
    //setters
    public void setHeals(int newHeal)
    {
        heals = newHeal;
    }
    public void setRecovers(int newRecover)
    {
        recovers = newRecover;
    }
    public void setRegains(int newRegain)
    {
        regains = newRegain;
    }
}
