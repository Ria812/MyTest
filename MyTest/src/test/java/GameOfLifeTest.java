import javafx.scene.control.Cell;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ria G on 24-07-2016.
 */
public class GameOfLifeTest {
    @Test
    public void aLiveCellWithNoNeighboursShouldDieInNextGeneration() throws Exception{
        //given
        Board board = new Board();
        board.addCell(new CellUnit(0,0));
        Game game = new Game(board);
        //when
        Board nextBoard = game.nextGeneration();
        //then
        assertFalse(nextBoard.isAlive(new CellUnit(0,0)));
    }
    @Test
    public void cellWithTwoNeighborsShouldLiveInNextIteration() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new CellUnit(0, 1));
        board.addCell(new CellUnit(1, 1));
        board.addCell(new CellUnit(1, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextGeneration();

        // then
        assertTrue(nextBoard.isAlive(new CellUnit(1, 1)));
    }





}
