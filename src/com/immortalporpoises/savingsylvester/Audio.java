package com.immortalporpoises.savingsylvester;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio extends Thread
{
    public void run()
    {
    	try
    	{

    	AudioInputStream audioIn1 = AudioSystem.getAudioInputStream(new File("Audio/C.wav"));
    	Clip clip1 = AudioSystem.getClip();
    	clip1.open(audioIn1);
    	clip1.start();
    	AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(new File("Audio/CSDungeonsongysong.wav"));
    	Clip clip2 = AudioSystem.getClip();
    	clip2.open(audioIn2);
    	clip2.start();
    	

	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Audio/CSDungeonsongysong.wav"));
	    	Clip clip = AudioSystem.getClip();
	    	clip.open(audioIn);
	    	clip.start();

    	}
    	catch(Exception ex)
    	{
    		System.out.println("Error with playing sound.");
            ex.printStackTrace();
    	}
    	}

    public static void main(String args[])
    {
    		 (new Audio()).start();
    }
}