package com.immortalporpoises.savingsylvester;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

public class Game{
	
	//variables that store the current environment, the game display window, and lots else
	private JFrame frame;
	private JPanel panel;
	private Environment currentEnvironment = new YourRoom();
	private GameDisplay display = new GameDisplay("Pictures/your_home.jpg");
	private String answer = "42";
	private List<Environment> environments = new ArrayList<Environment>();
	private Environment[][] garden = new Environment[3][3];//the garden area array
	private Environment[][] your_room = new Environment[1][1]; //the starting room array
	private Environment[][] Docs_Lab = new Environment[1][1]; //the laboratory array
	private Environment[][] dungeon = new Environment[5][5];//the dungeon area array
	private Environment[][] palace = new Environment[4][3];//the palace area array
	private Environment[][] tower = new Environment[1][3];//the dungeon area array
	private List<Thing> Inventory = new ArrayList<Thing>();// the inventory
	private int x_index = 0;
	private int y_index = 0;
	private int opengate = 0;
	private int correct = 0;
	
		

	public Game()
	{
		//create the JFrame and add the display to it
	    frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 600);
		frame.setVisible(true);
		frame.add(display);
		
		//initialize room
		Environment room = new YourRoom();
		
		//initialize lab
		Environment lab = new Docs_Lab();
		
		//initialize garden environments
		Environment nwg = new Northwestgarden();
		Environment ng = new Northgarden();
		Environment wg = new WestGarden();
		Environment swg = new Southwestgarden();
		Environment cg = new Centergarden();
		Environment neg = new Northeastgarden();
		Environment eg = new Eastgarden();
		Environment seg = new Southeastgarden();
		Environment sg = new Southgarden();
		
		//initialize dungeon environments
		Environment nw_dungeon = new Northwestdungeon();
		Environment w_dungeon = new Westdungeon();
		Environment sw_dungeon = new Southwestdungeon();
		Environment cell_dungeon = new jailcell();
		Environment s_dungeon = new SouthDungeon();
		Environment se_dungeon = new SoutheastDungeon();
		Environment e_dungeon = new EastDungeon();
		Environment ne_dungeon = new NortheastDungeon();
		Environment atrium = new Atrium();
		Environment jailer_room = new JailerRoom();
		
		//initialize palace environments
		Environment lc_palace = new Leftcenterpalace();
		Environment ln_palace = new Leftnorthpalace();
		Environment ls_palace = new Leftsouthpalace();
		Environment ne_palace = new Northeastpalace();
		Environment nw_palace = new Northwestpalace();
		Environment rn_palace = new Rightnorthpalace();
		Environment rs_palace = new Rightsouthpalace();
		Environment se_palace = new Southeastpalace();
		Environment sw_palace = new Southwestpalace();
		
		//initialize tower environments
		Environment n_tower = new Northtower();
		Environment c_tower = new Centertower();
		Environment s_tower = new Southtower();
		
		//area that acts as "filler" for areas the player can't go in the array
		Environment empty = new Empty();
		
		//environments that can be travelled to via passages are added here
		environments.add(room);
		environments.add(nwg);
		environments.add(nw_dungeon);
		environments.add(sw_palace);
		environments.add(s_tower);
		environments.add(lab);
		
		// garden area [col][row]
		garden[1][0] = ng;
		garden[0][1] = wg; 
		garden[0][2] = swg;
		garden[1][1] = cg;
		garden[2][0] = neg;
		garden[2][1] = eg;
		garden[2][2] = seg;
		garden[1][2] = sg;
		
