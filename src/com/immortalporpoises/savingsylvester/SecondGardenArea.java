package com.immortalporpoises.savingsylvester;

public final class SecondGardenArea extends Environment {

	public SecondGardenArea() {
		//initialize items in the garden
				Item bucket = new Item("Bucket", "a small wooden pail that is slowly leaking");
				items_in_environ.add(bucket);
				
				//setup passages in garden
				Passage east = new Passage("East","GardenIntro");
				entrances_and_exits.add(east);
				Passage west = new Passage("West","GardenIntro");
				entrances_and_exits.add(west);
				
				//setup sthings
				Thing flowerbed = new Thing("Flowerbed", "a spacious, colorful flowerbed filled with dozens of bright blue and red flowers");
				sthings_in_environ.add(flowerbed);
				
				//entry description
				entry_description = "You find yourself in the north corner of a large garden. Above you from large oak trees hangs golden fruit";
	}
	
	public String toString()
	{
		return "garden";
	}
}
