package tests;

import models.Board;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void checkWinnerTest() {
        Board board = new Board();

        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWinner('X'));

        board = new Board();
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 0, 'O');
        board.makeMove(2, 0, 'O');
        assertTrue(board.checkWinner('O'));

        board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 2, 'X');
        assertTrue(board.checkWinner('X'));
    }

    @Test
    public void checkForTieTest() {
        Board board = new Board();

        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'X');
        board.makeMove(2, 1, 'X');
        board.makeMove(2, 2, 'O');

        assertTrue(board.isBoardFull());

    }

    @Test
    public void isMoveValidTest(){
        Board board = new Board();

        assertTrue(board.isMoveValid(0, 0));
        assertTrue(board.isMoveValid(2, 2));

        board.makeMove(0, 0, 'X');
        assertFalse(board.isMoveValid(0, 0));
    }


}
