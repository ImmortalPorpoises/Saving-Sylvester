package com.immortalporpoises.savingsylvester;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class main
{
	public static void main (String[] args)
	{
		Thread music = new Audio();
		music.start();
		Game game = new Game();
	}
}