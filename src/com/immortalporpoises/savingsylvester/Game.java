package com.immortalporpoises.savingsylvester;

import java.awt.Color;

import javax.swing.JFrame;

public class Game {

	private Environment currentEnvironment = new GardenIntro();
	private GameDisplay display;
	private String text_to_parse = "nada";
	
	public Game() {
		//create an Image Display
    	GameDisplay display = new GameDisplay("src\\com\\immortalporpoises\\savingsylvester\\palace_image.jpg");
		display.setBackground(new Color(0, 0, 0));
		
    	JFrame frame = new JFrame();
		frame.add(display);
		frame.setSize(1024, 600);
		frame.setVisible(true);
	}
	
	public void parseText(String text_input)
	{
		display.setOutput("What have we got here?");
	}
	
	public void updateGame()
	{
		text_to_parse = display.getInputText();
		this.parseText(text_to_parse);
	}

}
