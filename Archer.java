//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325 HW 2

public class Archer extends Character
{
    int arrows=10;

    public Archer(String name) 
    {
        super(name);
        str = 1;
        stam = 1;
        intel = 1;
    }
// TODO Auto-generated constructor stub}
    public String toString() 
    {
        String stats=super.toString()+"\nArrows: "+arrows;return stats;
    }    
    public String fight() 
    {
        String message = super.name+" shoots an arrow.";
        arrows--;
        return message;
    }
}