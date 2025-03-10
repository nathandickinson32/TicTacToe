package models;

import interfaces.Player;

public class AIPlayer implements Player {

    private char symbol;

    public AIPlayer(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }


    private int minimax(Board board, boolean isAITurn, int depth) {
        if (board.checkWinner('X')) return -10 + depth;
        if (board.checkWinner('O')) return 10 - depth;
        if (board.isBoardFull()) return 0;

        int bestValue = isAITurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isMoveValid(i, j)) {
                    board.makeMove(i, j, isAITurn ? 'O' : 'X');
                    int currentValue = minimax(board, !isAITurn, depth + 1);
                    board.makeMove(i, j, ' ');

                    if (isAITurn) {
                        bestValue = Math.max(bestValue, currentValue);
                    } else {
                        bestValue = Math.min(bestValue, currentValue);
                    }
                }
            }
        }
        return bestValue;
    }

    public void makeMove(Board board) {
        int bestRow = -1;
        int bestColumn = -1;
        int bestValue = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isMoveValid(i, j)) {
                    board.makeMove(i, j, 'O');
                    int currentValue = minimax(board, false, 0);
                    board.makeMove(i, j, ' ');
                    if (currentValue > bestValue) {
                        bestValue = currentValue;
                        bestRow = i;
                        bestColumn = j;
                    }
                }
            }
        }
        if (bestRow != -1 && bestColumn != -1) {
            board.makeMove(bestRow, bestColumn, 'O');
            System.out.println("AI move: " + (bestRow + 1) + " " + (bestColumn + 1));
        }
    }


}
