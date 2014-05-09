package com.immortalporpoises.savingsylvester;

import java.awt.Color;

import javax.swing.JFrame;

import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

public class Game {

	//variables that store the current environment, the game display window, and the 
	private Environment currentEnvironment = new YourRoom();
	private GameDisplay display;
	private String answer = "42";
	private List<Environment> environments = new ArrayList<Environment>();
	private List<Thing> Inventory = new ArrayList<Thing>();// the inventory
	
	public Game() {
		
		//initialize environments
		Environment y = new YourRoom();
		Environment g = new GardenIntro();
		environments.add(y);
		environments.add(g);
		
		//create an Image Display with its initial image
    	display = new GameDisplay("src\\com\\immortalporpoises\\savingsylvester\\palace_image.jpg");
		display.setBackground(new Color(0, 0, 0));
		
		display.setOutput("We open at the close. You are in your room, sobbing violently in the fetal position holding a "
				+ "giant pink fluffy teddy bear. You throw the teddy bear across the room, walk intently to your computer, "
				+ "and promptly begin whining to the world through various social medias. Strangely enough, you are suddenly "
				+ "struck by the feeling that someone is watching you. You rise from your desk to look around.");
		
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
		String part1 = "";
		String part2 = "";
		if (parts.length == 2)
		{
		     part1 = parts[0];
		     part2 = parts[1];
		}
		System.out.println(answer);
		
		if(part1.equals("go"))
		{
			if(part2.equals("north"))
			{
				answer = "n";
			}
			if(part2.equals("south"))
			{
				answer = "s";
			}
			if(part2.equals("west"))
			{
				answer = "w";
			}
			
			if(part2.equals("east"))
			{
				answer = "e";
			}
		}
		
		if(part1.equals("look") || part1.equals("examine"))
		{
			if(part2.equals(currentEnvironment.getEnvironName()))
			{
				display.setOutput("You look around the " + currentEnvironment.getEnvironName() + ".");
				display.setOutput(currentEnvironment.getDescription());
			} else
			{
				display.setOutput("You look at the " + part2 + ".");
				display.setOutput(currentEnvironment.getThingDescription(part2));
			}
		}
		
		if(part1.equals("get") || part1.equals("take"))
		{
			int index = currentEnvironment.getThingIndex(part2);
			if(index==-1)
			{
				display.setOutput("You can't get that sort of thing here. Or maybe I'm just misunderstanding you. I tend "
						+ "to think the problem is on your end however: I'm a computer. I don't make mistakes.");
			} else if(currentEnvironment.sthings_in_environ.get(index).isCollectable())
			{
				Inventory.add(currentEnvironment.sthings_in_environ.get(index));
				currentEnvironment.sthings_in_environ.remove(index);
				display.setOutput("The " + part2 + " has been added to your inventory");
			} else
			{
				display.setOutput("You cannot put a " + part2 + " in your inventory. Do try to behave yourself, or I will "
						+ "be forced to exterminate you.");
			}
		}

		if(part1.equals("enter"))
		{
			if(currentEnvironment.getPassageName(part2)==null)
			{
				display.setOutput("You cannot enter the " + part2);
			} else
			{
				String passage_leads = currentEnvironment.getPassagDestination(part2);
				currentEnvironment = environments.get(getEnvironIndex(passage_leads));
				display.setOutput(currentEnvironment.getDescription());
			}
		}
				
		if(part1.equals("view") && part2.equals("inventory"))//print out the inventory has to be a part to
		{
			if(Inventory.isEmpty())
			{
				display.setOutput("you have pocket lint.");//when you have nothing
			}
			else
			{
				for(int index = 0; index < Inventory.size(); index++)
				{
					display.setOutput(Inventory.get(index).getName());
				}
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
	
	public int getEnvironIndex(String environ_name)
	{
		for(int i = 0; i<environments.size(); i++)
		{
			if(environments.get(i).getEnvironName().equals(environ_name))
			{
				return i;
			}
		}
		return -1;
	}

}
