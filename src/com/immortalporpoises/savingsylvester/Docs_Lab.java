package com.immortalporpoises.savingsylvester;

public class Docs_Lab extends Environment {

	public Docs_Lab() {
		//give the environment a name
		environ_name = "lab";
		
		//the description
		entry_description = "You find yourself in what looks like a rundown apartment building. Not what you had in mind when you followed the mysterious woman.";
		main_description = "Apparently the so called 'doctor' is just some whacko who thinks he is a scientist. You might as well stay and see what he has to say.";
		
		DrRayCain dr = new DrRayCain();
		
		sthings_in_environ.add(dr);
		
		//add entrances and exits
		Passage portal = new Passage("portal", "garden");
		
		entrances_and_exits.add(portal);
	}

}
