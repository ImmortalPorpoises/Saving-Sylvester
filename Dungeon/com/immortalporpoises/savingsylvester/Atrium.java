package com.immortalporpoises.savingsylvester;

public class Atrium extends Environment
{
	public Atrium()
	{
		environ_name = "dungeon";
		
		entry_description = "As you leave the Jailers Room a flood of light nearly blinds you as you can once again see the sky, and more importantly, the palace gates";
		
		main_description = "The atrium is the first breathe of fresh air you have had in a while. It is lined with tall elabortely decorated columns. Several people are busily moving about, refusing to talk to you.  Your passages are the stairs and to the south.";
		
		//passage to palace
		Passage stairs = new Passage("stairs", "palace");		
		entrances_and_exits.add(stairs);
		Passage door = new Passage("door", "palace");		
		entrances_and_exits.add(door);
	}
}
