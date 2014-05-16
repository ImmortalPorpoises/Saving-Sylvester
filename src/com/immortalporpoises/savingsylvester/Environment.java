package com.immortalporpoises.savingsylvester;

import java.util.List;
import java.util.ArrayList;

public abstract class Environment {

	protected List<Item> items_in_environ = new ArrayList<Item>();
	protected List<Thing> sthings_in_environ = new ArrayList<Thing>();
	protected List<Passage> entrances_and_exits = new ArrayList<Passage>();
	protected String entry_description;
	protected String main_description = "The area suddenly becomes vague and abstract. You suspect that this area might"
			+ " not have defined a specific description for itself and that it's using the abstract superclass's default"
			+ " description instead.";
	protected String environ_name;
	
	public Environment()
	{
		// TODO Auto-generated constructor stub
	}
	
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
