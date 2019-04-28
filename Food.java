//Continued by: Danny Young
//CSC 325 HW 2

public class Food extends Item implements Consumables
{
    protected int heals;
    protected int recovers;
    
    
    public Food(String n, int h, int r, float p, float w, int s)
    {
        name = n;
        heals = h;
        recovers = r;
        price = p;
        weight = w;
        size = s;
    }
    public void consume(String n)
    {
        System.out.println(n + " eats a " + this.name);
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
    //setters
    public void setHeals(int newHeal)
    {
        heals = newHeal;
    }
    public void setRecovers(int newRecover)
    {
        recovers = newRecover;
    }
}
