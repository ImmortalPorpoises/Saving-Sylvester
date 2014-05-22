package com.immortalporpoises.savingsylvester;

import com.immortalporpoises.savingsylvester.Environment;

public final class Southeastpalace extends Environment
{

	public Southeastpalace()
	{
		//give the garden area a name
		environ_name = "palace";
				
		//entry description
		entry_description = "TBA";
		
		//passage to palace
		Passage stairs = new Passage("stairs", "dungeon");		
		entrances_and_exits.add(stairs);
	}
}
