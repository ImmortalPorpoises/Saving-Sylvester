package com.immortalporpoises.savingsylvester;

public class WestGarden extends Environment {
	
	public WestGarden()
	{
		environ_name = "garden";
		entry_description = "Upon arriving in this area of the garden, you are immediately overcome with the stench"
				+ " of rotting potatoes.";
		main_description = "The gardener has apparently been hard at work in this area of the garden. A pile of "
				+ "rotten potatoes lies in a mound beside a garden bed. A shovel and wheelbarrow rest next to the"
				+ " pile.";
		
		//setup things
		RottenPotatoes b = new RottenPotatoes();
		Key k = new Key();
		sthings_in_environ.add(b);
		sthings_in_environ.add(k);
	}
}
