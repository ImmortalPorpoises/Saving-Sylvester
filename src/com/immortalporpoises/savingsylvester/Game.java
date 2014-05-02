package com.immortalporpoises.savingsylvester;

import java.awt.Color;

import javax.swing.JFrame;
import java.lang.Class;

public class Game {

	private Environment currentEnvironment = new GardenIntro();
	private GameDisplay display;
	private String text_to_parse = "nada";
	
	public Game() {
		//create an Image Display
    	display = new GameDisplay("src\\com\\immortalporpoises\\savingsylvester\\palace_image.jpg");
		display.setBackground(new Color(0, 0, 0));
		display.setOutput("We open at the close. You are in a room, sobbing violently in the fetal position holding a giant pink fluffy teddy bear. You throw the teddy bear across the room, walk intently to a computer, and promptly begin whining to the world through various social medias. After a brief time, you are contacted by Candice, who says she wants his help. You agree. She takes you to their headquarters and introduces you to the rest of the team. 'We don’t like the way the book ended, so Doc made a machine that runs at 88mph and creates story world.' You go into the world.");

    	JFrame frame = new JFrame();
		frame.add(display);
		frame.setSize(1024, 600);
		frame.setVisible(true);
		
		for(;;)
		{
			updateGame();
		}
	}
	
	public void parseText(String text_input)
	{
		String[] parts = text_input.split(" ");
		String part2 = "test";
		String part1 = "test 2";
		if (parts.length == 2)
		{
		     System.out.println("Stop being dumb!!");
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
		
		
//		if(text_input.equals("exit"))
//		{
//			int b;
//			System.exit(b);
//		}
		display.setUpdateValue(false);
	}
	
	public void updateGame()
	{
		if(display.getUpdateValue())
		{
			text_to_parse = display.getInputText();
			this.parseText(text_to_parse);
		}
	}

}
