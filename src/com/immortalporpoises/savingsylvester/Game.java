package com.immortalporpoises.savingsylvester;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

public class Game{
	//variables that store the current environment, the game display window, and the 
	private JFrame frame;
	private JPanel panel;
	private Environment currentEnvironment = new YourRoom();
	private GameDisplay display = new GameDisplay("Pictures/your_home.jpg");
	private String answer = "42";
	private List<Environment> environments = new ArrayList<Environment>();
	private Environment[][] garden = new Environment[3][3];//the garden area array
	private Environment[][] your_room = new Environment[1][1]; //the starting room array
	private Environment[][] dungeon = new Environment[3][3];//the dungeon area array
	private Environment[][] jailcell = new Environment[1][1]; //the jail cell array
	private List<Thing> Inventory = new ArrayList<Thing>();// the inventory
	private int x_index = 0;
	private int y_index = 0;

	public Game()
	{
		//create the JFrame and add the display to it
	    frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 600);
		frame.setVisible(true);
		frame.add(display);
		//initialize environments
		Environment room = new YourRoom();
		Environment nwg = new Northwestgarden();
		Environment nwd = new Northwestdungeon();
		Environment jc = new jailcell();
		Environment ng = new Northgarden();
		Environment wg = new WestGarden();
		Environment swg = new Southwestgarden();
		Environment cg = new Centergarden();
		Environment neg = new Northeastgarden();
		Environment eg = new Eastgarden();
		Environment seg = new Southeastgarden();
		Environment sg = new Southgarden();
		Environment wd = new Westdungeon();
		Environment swd = new Southwestdungeon();
		
		environments.add(jc);
		environments.add(room);
		environments.add(nwg);
		environments.add(nwd);
		
		//add garden areas to the garden array to enable n/s/e/w navigation
<<<<<<< HEAD
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				garden[i][j] = nwg;
				dungeon[i][j] = nwd;
			}
		}
		// garden area [col][row]
		garden[1][0] = ng;
		garden[0][1] = wg; 
		garden[0][2] = swg;
		garden[1][1] = cg;
		garden[2][0] = neg;
		garden[2][1] = eg;
		garden[2][2] = seg;
		garden[1][2] = sg;
		// dungeon area [col][row]
		dungeon[0][1] = wd;
		dungeon[0][2] = swd;
=======
		garden[0][0] = g;
		dungeon[0][0] = dun;
		
		//[col][row]
		garden[1][0] = z;
		garden[0][1] = h; //hey Nathan, this is where we add the environments to the garden
		garden[0][2] = q;
		garden[1][1] = c;
		garden[2][0] = w;
		garden[2][1] = t;
		garden[2][2] = d;
		garden[1][2] = s;
