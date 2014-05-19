package com.immortalporpoises.savingsylvester;

public final class Southeastgarden extends Environment
{

	public Southeastgarden()
	{
		//give the garden area a name
		environ_name = "garden";
				
		//entry description
		entry_description = "You walk into the southeast area of the garden. The trees provide shade, and a light "
				+ " breeze is chilly on your skin.";
		main_description = "You look closely at the grass and see a small hole, just big enough for a person to enter.";
		
		Passage hole = new Passage("hole", "dungeon");		
		entrances_and_exits.add(hole);
	}
}
