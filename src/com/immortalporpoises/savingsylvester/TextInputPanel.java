package com.immortalporpoises.savingsylvester;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TextInputPanel extends JPanel {

	public TextInputPanel()
	{
		JTextArea user_input = new JTextArea();
		this.add(user_input);
	}

}
