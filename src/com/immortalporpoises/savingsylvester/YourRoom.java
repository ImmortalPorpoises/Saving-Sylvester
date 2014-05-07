package com.immortalporpoises.savingsylvester;

public class YourRoom extends Environment {

	public YourRoom() {
		//give the environment a name
		environ_name = "room";
		
		//the description
		entry_description = "Your room is very small and dimly lit - it is late at night, after all. One one side of the room is a bunkbed you share with your roommmate. On the opposite end is your desk, stacked with papers and with a computer on top of it. The mysterious woman stands in the middle of the room, tapping her foot.";
		
		//create things in room
		Bed b = new Bed();
		Desk d = new Desk();
		Woman w = new Woman();
		
		//add them to the array of things in the room
		sthings_in_environ.add(b);
		sthings_in_environ.add(d);
		sthings_in_environ.add(w);
	}

}
