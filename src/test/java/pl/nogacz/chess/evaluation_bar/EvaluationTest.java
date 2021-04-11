package pl.nogacz.chess.evaluation_bar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.nogacz.chess.application.BoardPoint;
import pl.nogacz.chess.application.menu.EvaluationBar;

@RunWith(PowerMockRunner.class)
public class EvaluationTest {
    EvaluationBar evaluationBar = new EvaluationBar(750);

    @PrepareForTest({BoardPoint.class})
    @Test
    public void doesCalculateThePointTrueWhenPointIsEqual() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(0);

        //Then
        Assert.assertEquals(0, evaluationBar.calculateScoreOverSize(), 0);
    }

    @PrepareForTest({BoardPoint.class})
    @Test
    public void doesCalculateThePointTrueWhenWhiteIsWinning() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(-5);

        boolean isWhiteWinning = (evaluationBar.calculateScoreOverSize() < 0);

        //Then
        Assert.assertTrue(isWhiteWinning);
    }

    @PrepareForTest({BoardPoint.class})
    @Test
    public void doesCalculateThePointTrueWhenBlackIsWinning() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(5);

        boolean isBlackWinning = (0 < evaluationBar.calculateScoreOverSize());

        //Then
        Assert.assertTrue(isBlackWinning);
    }

    @PrepareForTest({BoardPoint.class})
    @Test
    public void isInLowBoundaryWhenTheScoreExceeds() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(-500);

        //Then
        Assert.assertEquals(-375, evaluationBar.calculateScoreOverSize(), 0);
    }

    @PrepareForTest({BoardPoint.class})
    @Test
    public void isInHighBoundaryWhenTheScoreExceeds() {
        //Given
        BoardPoint boardPoint = PowerMockito.mock(BoardPoint.class);

        //When
        PowerMockito.when(boardPoint.calculateBoard()).thenReturn(500);

        //Then
        Assert.assertEquals(375, evaluationBar.calculateScoreOverSize(), 0);
    }

}

