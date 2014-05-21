package com.immortalporpoises.savingsylvester;

import java.util.List;
import java.util.ArrayList;

//this is the superclass from which all of the areas in the game are created

public abstract class Environment
{
	//***********************************
	//initialize all of the fields necessary for each environment
	//***********************************
	
	//there is the environment's name, an array of things, an array of passages, an entry description, and 
	//a main description of the room the main description is what writes to the screen when the player types "look <area>"
	protected String environ_name;
	protected List<Thing> sthings_in_environ = new ArrayList<Thing>();
	protected List<Passage> entrances_and_exits = new ArrayList<Passage>();
	protected String entry_description;
	protected String main_description = "The area suddenly becomes vague and abstract. You suspect that this area might"
			+ " not have defined a specific description for itself and that it's using the abstract superclass's default"
			+ " description instead.";
	
	public String getEnvironName()
	{
		return environ_name;
	}
	public String getEntryDescription()
	{
		return entry_description;
	}
	
	public String getDescription()
	{
		return main_description;
	}
	
	public String getThingDescription(String thing_name)
	{
		//searches through the array of things to see if there is a thing with the name the user inputted
		for(int i = 0; i<sthings_in_environ.size(); i++)
		{			
			if(thing_name.equals(sthings_in_environ.get(i).getName()))
			{
				return sthings_in_environ.get(i).getDescription();
			}
		}
		return "...wait a minute. There isn't a " + thing_name + " anywhere in this part of the world. Don't panic. Just take a deep breath and rethink this.";
	}
	
	//returns the array index value of an object with the given name. If the object doesn't exist, then it returns -1
	public int getThingIndex(String thing_name)
	{
		for(int i = 0; i<sthings_in_environ.size(); i++)
		{			
			if(thing_name.equals(sthings_in_environ.get(i).getName()))
			{
				return i;
			}
		}
		return -1;
	}
	
	//gets the name of a passage (if it exists)
	public String getPassageName(String passage_name)
	{
		for(int i = 0; i<entrances_and_exits.size(); i++)
		{			
			if(passage_name.equals(entrances_and_exits.get(i).getName()))
			{
				return entrances_and_exits.get(i).getName();
			}
		}
		return null;
	}
	
	//gets a string value of the destination of the passage
	public String getPassagDestination(String passage_name)
	{
		for(int i = 0; i<entrances_and_exits.size(); i++)
		{
			if(passage_name.equals(entrances_and_exits.get(i).getName()))
			{
				return entrances_and_exits.get(i).getDestination();
			}
		}
		return null;
	}
}
