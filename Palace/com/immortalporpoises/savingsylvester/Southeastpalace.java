package com.immortalporpoises.savingsylvester;

import com.immortalporpoises.savingsylvester.Environment;

public final class Southeastpalace extends Environment
{

	public Southeastpalace()
	{
		//give the garden area a name
		environ_name = "palace";
				
		//entry description
		entry_description = "You are in the southeast part of the palace.";
		main_description = "Your passages are to the west, and stairs.";
		
		//passage to palace
		Passage stairs = new Passage("stairs", "dungeon");		
		entrances_and_exits.add(stairs);
	}
}
