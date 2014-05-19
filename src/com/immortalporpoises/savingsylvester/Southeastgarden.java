package com.immortalporpoises.savingsylvester;

public final class Southeastgarden extends Environment
{

	public Southeastgarden()
	{
		//give the garden area a name
		environ_name = "garden";
				
		//entry description
		entry_description = "TBA";
		
		Passage hole = new Passage("hole", "dungeon");
		
		entrances_and_exits.add(hole);
	}
}
