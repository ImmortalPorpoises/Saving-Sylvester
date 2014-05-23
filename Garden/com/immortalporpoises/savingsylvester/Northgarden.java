package com.immortalporpoises.savingsylvester;

public final class Northgarden extends Environment {

	public Northgarden()
	{		
		//give the garden area a name
		environ_name = "garden";
		
		//setup sthings
		Bucket b = new Bucket();
		sthings_in_environ.add(b);
		
		//entry description
		entry_description = "You find yourself in the north part of the garden. A bucket (half-full) sits on the grass before you.";
		main_description = "A half - full bucket seems pretty useless. Your passages are to your west, east, and south.";
	}
	
}
