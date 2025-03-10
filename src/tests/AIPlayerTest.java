package tests;

import models.AIPlayer;
import models.Board;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AIPlayerTest {

    @Test
    public void testMakeMove() {
        Board board = new Board();
        AIPlayer aiPlayer = new AIPlayer('O');

        aiPlayer.makeMove(board);

        boolean moveMade = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getBoard()[i][j] == 'O') {
                    moveMade = true;
                    break;
                }
            }
        }

        assertTrue(moveMade);
    }
}
