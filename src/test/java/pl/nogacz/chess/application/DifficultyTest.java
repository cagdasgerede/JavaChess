package pl.nogacz.chess.application;

import org.junit.Test;
import static org.junit.Assert.*;
import pl.nogacz.chess.application.*;
import pl.nogacz.chess.application.menu.Difficulty;

public class DifficultyTest {
    @Test
    public void testInitialDifficulty()
    {
        //intial difficulty must be normal level.
        Computer c1 = new Computer();
        int difficulty = c1.getSkill();

        assertEquals(difficulty,0);

    }
    @Test
    public void testDifficultyEasy()
    {
        Computer c1 = new Computer();
        c1.setSkill(1);
        int difficulty = c1.getSkill();

        assertEquals(difficulty,1);
    } 
    
    @Test
    public void testDifficultyNormal()
    {
        Computer c1 = new Computer();
        c1.setSkill(0);
        int difficulty = c1.getSkill();

        assertEquals(difficulty,0);
    } 
    @Test
    public void testDifficultyHard()
    {
        Computer c1 = new Computer();
        c1.setSkill(2);
        int difficulty = c1.getSkill();

        assertEquals(difficulty,2);
    } 
    @Test
    public void testDifficultyInsane()
    {
        Computer c1 = new Computer();
        c1.setSkill(3);
        int difficulty = c1.getSkill();

        assertEquals(difficulty,3);
    } 

}
