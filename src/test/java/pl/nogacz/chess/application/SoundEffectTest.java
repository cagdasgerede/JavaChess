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
    public void notThrowsException() {
        boolean isException=false;
        try{
            SoundEffect soundEffect = new SoundEffect("./src/main/resources/Audio/move.wav");
        }
        catch (Exception e){
            isException = true;
        }
        Assert.assertFalse(isException);
    }

    @Test
    public void testPlay() {
        SoundEffect soundEffect = null;
        try {
            soundEffect = spy(new SoundEffect("./src/main/resources/Audio/move.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        doNothing().when(soundEffect).play(false);
        soundEffect.play(false);
        verify(soundEffect, times(1)).play(false);
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


  /*  @Test (expected = Exception.class)
    public void playWithNullPath() throws Exception {
        soundLoader = mock(SoundLoader.class);
        soundLoader.playTheSound(f);
        assertTrue(throwException());
    }

    @Test
    public void playIntroWithPath() throws Exception {
        soundLoader = new SoundLoader("IntroSoundLoader",clip);
        f = new File("/home/irem/pacman_workshop/src/main/resources/com/thoughtworks/pacman/ui/pacman_beginning.wav");  
    
        assertTrue(soundLoader.playTheSound(f));
    }

    @Test
    public void playBackgroundWithPath() throws Exception {
        soundLoader = new SoundLoader("BackgroundSoundLoader",clip);

        assertTrue(soundLoader.playTheSound(mock(File.class)));
    }

    @Test
    public void testStop() {
        soundLoader = mock(SoundLoader.class);
        soundLoader.setStop();
        verify(soundLoader).setStop();
    }

    private boolean throwException() throws Exception{
        throw new Exception();
    }
  */
}