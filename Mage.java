//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Mage extends Character
{
    
    public Mage(String name) 
    {
        super(name);
        health=60;
        totalHealth=60;
        stamina=70;
        totalStamina = 70;
        str = 1;
        stam = 1;
        intel = 1;
    }
    public String toString() 
    {
        String stats=super.toString()+"\nMana: "+mana;
        return stats;
    }
    public String fight() 
    {
        String message = name+" shoots a magic fireball.";
        mana=mana-10;
        return message;
    }
    public void drink(Liquids l)
    {
       if(inventory.contains(l))
        {
            l.consume(this.name);
            this.subInventory(l);
            this.health = this.health + l.getHeals();
            this.stamina = this.stamina + l.getRecovers();
            this.mana = this.mana + l.getRegains();
            
            if(this.mana > this.totalMana)
                    this.mana = this.totalMana;
            
            System.out.println(this.name + " heals for "+l.getHeals()+" Heals, "+ " and recovers " + l.getRecovers()
             +" Stamina, "+ " and ragains "+l.getRegains()+" Mana");
            System.out.println(this.name + " currently has " + this.getHealth()+ " health and " + this.getStamina() + " stamin and " 
                    + this.mana + " mana.");
        }
        else
            System.out.println(l.getName() + " item is not in your pack");
    }
    
}
