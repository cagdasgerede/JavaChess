package pl.nogacz.chess.application;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

	//https://gist.github.com/figengungor/5673813 Helped from this link.
public class SoundEffect {	
	private Clip clip;
	public SoundEffect(String soundFileName) {
		try {
	    	File file = new File(soundFileName);
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	        clip = AudioSystem.getClip();
	    	clip.open(audioInputStream);
	    } catch (UnsupportedAudioFileException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}
 
	public void play(Boolean loop) { // Play or Re-play the sound effect from the beginning, by rewinding.
		if (clip.isRunning())
	    	clip.stop();   // Stop the player if it is still running
	        clip.setFramePosition(0); // Rewind to the beginning
	        clip.start();     // Start playing
	        if(loop)//Loop if loop parameter is true
		    	clip.loop(Clip.LOOP_CONTINUOUSLY);
	   }
	   	   
	public void stop() //Stop playing and rewind to be played again from the beginning
	{
		clip.stop();
		clip.setFramePosition(0);
	}	  
}
