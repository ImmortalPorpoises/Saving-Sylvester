package com.immortalporpoises.savingsylvester;

public final class GardenIntro extends Environment
{

	public GardenIntro()
	{
		//give the garden area a name
		environ_name = "garden";
		
		//setup passages in garden
		Passage east = new Passage("East", "SecondGardenArea");
		entrances_and_exits.add(east);
		Passage west = new Passage("West", "SecondGardenArea");
		entrances_and_exits.add(west);
		
		//setup things
		Bucket b = new Bucket();
		sthings_in_environ.add(b);
		
		//entry description
		entry_description = "You find yourself in the northwest corner of a large garden. Above you from large oak trees hangs golden fruit";
	}
	
	public String toString()
	{
		return "garden";
	}
}
