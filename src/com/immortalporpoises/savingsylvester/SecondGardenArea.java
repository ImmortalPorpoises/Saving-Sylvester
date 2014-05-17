package com.immortalporpoises.savingsylvester;

public final class SecondGardenArea extends Environment {

	public SecondGardenArea()
	{		
		//give the garden area a name
		environ_name = "garden";
		
		//initialize items in the garden
		Item bucket = new Item("Bucket", "a small wooden pail that is slowly leaking");
		items_in_environ.add(bucket);
		
		/*//setup passages in garden
		Passage east = new Passage("East","GardenIntro");
		entrances_and_exits.add(east);
		Passage west = new Passage("West","GardenIntro");
		entrances_and_exits.add(west);*/
		
		//setup sthings
		Bucket b = new Bucket();
		sthings_in_environ.add(b);
		
		//entry description
		entry_description = "You are now in the north corner of a large garden. Above you from large oak trees hangs golden fruit. A bucket (half-full) sits on the grass before you.";
	}
	
}