>>>>>>> 8a1adb1b184a43e70e1041a3fb28fb0e1c63e980
		
		
		display.setOutput("Saving Sylvester, Copyright 2014 Immortal Porpoises \n\nNote: please limit commands to 2 words, "
				+ "i.e. \"look room,\" \"examine bear,\" \"take bear,\" \"enter door,\" etc. \nTo view your inventory, simply "
				+ "type \"view inventory.\" To get help, type \"help me.\" Case and punctuation do not matter."
				+ "\n\n\"\"and so Sylvester breathed his last. \n The End.\" \n\n    We open at the close."
				+ "\n    You snap the book shut\"it\"s the latest work by your favorite fantasy author, P.F. Tollers\"and"
				+ " wipe a tear away. \"Why did Sylvester have to die?\" you wonder out loud. \"He was the best "
				+ "character in the series.\" This thought overcomes you, and you break down in pitiful sobs."
				+ "\n    Time passes, and a few hours later, you are in your room, sobbing violently in the fetal position"
				+ " and holding a giant pink fluffy teddy bear. You throw the teddy bear across the room, walk "
				+ "intently to your computer and promptly begin whining to the world through various social "
				+ "media. Strangely enough, you are suddenly struck by the feeling that someone is watching you. "
				+ "You rise from your desk to look around.");
		
		//continue to update the game until the user exits the window
		for(;;)
		{
			updateGame();
		}
	}
	
	public void parseText(String answer)
	{
		answer = answer.toLowerCase();
		answer = answer.trim();
		if(answer.endsWith("."))
		{
			answer = answer.replace(".", "");
		}
		
		String[] parts = answer.split(" ");
		String part1 = "";
		String part2 = "";
		if (parts.length == 2)
		{
		     part1 = parts[0];
		     part2 = parts[1];
		}
		System.out.println(answer);
		
		if(part1.equals("help") && part2.equals("me"))
		{
			display.setOutput("You want assistance? Do this without resistance: don't panic, take a deep breath, and"
					+ " remember this isn't a matter of life and death."
					+ "\n    If you're unsatisfied with this level of aid, please contact my programmer without"
					+ " delay. Oh, and have a nice day!");
		}
		if(part1.equals("kill") && part2.equals("myself"))
		{
			System.exit(0);
		}
		if(part1.equals("go"))
		{
			Environment[][] move_array = new Environment[3][3];
			
			if(currentEnvironment.getEnvironName().equals("garden"))
			{
				move_array = garden;
			}
			if(currentEnvironment.getEnvironName().equals("room"))
			{
				move_array = your_room;
			}
			if(currentEnvironment.getEnvironName().equals("dungeon"))
			{
				move_array = dungeon;
			}
			if(currentEnvironment.getEnvironName().equals("jailcell"))
			{
				move_array = jailcell;
			}
			if(part2.equals("north"))
			{
				if(y_index > 0)
				{
					y_index = y_index - 1;
					currentEnvironment = move_array[x_index][y_index];
					display.setOutput(currentEnvironment.getEntryDescription());
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
			if(part2.equals("south"))
			{
				if(y_index < 3)
				{
					y_index = y_index + 1;
					currentEnvironment = move_array[x_index][y_index];
					display.setOutput(currentEnvironment.getEntryDescription());
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
			if(part2.equals("west"))
			{
				if(x_index > 0)
				{
					x_index = x_index - 1;
					currentEnvironment = move_array[x_index][y_index];
					display.setOutput(currentEnvironment.getEntryDescription());
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
			
			if(part2.equals("east"))
			{
				if(x_index < 3)
				{
					x_index = x_index + 1;
					currentEnvironment = move_array[x_index][y_index];
					display.setOutput(currentEnvironment.getEntryDescription());
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
		}
		
		if(part1.equals("look") || part1.equals("examine"))
		{
			if(part2.equals(currentEnvironment.getEnvironName()))
			{
				display.setOutput("You look around the " + currentEnvironment.getEnvironName() + ".");
				display.setOutput(currentEnvironment.getDescription());
			} else
			{
				display.setOutput("You look at the " + part2 + ".");
				display.setOutput(currentEnvironment.getThingDescription(part2));
			}
		}
		
		if(part1.equals("get") || part1.equals("take"))
		{
			int index = currentEnvironment.getThingIndex(part2);
			if(index==-1)
			{
				display.setOutput("You can't get that sort of thing here. Or maybe I'm just misunderstanding you. I tend "
						+ "to think the problem is on your end however: I'm a computer. I don't make mistakes.");
			} else if(currentEnvironment.sthings_in_environ.get(index).isCollectable())
			{
				Inventory.add(currentEnvironment.sthings_in_environ.get(index));
				currentEnvironment.sthings_in_environ.remove(index);
				display.setOutput("The " + part2 + " has been added to your inventory.");
			} else
			{
				display.setOutput("You cannot put a " + part2 + " in your inventory. Do try to behave yourself, or I will "
						+ "be forced to exterminate you.");
			}
		}

		if(part1.equals("enter"))
		{
			Environment[][] move_array = new Environment[3][3];
			
			if(currentEnvironment.getPassageName(part2)==null)
			{
				display.setOutput("You cannot enter the " + part2 + ".");
			}
			else if(currentEnvironment.getEnvironName().equals("dungeon"))
			{
				move_array = garden;
				display.setOutput("You enter the " + part2 + ".");
				currentEnvironment = move_array[2][2];
				display.setOutput(currentEnvironment.getEntryDescription());
			}
			else if(currentEnvironment.getEnvironName().equals("jailcell"))
			{
				move_array = dungeon;
				display.setOutput("You exit the " + part2 + ".");
				currentEnvironment = move_array[0][2];
				display.setOutput(currentEnvironment.getEntryDescription());
			}
			else
			{
<<<<<<< HEAD
				x_index = 0;
				y_index = 0;
=======
				display.setImage("Pictures/palace_image.jpg");
>>>>>>> 8a1adb1b184a43e70e1041a3fb28fb0e1c63e980
				display.setOutput("You enter the " + part2 + ".");
				String passage_leads = currentEnvironment.getPassagDestination(part2);
				currentEnvironment = environments.get(getEnvironIndex(passage_leads));
				display.setOutput(currentEnvironment.getEntryDescription());
			}
		}				
		if(part1.equals("view") && part2.equals("inventory"))//print out the inventory has to be a part to
		{
			if(Inventory.isEmpty())
			{
				display.setOutput("you have pocket lint.");//when you have nothing
			}
			else
			{
				answer = "You have a ";
				if(Inventory.size()==2)
				{
					answer = answer + Inventory.get(0).getName() + " and a " + Inventory.get(1).getName() + " in your inventory.";
				} else
				{
					for(int index = 0; index < Inventory.size(); index++)
					{
						if(index==Inventory.size()-2)
						{
							answer = answer + Inventory.get(index).getName() + ", and a ";
						} else if(index==Inventory.size()-1)
						{
							answer = answer + Inventory.get(index).getName() + " in your inventory.";
						} else
						{
							answer = answer + Inventory.get(index).getName() + ", a ";
						}
					}
				}
				display.setOutput(answer);
			}
		}
		
		if(part1.equals("punch") || part1.equals("kick") || part1.contains("hit") && part2.equals("bear"))
		{
			display.setOutput("the bear snaps to life and begins to beat the ever-loving mess out of you.");
		}
		
		display.setUpdateValue(false);
	}
	
	public void updateGame()
	{
		if(display.getUpdateValue())
		{
			answer = display.getInputText();
			this.parseText(answer);
		}
	}
	
	public int getEnvironIndex(String environ_name)
	{
		for(int i = 0; i<environments.size(); i++)
		{
			if(environments.get(i).getEnvironName().equals(environ_name))
			{
				return i;
			}
		}
		return -1;
	}

}
