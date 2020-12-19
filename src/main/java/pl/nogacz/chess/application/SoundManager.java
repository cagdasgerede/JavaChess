package pl.nogacz.chess.application;

public class SoundManager {
    private final static SoundEffect CLICK_SOUND = new SoundEffect("./src/main/resources/Audio/click.wav");
    private final static SoundEffect VICTORY_SOUND= new SoundEffect("./src/main/resources/Audio/victory.wav"); //SoundEffect object for Victory
    private final static SoundEffect DEFEAT_SOUND= new SoundEffect("./src/main/resources/Audio/defeat.wav"); //SoundEffect object for Defeat
    private final static SoundEffect PIECE_SOUND= new SoundEffect("./src/main/resources/Audio/piece.wav"); //SoundEffect object for Win/Lose the piece
    private final static SoundEffect MOVE_SOUND= new SoundEffect("./src/main/resources/Audio/move.wav"); //SoundEffect object for movement
    private final static SoundEffect MENU_MUSIC= new SoundEffect("./src/main/resources/Audio/menu.wav"); //SoundEffect object for Menu Music
    private final static SoundEffect BACKGROUND_MUSIC= new SoundEffect("./src/main/resources/Audio/background.wav"); //SoundEffect object for Background Music
    
    public static void playClickSound(){
        CLICK_SOUND.play(false);
    }

    public static void playVictorySound(){
        BACKGROUND_MUSIC.stop();
        VICTORY_SOUND.play(false);
    }

    public static void playDefeatSound(){
        BACKGROUND_MUSIC.stop();
        DEFEAT_SOUND.play(false);
    }

    public static void playPieceSound(){
        PIECE_SOUND.play(false);
    }

    public static void playMoveSound(){
        MOVE_SOUND.play(false);
    }

    public static void playMenuMusic(){
        MENU_MUSIC.play(true);
    }

    public static void playBackgroundMusic(){
        MENU_MUSIC.stop();
        BACKGROUND_MUSIC.play(true);
    }

  /*  public static void stopMenuMusic(){
        MENU_MUSIC.stop();
    }*/

    public static void stopBackgroundMusic(){
        BACKGROUND_MUSIC.stop();
    }
}
