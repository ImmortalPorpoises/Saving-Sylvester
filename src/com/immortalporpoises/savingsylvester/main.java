package com.immortalporpoises.savingsylvester;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class main {
 
    public static void main(String[] args)
    {
    	//this creates a new game object
    	Thread t = new Thread(new Audio());
        t.start();
        Game newgame = new Game();	
    }
}