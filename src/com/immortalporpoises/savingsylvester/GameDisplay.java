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
	private JLabel text_output;
	
	//create input variable
	private String outcome = "Just some random text";
	
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
		final JTextArea user_input = new JTextArea("Enter something here");
		user_input.setBounds(0, 301, 512, 300);
		this.add(user_input);
		user_input.setFont(new Font("Garamond", Font.PLAIN, 15));
		
		//setup output area
		JTextArea text_output = new JTextArea();
		text_output.setEditable(false);
		text_output.setLineWrap(true);
		text_output.setBounds(513, 0, 500, 600);
		text_output.setMargin(new Insets(10, 10, 10, 10));
		this.add(text_output);
		text_output.setForeground(Color.white);
		text_output.setBackground(Color.black);
		text_output.setFont(new Font("Garamond", Font.PLAIN, 15));
		
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
	                        String outcome = user_input.getText();
	                        	                        
	                        user_input.setText("");
	                        user_input.setSelectionStart(user_input.getText().length());
	                        System.out.println(outcome);
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
		text_output.setText(output);
	}
	
	public String getInputText()
	{
		return outcome;
	}

}
