//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325

public class Item 
{
    protected String name;
    protected float price;
    protected float weight;
    protected int size;
    public Item()
    {}
    
    public Item(String n, float p, float w, int s)
    {
        name = n;
        price = p;
        weight = w;
        size = s;
    }
    //accessor methods
    public String getName()
    {
        return name;
    }
    public float getPrice()
    {
        return price;
    }
    public float getWeight()
    {
        return weight;
    }
    public int getSize()
    {
        return size;
    }
    //mutator methods
    public void setName(String newName)
    {
        name= newName;
    }
    public void setPrice(float newPrice)
    {
        price = newPrice;
    }
    public void setWeight(float newWeight)
    {
        weight = newWeight;
    }
    public void setSize(int newSize)
    {
        size = newSize;
    }
    public String toString()
    {
        String item = name + ": \nValued at: " + price + "\nWeighs: " + weight + 
                "lbs. " + "\n" + "Sized at: " + size;
        return item;
    }
}
