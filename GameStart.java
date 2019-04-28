//Continued by: Danny Young
//CSC 325

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GameStart 
{
    private int str = 1;
    private int sta = 1;
    private int intel = 1;
    
    private String name;
    private String charClass;
    
    private ImageIcon archerImage = new ImageIcon("PatrioticPenguin.gif");
    private ImageIcon wizardImage = new ImageIcon("kawaiicatfigh.jpg");
    private ImageIcon fighterImage= new ImageIcon("PeeBee_Shrek.jpg");
    
    private JPanel imagePanel = new JPanel();
    private JLabel archerLabel = new JLabel(archerImage);
    private JLabel wizardLabel = new JLabel(wizardImage);
    private JLabel fighterLabel = new JLabel(fighterImage);
    
    private boolean done = false;
    private JFrame charFrame = new JFrame("Adeventure of Adventurers");
    private JPanel namePanel = new JPanel();
    private JPanel classPanel = new JPanel();
    private JPanel racePanel = new JPanel();
    private JPanel statsPanel = new JPanel();
    private JTextField charName=new JTextField(20);
    private JLabel charLabel = new JLabel("Enter name here");
    private JButton createBut = new JButton("Create");
    private JButton consoleBut = new JButton("Console Display");
    private JRadioButton archerBut = new JRadioButton("Archer");
    private JRadioButton mageBut = new JRadioButton("Mage");
    private JRadioButton fighterBut = new JRadioButton("Fighter");
    private String[] races = {"Human","Halfling","Elf","Dwarf","Half-Orc","Gnome", "Crazy-Cat Lady"};
    private JComboBox raceCombo = new JComboBox(races);
    private JLabel strLabel = new JLabel("Strength");
    private JLabel staLabel = new JLabel("Stamina");
    private JLabel intLabel = new JLabel("Intelligence");
    private JTextArea strArea = new JTextArea(Integer.toString(str));
    private JTextArea staArea = new JTextArea(Integer.toString(sta));
    private JTextArea intArea = new JTextArea(Integer.toString(intel));
    private JButton strdecBut = new JButton("v");
    private JButton straddBut = new JButton("^");
    private JButton stadecBut = new JButton("v");
    private JButton staaddBut = new JButton("^");
    private JButton intdecBut = new JButton("v");
    private JButton intaddBut = new JButton("^");
    
    public GameStart()
    {
        setup();
    }
    public void setup()
    {
        charFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charFrame.setVisible(true);
        charFrame.setSize(1000,1000);
        charFrame.setResizable(false);
        charFrame.add(namePanel);
        charName.setColumns(20);
        charName.setEditable(true);
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(charLabel);
        namePanel.add(charName);
        
        charFrame.add(imagePanel);
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.add(archerLabel);
        imagePanel.add(wizardLabel);
        imagePanel.add(fighterLabel);
        
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        namePanel.add(classPanel);
        classPanel.add(archerBut);
        classPanel.add(mageBut);
        classPanel.add(fighterBut);
        archerBut.addActionListener(new radioButtons());
        
        racePanel.setLayout(new BoxLayout(racePanel, BoxLayout.Y_AXIS));
        classPanel.add(racePanel);
        racePanel.add(raceCombo);
        
        statsPanel.setLayout(new GridLayout(3,2));
        strArea.setEditable(false);
        staArea.setEditable(false);
        intArea.setEditable(false);
        
        racePanel.add(statsPanel);
        statsPanel.add(strLabel);
        statsPanel.add(strdecBut);
        strdecBut.addActionListener(new decButtons());
        statsPanel.add(strArea);
        statsPanel.add(straddBut);
        straddBut.addActionListener(new addButtons());
        statsPanel.add(staLabel);
        stadecBut.addActionListener(new decButtons());
        statsPanel.add(stadecBut);
        statsPanel.add(staArea);
        statsPanel.add(staaddBut);
        staaddBut.addActionListener(new addButtons());
        statsPanel.add(intLabel);
        statsPanel.add(intdecBut);
        intdecBut.addActionListener(new decButtons());
        statsPanel.add(intArea);
        statsPanel.add(intaddBut);
        intaddBut.addActionListener(new addButtons());
        raceCombo.setSelectedIndex(6);
        
        namePanel.add(createBut);
        createBut.addActionListener(new CreateButton());
        namePanel.add(consoleBut);
        consoleBut.addActionListener(new ConsoleButton());
    }
    public class radioButtons implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==archerBut)
            {
                charClass = "Archer";
            }
            else if(e.getSource()==mageBut)
            {
                charClass = "Mage";
            }
            else if(e.getSource()==fighterBut)
            {
                charClass = "Fighter";
            }
        }
    }
    public class addButtons implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==straddBut)
            {
                str++;
                strArea.setText(Integer.toString(str));
                checkSum();
            }
            else if(e.getSource()==staaddBut)
            {
                sta++;
                staArea.setText(Integer.toString(sta));
                checkSum();
            }
            else if(e.getSource()==intaddBut)
            {
                intel++;
                intArea.setText(Integer.toString(intel));
                checkSum();
            }
        }
    }
    public class decButtons implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==strdecBut)
            {
                str--;
                strArea.setText(Integer.toString(str));
                checkSum();
            }
            else if(e.getSource()==stadecBut)
            {
                sta--;
                staArea.setText(Integer.toString(sta));
                checkSum();
            }
            else if(e.getSource()==intdecBut)
            {
                intel--;
                intArea.setText(Integer.toString(intel));
                checkSum();
            }
        }
    }
    public void checkSum()
    {
        int total = str+sta+intel;
        
        if(total==100)
        {
            straddBut.setEnabled(false);
            staaddBut.setEnabled(false);
            intaddBut.setEnabled(false);
        }
        else
        {
            straddBut.setEnabled(true);
            staaddBut.setEnabled(true);
            intaddBut.setEnabled(true);
        }
        if(total==0)
        {
            strdecBut.setEnabled(false);
            stadecBut.setEnabled(false);
            intdecBut.setEnabled(false);
        }
        else
        {
            strdecBut.setEnabled(true);
            stadecBut.setEnabled(true);
            intdecBut.setEnabled(true);
        }
    }
    public class CreateButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==createBut)
            {
                done = true;
            }
        }
    }
    public class ConsoleButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==consoleBut)
            {
                
                name = charName.getText();
                System.out.println("Character Name: " + name);
                System.out.println("Character Class: " + charClass);
                System.out.println("Character Race: " + raceCombo.getSelectedIndex());
                System.out.println("Strength: " + strArea.getText());
                System.out.println("Stamina: " + staArea.getText());
                System.out.println("Intelligence: " + intArea.getText());
                charFrame.dispose();
            }
        }
    }
    
    public boolean isDone()
    {
        return done;
    }
}