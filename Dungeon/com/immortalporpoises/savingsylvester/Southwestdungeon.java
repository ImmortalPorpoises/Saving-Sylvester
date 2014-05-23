package com.immortalporpoises.savingsylvester;

public final class Southwestdungeon extends Environment
{

	public Southwestdungeon()
	{
		//give the garden area a name
		environ_name = "dungeon";

		//entry description
		entry_description = "Southwest Dungeon";
		main_description ="The path branches here. You can continue to go south towards the death smell or continue down the hall to the east ";
		
		Passage cell = new Passage("cell", "jailcell");
		
		entrances_and_exits.add(cell);
	}
}
