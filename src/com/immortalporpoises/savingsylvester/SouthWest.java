package com.immortalporpoises.savingsylvester;

public class SouthWest extends Environment
{

	public SouthWest() 
	{
		environ_name = "garden";//name of envioment
		entry_description = "When you enter the south west coner of the garden you notice a rather large" + " knight polishing a" + " sword.";// decription of the environmanet
		main_description = "affa";//look commant
		
		//setup
		Knight k = new Knight();
		sthings_in_environ.add(k);
	}

}
