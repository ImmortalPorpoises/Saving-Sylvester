package com.immortalporpoises.savingsylvester;

public class Item {

	private String item_name, item_description;
	
	public Item(String item_name, String item_description) {
		this.item_name = item_name;
		this.item_description = item_description;
	}
	
	public String getName()
	{
		return item_name;
	}
	
	public String getDescription()
	{
		return item_description;
	}

}
