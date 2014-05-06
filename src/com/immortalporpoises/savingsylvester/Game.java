package com.immortalporpoises.savingsylvester;

import java.awt.Color;

import javax.swing.JFrame;
import java.lang.Class;

public class Game {

	//variables that store the current environment, the game display window, and the 
	private Environment currentEnvironment = new GardenIntro();
	private GameDisplay display;
	private String answer = "42";
	
	public Game() {
		
		//create an Image Display with its initial image
    	display = new GameDisplay("src\\com\\immortalporpoises\\savingsylvester\\palace_image.jpg");
		display.setBackground(new Color(0, 0, 0));
		display.setOutput("We open at the close. You are in a room, sobbing violently in the fetal position holding a giant pink fluffy teddy bear. You throw the teddy bear across the room, walk intently to a computer, and promptly begin whining to the world through various social medias. After a brief time, you are contacted by Candice, who says she wants his help. You agree. She takes you to their headquarters and introduces you to the rest of the team. 'We don’t like the way the book ended, so Doc made a machine that runs at 88mph and creates story world.' You go into the world.");

		//create the JFrame and add the display to it
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(display);
		frame.setSize(1024, 600);
		frame.setVisible(true);
		
		//continue to update the game until the user exits the window
		for(;;)
		{
			updateGame();
		}
	}
	
	public void parseText(String answer)
	{
		answer = answer.toLowerCase();
		answer = answer.trim();
		
		String[] parts = answer.split(" ");
		String part1 = "test";
		String part2 = "test 2";
		if (parts.length == 2)
		{
		     part1 = parts[0];
		     part2 = parts[1];
		}
		
		System.out.println(part1);
		System.out.println(part2);
		
		if(part2.equals("west"))
		{
			if(currentEnvironment.entrances_and_exits.get(0).getDestination().equals("SecondGardenArea"))
			{
				currentEnvironment = new SecondGardenArea();
				display.setOutput(currentEnvironment.getDescription());
			}
			else if(currentEnvironment.entrances_and_exits.get(0).getDestination().equals("GardenIntro"))
			{
				currentEnvironment = new GardenIntro();
				display.setOutput(currentEnvironment.getDescription());
			} else
			{
				display.setOutput("Pull yourself together and try writing something coherent next time");
			}
		}
		
		if(part2.equals("east"))
		{
			if(currentEnvironment.entrances_and_exits.get(0).getDestination().equals("SecondGardenArea"))
			{
				Passage newpassage = currentEnvironment.entrances_and_exits.get(0);
				currentEnvironment = new SecondGardenArea();
				display.setOutput(currentEnvironment.getDescription());
			}
			if(currentEnvironment.entrances_and_exits.get(0).getDestination().equals("GardenIntro"))
			{
				currentEnvironment = new GardenIntro();
				display.setOutput(currentEnvironment.getDescription());
			} else
			{
				display.setOutput("Pull yourself together and try writing something coherent next time");
			}
		}
		
		if(part1.equals("look"))
		{
			if(part2.equals(currentEnvironment.toString()))
			{
				display.setOutput(currentEnvironment.entry_description);
			} else if(part2.equals("bucket"))
			{
				currentEnvironment.sthings_in_environ.get(0);
			}
		}
		
		display.setUpdateValue(false);
	}
	
	public void updateGame()
	{
		if(display.getUpdateValue())
		{
			answer = display.getInputText();
			this.parseText(answer);
		}
	}

}
