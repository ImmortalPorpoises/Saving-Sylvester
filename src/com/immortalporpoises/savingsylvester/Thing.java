package com.immortalporpoises.savingsylvester;

public class Thing {

	protected String name, description;
	protected boolean collectable;
	
	public Thing()
	{
		name = "thing";
		description = "You look closely at this thing. It is vague and undefined. You can only assume that this thing is a superclass of all the game objects.";
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public boolean isCollectable()
	{
		return collectable;
	}

}
