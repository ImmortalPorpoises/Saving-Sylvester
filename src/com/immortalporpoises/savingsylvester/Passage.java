package com.immortalporpoises.savingsylvester;

public class Passage {

	private String passage_name;
	private String destination;
	
	public Passage(String passage_name, String destination)
	{
		this.passage_name = passage_name;
		this.destination = destination;
	}
	
	public String getName()
	{
		return passage_name;
	}
	
	public String getDestination()
	{
		return destination;
	}

}
