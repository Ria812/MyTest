/**
 * Created by RiaG on 7/25/2016.
 */
public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;

    }

    public Board nextGeneration() {
        Board nextBoard = board.nextGeneration();
        board = nextBoard;

        return board;
    }
}
