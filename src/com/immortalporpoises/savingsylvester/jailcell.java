package com.immortalporpoises.savingsylvester;

public final class jailcell extends Environment
{

	public jailcell()
	{
		//give the garden area a name
		environ_name = "jailcell";

		//entry description
		entry_description = "this is the jailcell with the bones of Jake and Scott";
		
		Passage dungeon = new Passage("dungeon", "dungeon");
		entrances_and_exits.add(dungeon);
	}
}
