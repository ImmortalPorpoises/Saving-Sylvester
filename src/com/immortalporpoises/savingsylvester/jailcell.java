package com.immortalporpoises.savingsylvester;

public final class jailcell extends Environment
{

	public jailcell()
	{
		//give the garden area a name
		environ_name = "jailcell";

		//entry description
		entry_description = "TBA";
		
		Passage dungeon = new Passage("dungeon", "dungeon");
		entrances_and_exits.add(dungeon);
	}
}
