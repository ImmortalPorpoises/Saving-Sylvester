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
<<<<<<< HEAD

    	AudioInputStream audioIn1 = AudioSystem.getAudioInputStream(new File("Audio/C.wav"));
=======
    	AudioInputStream audioIn1 = AudioSystem.getAudioInputStream(new File("Audio/CSGameIntro.wav"));
>>>>>>> 3c85285c23b8e022774c454f697831634e2e556f
    	Clip clip1 = AudioSystem.getClip();
    	clip1.open(audioIn1);
    	clip1.start();
    	
<<<<<<< HEAD

	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Audio/CSDungeonsongysong.wav"));
	    	Clip clip = AudioSystem.getClip();
	    	clip.open(audioIn);
	    	clip.start();

=======
    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Audio/CSDungeonsongysong.wav"));
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioIn);
    	clip.start();
>>>>>>> 3c85285c23b8e022774c454f697831634e2e556f
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