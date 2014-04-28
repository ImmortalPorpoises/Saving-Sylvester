package com.immortalporpoises.savingsylvester;

import java.util.List;
import java.util.ArrayList;

public abstract class Environment {

	protected List<Item> items_in_environ = new ArrayList<Item>();
	protected List<Thing> sthings_in_environ = new ArrayList<Thing>();
	protected List<Passage> entrances_and_exits = new ArrayList<Passage>();
	protected String entry_description;
	
	public Environment()
	{
		// TODO Auto-generated constructor stub
	}

}
