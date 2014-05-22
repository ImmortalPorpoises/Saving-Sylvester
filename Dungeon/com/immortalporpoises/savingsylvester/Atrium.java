package com.immortalporpoises.savingsylvester;

public class Atrium extends Environment
{
	public Atrium()
	{
		environ_name = "dungeon";
		
		entry_description = "atrium of the dungeon";
		
		main_description = "TBA";
		
		//passage to palace
		Passage stairs = new Passage("stairs", "palace");		
		entrances_and_exits.add(stairs);
		Passage door = new Passage("door", "palace");		
		entrances_and_exits.add(door);
	}
}
