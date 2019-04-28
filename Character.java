//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

import java.util.ArrayList;

public class Character 
{
    protected String name;
    protected int health=100;
    protected int stamina=100;
    protected int x;
    protected int y;
    protected int totalHealth = 100;
    protected int totalStamina = 100;
    protected int mana=100;
    protected int totalMana = 100;
    protected int str;
    protected int stam;
    protected int intel;
    
    protected ArrayList<Item> inventory=new ArrayList<Item>();
    
    public Character(String name) 
    {
        this.name=name;
    }
    public String toString()
    {
        String stats="Name: "+this.name+"\nHealth: "+this.health+"\nStamina: "+this.stamina;
        return stats;
    }
    public void move(int deltaX, int deltaY) 
    {
        this.x+=deltaX;
        this.y+=deltaY;
    }
    public String fight()
    {
        String message = this.name + " swings their fist!";
        return message;
    }
    public String fight(Weapon wpn, Character foe)
    {
        
        String message=this.name + " uses their " + wpn.name + " against "+foe.name;
        int temp = foe.getHealth() - wpn.damage;
        foe.setHealth(temp);
        return message;
    }
    public void eat(Food f)
    {
        if(inventory.contains(f))
        {
            f.consume(this.name);
            this.subInventory(f);
            this.health = this.health + f.getHeals();
            this.stamina = this.stamina + f.getRecovers();
            if(this.health > this.totalHealth)
                this.health = this.totalHealth;
            
            if(this.stamina > this.totalStamina)
                this.stamina = this.totalStamina;
            System.out.println(this.name + " heals for "+f.getHeals()+ " and recovers " + f.getRecovers());
            System.out.println(this.name + " currently has " + this.getHealth()+ " health and " + this.getStamina() + " stamina");
        }
        else
            System.out.println(f.getName() + " item is not in your pack");
       
    }
    public void drink(Liquids l)
    {
       if(inventory.contains(l))
        {
            l.consume(this.name);
            this.subInventory(l);
            this.health = this.health + l.getHeals();
            this.stamina = this.stamina + l.getRecovers();
            if(this.health > this.totalHealth)
                this.health = this.totalHealth;
            
            if(this.stamina > this.totalStamina)
                this.stamina = this.totalStamina;
            
            System.out.println(this.name + " heals for "+l.getHeals()+ " and recovers " + l.getRecovers());
            System.out.println(this.name + " currently has " + this.getHealth()+ " health and " + this.getStamina() + " stamina");
        }
        else
            System.out.println(l.getName() + " item is not in your pack");
    }
    public void drink(Item d)
    {
        System.out.println("Glug, glug, you drink the " + d);
    }
    //Getter Methods
    public int getHealth() 
    {
        return health;
    }
    public int getStamina()
    {
        return stamina;
    }
    public int getX() 
    {
        return x;
    }
    public int getY() 
    {
        return y;
    }
    public String getName() 
    {
        return name;
    }
    public int getTotalHealth()
    {
        return totalHealth;
    }
    //setters
    public void setHealth(int health) 
    {
        this.health = health;
    }
    public void setStamina(int stamina) 
    {
        this.stamina = stamina;
    }
    public void setX(int x) 
    {
        this.x = x;
    }
    public void setY(int y) 
    {
        this.y = y;
    }
    public void setTotalHealth(int totalh)
    {
        totalHealth = totalh;
    }
    public void setTotalStamina(int totals)
    {
        totalStamina = totals;
    }
    
    //inventory related methods
    public ArrayList<Item> printInventory() 
    {
        for(Item i : inventory)
        {
            System.out.println(i);
        }
        return inventory;
    }
    public void addInventory(Item inv) 
    {
        this.inventory.add(inv);
    }
    public void subInventory(Item i)
    {
        this.inventory.remove(i);
    }
    public int getMana() 
    {
        return mana;
    }
    public void setMana(int mana) 
    {
        this.mana = mana;
    }
    public int getTotalMana()
    {
        return totalMana;
    }
    public void setTotalMana(int totMana) 
    {
        this.totalMana = totMana;
    }
}