		//fill dungeon with empty environments first
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				dungeon[i][j] = empty;
			}
		}
		
		// dungeon area [col][row]
		dungeon[0][1] = nw_dungeon;
		dungeon[0][2] = w_dungeon;
		dungeon[0][3] = sw_dungeon;
		dungeon[0][4] = cell_dungeon;
		dungeon[1][3] = s_dungeon;
		dungeon[2][3] = se_dungeon;
		dungeon[2][2] = e_dungeon;
		dungeon[2][1] = ne_dungeon;
		dungeon[3][0] = atrium;
		dungeon[3][1] = jailer_room;
		
		//fill palace with empty environments first
				for(int i = 0; i < 4; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						palace[i][j] = empty;
					}
				}
				
				// palace area [col][row]
				palace[0][0] = nw_palace;
				palace[1][0] = ln_palace; 
				palace[2][0] = rn_palace;
				palace[3][0] = ne_palace;
				palace[1][1] = lc_palace;
				palace[0][2] = sw_palace;
				palace[1][2] = ls_palace;
				palace[2][2] = rs_palace;
				palace[3][2] = se_palace;
				
				//fill palace with empty environments first
				for(int i = 0; i < 1; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						tower[i][j] = empty;
					}
				}
				
				// tower area [col][row]
				tower[0][0] = n_tower;
				tower[0][1] = c_tower; 
				tower[0][2] = s_tower;
				
		//the initial text when you start the game
		display.setOutput("Saving Sylvester, Copyright 2014 Immortal Porpoises \n\nNote: please limit commands to 2 words, "
				+ "i.e. \"look room,\" \"examine bear,\" \"take bear,\" \"enter door,\" etc. \nTo view your inventory, simply "
				+ "type \"view inventory.\" To get help, type \"help me.\" Case and punctuation do not matter."
				+ "\n\n\"and so Sylvester breathed his last. \n The End.\" \n\n    We open at the close."
				+ "\n    You snap the book shut - the latest work by your favorite fantasy author, P.F. Tollers and"
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
		//convert the input to lowercase and remove extra spaces
		answer = answer.toLowerCase();
		answer = answer.trim();
		if(answer.endsWith("."))
		{
			answer = answer.replace(".", "");
		}
		
		//split the string into two parts at the space
		String[] parts = answer.split(" ");
		String part1 = "";
		String part2 = "";
		if (parts.length == 2)
		{
		     part1 = parts[0];
		     part2 = parts[1];
		}
		
		if(part1.equals("help") && part2.equals("me"))
		{
			display.setOutput("You want assistance? Here are some things you could try entering: 'go'(in any cardinal direction),"
					+ " 'enter, or climb', 'get or take', and 'examine or look'(any interactable object/character).");
		}
		if(part1.equals("kill") && part2.equals("myself"))
		{
			System.exit(0);
		}
		
		//*********************************
		// NAVIGATION (n/s/e/w) handled here
		//*********************************
		
		if(part1.equals("go"))
		{		
			Environment[][] move_array = new Environment[1][1];
			
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
			if(currentEnvironment.getEnvironName().equals("palace"))
			{
				move_array = palace;
			}
			if(currentEnvironment.getEnvironName().equals("tower"))
			{
				move_array = tower;
			}
			
			if(part2.equals("north"))
			{
				if(y_index > 0)
				{
					if(!move_array[x_index][y_index-1].getEnvironName().equals("empty"))
					{
						currentEnvironment = move_array[x_index][y_index-1];
						display.setOutput(currentEnvironment.getEntryDescription());
						y_index -= 1;
					} else
					{
						display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
					}
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
			if(part2.equals("south"))
			{
				if(y_index < move_array[x_index].length-1)
				{
					if(!move_array[x_index][y_index+1].getEnvironName().equals("empty"))
					{
						currentEnvironment = move_array[x_index][y_index+1];
						display.setOutput(currentEnvironment.getEntryDescription());
						y_index += 1;
					} else
					{
						display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
					}						
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
			if(part2.equals("west"))
			{
				if(x_index > 0)
				{
					if(!move_array[x_index-1][y_index].getEnvironName().equals("empty"))
					{
						currentEnvironment = move_array[x_index-1][y_index];
						display.setOutput(currentEnvironment.getEntryDescription());
						x_index -= 1;
					} else
					{
						display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
					}
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
			
			if(part2.equals("east"))
			{
				if(x_index < move_array.length-1)
				{
					if(!move_array[x_index+1][y_index].getEnvironName().equals("empty"))
					{
						currentEnvironment = move_array[x_index+1][y_index];
						display.setOutput(currentEnvironment.getEntryDescription());
						x_index += 1;
					} else
					{
						display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
					}
				} else
				{
					display.setOutput("You attempt to go that way but discover that a wall is blocking your way.");
				}
			}
		}
		
		//******************************
		// OBSERVING handled here
		//******************************
		
		if(part1.equals("look") || part1.equals("examine"))
		{
			if(part2.equals(currentEnvironment.getEnvironName()) || part2.equals("around"))
			{
				display.setOutput("You look around the " + currentEnvironment.getEnvironName() + ".");
				display.setOutput(currentEnvironment.getDescription());
			} else
			{
				display.setOutput("You look at the " + part2 + ".");
				display.setOutput(currentEnvironment.getThingDescription(part2));
			}
		}
		
		//*******************************
		//INVENTORY ADDING handled here
		//*******************************
		
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
		//handle opening gate in garden with key here
				if(part1.equals("unlock") && part2.equals("gate"))
				{
					Environment[][] move_array = new Environment[3][3];
					if(currentEnvironment.getEnvironName().equals("garden") && Inventory.get(0).getName().equals("key"))
					{
						if(garden[x_index][y_index] == garden[2][2])
						{
						display.setOutput("You open the gate to the dungeon of the castle.");
						opengate = 1;
						}
					} 
					else
					{
						display.setOutput("Sorry, but you're going to need a key to open this gate.");
					}
				}
		
		
		//********************************
		// MOVEMENT VIA PASSAGES handled here
		// (moves the player between arrays)
		//********************************
		
		if(part1.equals("enter") || part1.equals("follow"))
		{
			Environment[][] move_array = new Environment[3][3];
			
			if(currentEnvironment.getPassageName(part2)==null)
			{
				display.setOutput("You cannot enter the " + part2 + ".");
			}
			if(part2.equals("hole"))
				{
				if(currentEnvironment.getEnvironName().equals("garden") && garden[x_index][y_index] == garden[2][2])
				{
					if(opengate == 1)
					{
						
						String passage_leads = currentEnvironment.getPassagDestination(part2);
						currentEnvironment = environments.get(getEnvironIndex(passage_leads));
						if(currentEnvironment.getEnvironName().equals("dungeon"))
						{
							display.setOutput("You enter the " + part2 + ".");
							display.setOutput(currentEnvironment.getEntryDescription());
							display.setImage("Pictures/dungeon_image.jpg");
							x_index = 0;
							y_index = 1;
						}
					}
					else
					{
						display.setOutput("Sorry, but you're going to need a key to open this gate.");
					}
				}else if(currentEnvironment.getEnvironName().equals("garden"))
				{
					
					display.setOutput("You enter the " + part2 + ".");
					display.setOutput(currentEnvironment.getEntryDescription());
					display.setImage("Pictures/garden_image.jpg");
					x_index = 2;
					y_index = 2;
				}
				}
			else if(part2.equals("woman"))
			{
				String passage_leads = currentEnvironment.getPassagDestination(part2);
				currentEnvironment = environments.get(getEnvironIndex(passage_leads));
				if(currentEnvironment.getEnvironName().equals("lab"))
				{
					
					display.setOutput("You follow the " + part2 + ".");
					display.setOutput(currentEnvironment.getEntryDescription());
					x_index = 0;
					y_index = 0;
				}
			}
				else
				{
				String passage_leads = currentEnvironment.getPassagDestination(part2);
				currentEnvironment = environments.get(getEnvironIndex(passage_leads));
				if(currentEnvironment.getEnvironName().equals("garden"))
				{
					
					display.setOutput("You enter the " + part2 + ".");
					display.setOutput(currentEnvironment.getEntryDescription());
					display.setImage("Pictures/garden_image.jpg");
					x_index = 0;
					y_index = 0;
				}
				if(currentEnvironment.getEnvironName().equals("palace"))
				{
					display.setOutput("You enter the " + part2 + ".");
					display.setOutput(currentEnvironment.getEntryDescription());
					display.setImage("Pictures/palace_image.jpg");
					x_index = 3;
					y_index = 2;
				}
				if(currentEnvironment.getEnvironName().equals("tower"))
				{
					display.setOutput("You enter the " + part2 + ".");
					display.setOutput(currentEnvironment.getEntryDescription());
					display.setImage("Pictures/tower_image.jpg");
					x_index = 0;
					y_index = 2;
				}
			}
		}	
	
		
		if(part1.equals("climb"))
		{
			if(currentEnvironment.getPassageName(part2)==null)
			{
				display.setOutput("You cannot climb the " + part2 + ".");
			}
			else
			{
				x_index = 0;
				y_index = 0;
				
				display.setOutput("You climb the " + part2 + ".");
				String passage_leads = currentEnvironment.getPassagDestination(part2);
				currentEnvironment = environments.get(getEnvironIndex(passage_leads));
				display.setOutput(currentEnvironment.getEntryDescription());
				
				if(currentEnvironment.getEnvironName().equals("palace"))
				{
					display.setImage("Pictures/palace_image.jpg");
					x_index = 3;
					y_index = 2;
				}
				if(currentEnvironment.getEnvironName().equals("dungeon"))
				{
					display.setImage("Pictures/dungeon_image.jpg");
					x_index = 3;
					y_index = 0;
				}
			}
		}
		
		//************************
		// VIEW INVENTORY handled here
		//************************
		
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
		
		//************************
		// Riddle
		//************************
		if (part1.equals("answer"))
		{
			if(part2.equals("river"))
			{
				correct = 1;
			}
			else if(!part2.equals("river"))
			{
				correct = 2;
			}
		}
		if(currentEnvironment.getEnvironName().equals("tower") && tower[x_index][y_index] == tower[0][0])
		{
			if(correct == 1)
			{
				display.setOutput("P.F. Tollers bursts into a fiery blaze quickly turns into a pile of ash.");
				display.setOutput("Conratulations!!! You have beaten the game. Sorry to say this but it is actually impossible to change fate. So the prince is still dead.... The End!");
				display.setOutput("Please type in 'kill myself' to end the game now.");
			}
			else if(correct == 2)
			{
				display.setOutput("Sorry your answer was inccorect. Your punishment is to kill yourself.");
				display.setOutput("Please type in 'kill myself' to end the game now.");
			}
		}
		
		
		//***********************
		// PUNCHING THE BEAR handled here
		// (because this feature is obviously so important)
		//***********************
		
		if(part1.equals("punch") || part1.equals("kick") || part1.contains("hit") && part2.equals("bear"))
		{
			display.setOutput("the bear snaps to life and begins to beat the ever-loving mess out of you.");
			display.setOutput("It seems like the bear decided to spare your life.");
		}
				
		display.setUpdateValue(false);
	}
	
	//when the update value is true, this method causes the game to grab text input and process it
	public void updateGame()
	{
		if(display.getUpdateValue())
		{
			answer = display.getInputText();
			this.parseText(answer);
		}
	}

	//gets the array index value of the environment in the environment ArrayList
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
