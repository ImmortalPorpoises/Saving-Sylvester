package com.immortalporpoises.savingsylvester;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio extends Thread {

    public void run() {
    	try
    	{
    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("SavingSylvesterGame/Audio/CSGameIntro.wav"));
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

    public static void main(String args[]) {
        (new Audio()).start();
    }
    //hi
}