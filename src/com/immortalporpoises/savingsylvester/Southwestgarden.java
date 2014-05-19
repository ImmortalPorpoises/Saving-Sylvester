package com.immortalporpoises.savingsylvester;

public class Southwestgarden extends Environment
{

	public Southwestgarden() 
	{
		{
			environ_name = "garden";//name of envioment
			entry_description = "When you enter the south west coner of the garden you notice a rather large" + " knight polishing a" + " sword.";// decription of the environmanet
			main_description = "affa";//look command
			
			//setup
			Knight k = new Knight();
			sthings_in_environ.add(k);
			Sword s = new Sword();
			sthings_in_environ.add(s);
		}
	}

}
