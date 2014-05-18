package com.immortalporpoises.savingsylvester;

public final class Northwestdungeon extends Environment
{

	public Northwestdungeon()
	{
		//give the garden area a name
		environ_name = "dungeon";
		
		
		
		//entry description
		entry_description = "You find yourself in the northwest corner of the castle's dungeon. Its dark a gloomy, but you see a small light down the corridor.";
	
		Passage hole = new Passage("hole", "garden");
		entrances_and_exits.add(hole);
	}
}
