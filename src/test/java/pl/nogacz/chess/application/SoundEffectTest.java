package pl.nogacz.chess.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SoundEffectTest{
    
    @Test 
    public void throwsException_UnsupportedAudioFile() {
        boolean isException=false;
        try{
            SoundEffect soundEffect = new SoundEffect("./src/main/resources/Audio/unsupported.mp3");
        }
        catch (Exception e){
            isException = true;
        }
        Assert.assertTrue(isException);
    }

    @Test 
    public void throwsException_IOException() {
        boolean isException=false;
        try{
            SoundEffect soundEffect = new SoundEffect("./src/main/wrongFile/dgjm$5gs#2£/unsupported.mp3");
        }
        catch (Exception e){
            isException = true;
        }
        Assert.assertTrue(isException);
    }

    @Test
    public void testPlay() {
        try {
            SoundEffect soundEffect = null;
            soundEffect = spy(new SoundEffect("./src/main/resources/Audio/move.wav"));
            doNothing().when(soundEffect).play(false);
            soundEffect.play(false);
            verify(soundEffect, times(1)).play(false);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void testLoop() {
        try {
            SoundEffect soundEffect = spy(new SoundEffect("./src/main/resources/Audio/move.wav"));
            doNothing().when(soundEffect).play(true);
            soundEffect.play(true);
            verify(soundEffect, times(1)).play(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStop() {
        try {
            SoundEffect soundEffect = spy(new SoundEffect("./src/main/resources/Audio/move.wav"));
            soundEffect.stop();
            verify(soundEffect, times(1)).stop();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}