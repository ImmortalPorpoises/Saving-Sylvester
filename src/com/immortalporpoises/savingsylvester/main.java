package com.immortalporpoises.savingsylvester;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class main{

public static void main (String[] args){    
  JFrame mainmenu = new JFrame();
  mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  mainmenu.setSize(1024, 600);
  mainmenu.setVisible(true);

  JPanel panel = new JPanel();
  mainmenu.add(panel);
  
  JButton button = new JButton(" New Game ");
  panel.add(button);
  button.addActionListener (new Action1());

  JButton button2 = new JButton(" Quit ");
  panel.add(button2);
  button2.addActionListener (new Action2()); 
}
static class Action1 implements ActionListener {        
  public void actionPerformed (ActionEvent e) { 
	  Thread t = new Thread(new Audio());
	  t.start();
	  Game newgame = new Game();
  }
}   
static class Action2 implements ActionListener {        
  public void actionPerformed (ActionEvent e) {     
    System.exit(0);
  }
}   
}

