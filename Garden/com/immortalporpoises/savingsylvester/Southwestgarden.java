package com.immortalporpoises.savingsylvester;

public class Southwestgarden extends Environment
{

	public Southwestgarden() 
	{
		{
			environ_name = "garden";//name of environment
			entry_description = "When you enter the south west corner of the garden you notice a rather large" + " knight sharpening a" + " sword.";// decription of the environmanet
			main_description = "This part of the garden is full of practice dummys for inspiring knights";//look command
			
			//setup
			Knight k = new Knight();
			sthings_in_environ.add(k);
			Sword s = new Sword();
			sthings_in_environ.add(s);
		}
	}

}
