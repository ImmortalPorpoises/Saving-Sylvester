package com.immortalporpoises.savingsylvester;

import java.awt.List;
import java.util.ArrayList;

public abstract class Environment {

	protected ArrayList<Item> items_in_environ = new ArrayList<Item>();
	protected ArrayList<Thing> sthings_in_environ = new ArrayList<Thing>();
	protected ArrayList<Passage> entrances_and_exits = new ArrayList<Passage>();
	protected String entry_description;
	
	public Environment()
	{
		// TODO Auto-generated constructor stub
	}

}
