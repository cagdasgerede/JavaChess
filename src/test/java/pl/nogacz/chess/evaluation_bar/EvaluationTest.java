package pl.nogacz.chess.evaluation_bar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.nogacz.chess.application.BoardPoint;
import pl.nogacz.chess.application.menu.EvaluationBar;

@RunWith(PowerMockRunner.class)
public class EvaluationTest {

    @Test
    public void doesCalculateThePointTrueWhenPointIsEqual() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(0);
        EvaluationBar evaluationBar = new EvaluationBar(boardPoint, 750);

        //Then
        Assert.assertEquals(0, evaluationBar.calculateScoreOverSize(), 0);
    }

    @Test
    public void doesCalculateThePointTrueWhenWhiteIsWinning() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(-5);
        EvaluationBar evaluationBar = new EvaluationBar(boardPoint, 750);

        boolean isWhiteWinning = (evaluationBar.calculateScoreOverSize() < 0);

        //Then
        Assert.assertTrue(isWhiteWinning);
    }

    @Test
    public void doesCalculateThePointTrueWhenBlackIsWinning() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(5);
        EvaluationBar evaluationBar = new EvaluationBar(boardPoint, 750);

        boolean isBlackWinning = (0 < evaluationBar.calculateScoreOverSize());

        //Then
        Assert.assertTrue(isBlackWinning);
    }

    @Test
    public void isInLowBoundaryWhenTheScoreExceeds() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(-500);
        EvaluationBar evaluationBar = new EvaluationBar(boardPoint, 750);

        //Then
        Assert.assertEquals(-375, evaluationBar.calculateScoreOverSize(), 0);
    }

    @Test
    public void isInHighBoundaryWhenTheScoreExceeds() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(500);
        EvaluationBar evaluationBar = new EvaluationBar(boardPoint, 750);

        //Then
        Assert.assertEquals(375, evaluationBar.calculateScoreOverSize(), 0);
    }

}

