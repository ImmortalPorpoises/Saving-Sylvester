package com.immortalporpoises.savingsylvester;

import java.awt.Color;

import javax.swing.JFrame;

public static boolean update = false;

public class Game {

	private Environment currentEnvironment = new GardenIntro();
	private GameDisplay display;
	private String text_to_parse = "nada";
	
	public Game() {
		//create an Image Display
    	display = new GameDisplay("src\\com\\immortalporpoises\\savingsylvester\\palace_image.jpg");
		display.setBackground(new Color(0, 0, 0));

    	JFrame frame = new JFrame();
		frame.add(display);
		frame.setSize(1024, 600);
		frame.setVisible(true);
	}
	
	public void parseText(String text_input)
	{
		if(text_input.equals("east"))
		{
			display.setOutput("You are now attempting to go east...");
		}
			//else
//		{
//			display.setOutput("What was that again?");
//		}
	}
	
	public void updateGame()
	{
		text_to_parse = display.getInputText();
		this.parseText(text_to_parse);
	}

}
