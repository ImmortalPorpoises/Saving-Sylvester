package com.immortalporpoises.savingsylvester;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameDisplay extends JPanel {

	private JPanel imagepanel;
	private JTextArea text_output;
	private JScrollPane scroll;
	private boolean update;
	
	//create input variable
	private String outcome = "";
	
	/*
	* Create an ImageViewer show it on screen.
	*/
	public GameDisplay(String file_directory)
	{
		this.setLayout(null);
		
		//setup image
		Icon icon = new ImageIcon(openImage(file_directory));
		JLabel image_label = new JLabel(icon);
		image_label.setBounds(0, 0, 512, 300);
		this.add(image_label);
		
		//setup user input area
		final JTextArea user_input = new JTextArea("");
		user_input.setBounds(0, 301, 512, 300);
		this.add(user_input);
		user_input.setForeground(Color.white);
		user_input.setBackground(Color.black);
		user_input.setFont(new Font("Garamond", Font.PLAIN, 17));
		
		//setup output area
		text_output = new JTextArea("");
		text_output.setEditable(false);
		text_output.setLineWrap(true);
		text_output.setWrapStyleWord(true); //Added to fix text wrapping issue
		//text_output.setBounds(513, 0, 500, 600);
		text_output.setMargin(new Insets(10, 10, 10, 10));
		this.add(text_output);
		text_output.setForeground(Color.white);
		text_output.setBackground(Color.black);
		text_output.setFont(new Font("Garamond", Font.PLAIN, 17));
		
		//create scroll area
		scroll = new JScrollPane(text_output);
		scroll.setBounds(513, 0, 500, 562);
		scroll.setAutoscrolls(true);
		this.add(scroll);
		
		//check for enter keypress
		user_input.addKeyListener(
	            new KeyListener() {

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
					}

					@Override
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyChar() == KeyEvent.VK_ENTER)
						{
	                        outcome = user_input.getText();                 
	                        user_input.setText("");
	                        update = true;
	                    }
					}
	            }
	        );
	}
	
	public Image openImage(String file_directory)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File(file_directory));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Image file could not be loaded");
		}
		return img.getScaledInstance(512, 300, Image.SCALE_SMOOTH);
	}
	
	public void setOutput(String output)
	{
		text_output.setText(text_output.getText().trim() + "\n    " + output);
	}
	
	public String getInputText()
	{
		return outcome;
	}
	
	public boolean getUpdateValue()
	{
		return update;
	}
	
	public void setUpdateValue(boolean upval)
	{
		update = upval;
	}

}
