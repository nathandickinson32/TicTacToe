package models;

public class Board {
    private static final char EMPTY = ' ';
    private char[][] board = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    public void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char column : row) {
                System.out.print(column + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char column : row) {
                if (column == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMoveValid(int row, int column) {
        return (row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == EMPTY);
    }

    public void makeMove(int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    public char[][] getBoard() {
        return board;
    }
}
