package com.immortalporpoises.savingsylvester;

import com.immortalporpoises.savingsylvester.Environment;

public final class Southtower extends Environment {

	public Southtower()
	{		
		//give the garden area a name
		environ_name = "tower";
		
		//entry description
		entry_description = "You are in the south part of the tower.";
		main_description = "Your passages are to the north, and a door.";
		
		//passage to palace
		Passage door = new Passage("door", "palace");		
		entrances_and_exits.add(door);
	}
	
}
