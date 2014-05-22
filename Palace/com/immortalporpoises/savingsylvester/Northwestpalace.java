package com.immortalporpoises.savingsylvester;

import com.immortalporpoises.savingsylvester.Environment;

public final class Northwestpalace extends Environment
{

	public Northwestpalace()
	{
		//give the garden area a name
		environ_name = "palace";
				
		//entry description
		entry_description = "You find yourself in the Northwest corner of the palace. A giant door blocks your way.";
		
		//passage to palace
		Passage door = new Passage("door","tower");		
		entrances_and_exits.add(door);
	}
}
