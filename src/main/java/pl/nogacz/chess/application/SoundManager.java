package pl.nogacz.chess.application;

public class SoundManager {
    private static SoundEffect CLICK_SOUND = null;
    private static SoundEffect VICTORY_SOUND = null;
    private static SoundEffect DEFEAT_SOUND = null;
    private static SoundEffect PIECE_SOUND = null;
    private static SoundEffect MOVE_SOUND = null;
    private static SoundEffect MENU_MUSIC = null;
    private static SoundEffect BACKGROUND_MUSIC = null;

    static {
        try {
            CLICK_SOUND = new SoundEffect("./src/main/resources/Audio/click.wav"); //SoundEffect object for Click sound
            VICTORY_SOUND = new SoundEffect("./src/main/resources/Audio/victory.wav"); //SoundEffect object for Victory
            DEFEAT_SOUND = new SoundEffect("./src/main/resources/Audio/defeat.wav"); //SoundEffect object for Defeat
            PIECE_SOUND = new SoundEffect("./src/main/resources/Audio/piece.wav"); //SoundEffect object for Win/Lose the piece
            MOVE_SOUND = new SoundEffect("./src/main/resources/Audio/move.wav"); //SoundEffect object for movement
            MENU_MUSIC = new SoundEffect("./src/main/resources/Audio/menu.wav"); //SoundEffect object for Menu Music
            BACKGROUND_MUSIC = new SoundEffect("./src/main/resources/Audio/background.wav"); //SoundEffect object for Background Music
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    
    public static void stopBackgroundMusic(){
        BACKGROUND_MUSIC.stop();
    }
}
