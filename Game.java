//Original by Dr. Marc Beck
//Continued by: Danny Young
//CSC 325

//example found on https://stackoverflow.com/questions/11673679/when-adding-2-buttons-to-east-layout-only-1-shows

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Game 
{
    private JFrame frame = new JFrame("Adventures of Adventurers");
    private JPanel panel = new JPanel();
    private JPanel subPanel = new JPanel();
    private JPanel invPanel = new JPanel();
    private JPanel eventArea = new JPanel();
    private JPanel actionPanel = new JPanel();
    private JPanel statsPanel = new JPanel();
    //private TextField textField = new TextField("Enter your name here");
    private JTextArea area = new JTextArea("Choose your classa above", 5, 20);
    //private JButton archerButton = new JButton("Archer");
    //private JButton mageButton = new JButton("Magus");
    //private JButton fighterButton = new JButton("Fighter");
    private JButton northButton = new JButton("N");
    private JButton southButton = new JButton("S");
    private JButton eastButton = new JButton("E");
    private JButton westButton = new JButton("W");
    private JButton fightButton = new JButton("Fight");
    private JScrollPane scrollPane = new JScrollPane(area);
    
    public Item Board = new Item("Board", 1,1,1);
    
    private JLabel stats = new JLabel();
    private JList invField = new JList();
    private DefaultListModel<Item> invListModel = new DefaultListModel<Item>();
    private JScrollPane invScroll = new JScrollPane(invField);
    
    private boolean fight = false;
    private boolean done = false;
    
    Random rand = new Random();
    private Character player;
    private Goblin gob;
    Weapon wpn;
    
    public Game()
    {
        setup();
    }
    public void itemEquip(Character c, Item i)
    {
        System.out.println(c.getName() + " picks up an: " + i.getName());
        c.addInventory(i);
        
    }
    public void multiSkip(int skip)
    {
        for(int i = 0; i<skip; i++)
        {
            System.out.println();
        }
    }
    /*public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player=new Archer(textField.getText());
            area.setText(player.name + " has begun their adventure!");
            
            if(e.getSource() == archerButton)
            {
                archerButton.setVisible(false);
                mageButton.setVisible(false);
                fighterButton.setVisible(false);
                textField.setVisible(false);
                subPanel.setVisible(false);
                statsPanel.setVisible(true);
            }
            invPanel.setVisible(true);
            stats.setVisible(true);
            stats.setText(player.name+ " HEALTH: " + player.health+"/"+player.totalHealth + " STAMINA: "+ player.stamina+"/"+player.totalStamina);
            wpn= new Ranged("Bow", 3f, 1f, 2, 3, "arrows");
            //invField.setText(wpn.name);
        }
    }
    public class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player=new Mage(textField.getText());
            area.setText(player.name + " has begun their adventure!");
            
            if(e.getSource() == mageButton)
            {
                archerButton.setVisible(false);
                mageButton.setVisible(false);
                fighterButton.setVisible(false);
                textField.setVisible(false);
                subPanel.setVisible(false);
                statsPanel.setVisible(true);
            }
            invPanel.setVisible(true);
            stats.setVisible(true);
            stats.setText(player.name+ " HEALTH: " + player.health+"/"+player.totalHealth + " STAMINA"+ player.stamina+"/"+player.totalStamina + " MAGIC: "+
                    player.getMana() +"/"+ player.getTotalMana());
            wpn = new Weapon("Staff", 1f, 2f, 3, 1);
            //invField.setText(wpn.name);
        }
    }
    public class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player=new Fighter(textField.getText());
            area.setText(player.name + " has begun their adventure!");
            
            if(e.getSource() == fighterButton)
            {
                archerButton.setVisible(false);
                mageButton.setVisible(false);
                fighterButton.setVisible(false);
                textField.setVisible(false);
                subPanel.setVisible(false);
                statsPanel.setVisible(true);
            }
            invPanel.setVisible(true);
            stats.setVisible(true);
            stats.setText(player.name+ " HEALTH: " + player.health+"/"+player.totalHealth + " STAMINA: "+ player.stamina+"/"+player.totalStamina);
            wpn = new Weapon("Sword", 5f, 2f, 2, 3);
            //invField.setText(wpn.name);
        }
    }*/
    public class NorthButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player.move(0, 1);
            battleChance();
            if(fight == true)
                escape();
        }
    }
    public class SouthButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player.move(0, -1);
            battleChance();
            if(fight == true)
                escape();
        }
    }
    public class EastButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player.move(1, 0);
            battleChance();
            if(fight == true)
                escape();
        }
    }
    public class WestButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player.move(-1, 0);
            battleChance();
            if(fight == true)
                escape();
        }
    }
    public class FightButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource()==fightButton)
            {
                player.fight(wpn, gob);
                area.append("\n"+player.name + " attacks!");
                gob.fight();
                if(gob.getHealth()==0)
                {
                    fightButton.setEnabled(false);
                }
                System.out.println("\n"+player.name + " attacks!");
            }
            else
            {
                player.fight();
                area.append("\n"+player.name + " attacks!");
                gob.fight();
                if(gob.getHealth()==0)
                {
                    fightButton.setEnabled(false);
                }
            }
        }
    }
    public void setup()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frameVisible();
        frame.setSize(1280,840);
        frame.setResizable(false);
        frame.add(panel);
        invPanel.setLayout(new BoxLayout(invPanel, BoxLayout.Y_AXIS));
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        frame.add(statsPanel,BorderLayout.NORTH);
        frame.add(subPanel, BorderLayout.CENTER);
        frame.add(actionPanel, BorderLayout.EAST);
        frame.add(scrollPane, BorderLayout.SOUTH);
        area.setPreferredSize(new Dimension(30, 30));
        frame.add(invPanel, BorderLayout.WEST);
        //invPanel.setVisible(false);
        //subPanel.add(archerButton);
        //subPanel.add(mageButton);
        //subPanel.add(fighterButton);
        //subPanel.add(textField);
        invPanel.add(invField);
        invField.setSize(10, 15);
        actionPanel.add(northButton);
        actionPanel.add(southButton);
        actionPanel.add(eastButton);
        actionPanel.add(westButton);
        actionPanel.add(fightButton);
        fightButton.setEnabled(false);
        statsPanel.add(stats);
        area.setSize(20,20);
        //archerButton.addActionListener(new ButtonListener());
        //mageButton.addActionListener(new ButtonListener2());
        //fighterButton.addActionListener(new ButtonListener3());
        northButton.addActionListener(new NorthButton());
        southButton.addActionListener(new SouthButton());
        eastButton.addActionListener(new EastButton());
        westButton.addActionListener(new WestButton());
        statsPanel.setVisible(true);
        area.setEditable(true);
        //textField.setSize(15, 1);
        //textField.setEditable(true);
        
        area.add(scrollPane);
        invField.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        invField.setLayoutOrientation(JList.VERTICAL);
        invScroll.setPreferredSize(new Dimension(20,50));
        invField.setModel(invListModel);
        invListModel.addElement(Board);
        
        actionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setPreferredSize(new Dimension(200,200));
    }
    public void battleChance()
    {
        int temp = rand.nextInt(3);
        System.out.println(temp);
        if(temp == 2)
        {
            area.append("\n"+"A Goblin attacks!");
            gob = new Goblin("Goblin");
            fight = true;
            battle();
        }
        else
            area.append("\n"+"There is nothing here");
    }
    
    public void battle()
    {
            if(fight==true)
            {
                fightButton.setEnabled(true);
            }
            else
                fightButton.setEnabled(false);
    }
    public void escape()
    {
        if(rand.nextInt(1)==0)
        {
            player.health =0;
            area.append("The Goblin stabs you in the back");
        }
        else
            area.append("You escaped");
    }
    public void checkDeath()
    {
        if(player.health==0)
        {
            area.append("You have Died");
            northButton.setVisible(false);
            southButton.setVisible(false);
            eastButton.setVisible(false);
            westButton.setVisible(false);
            fightButton.setVisible(false);
        }
    }
    public void frameVisible()
    {
        if(done == true)
        {
            frame.setVisible(true);
        }
    }
    
    public static void main(String[] args) 
    {
        //Game myGame=new Game();
        GameStart charCreate = new GameStart();
        
        while(charCreate.isDone() == true)
        {
            //done = true;
            Game myGame=new Game();
        }
    }
    
}
