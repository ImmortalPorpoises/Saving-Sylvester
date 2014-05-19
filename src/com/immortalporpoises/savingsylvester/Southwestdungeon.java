package com.immortalporpoises.savingsylvester;

public final class Southwestdungeon extends Environment
{

	public Southwestdungeon()
	{
		//give the garden area a name
		environ_name = "dungeon";

		//entry description
		entry_description = "TBA";
		
		Passage cell = new Passage("cell", "jailcell");
		
		entrances_and_exits.add(cell);
	}
}
