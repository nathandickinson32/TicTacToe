package models;

import interfaces.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerOne implements Player {
    private char symbol;

    public PlayerOne(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int column = -1;
        while (true) {
            try {
                System.out.println("Enter row (1-3) and column (1-3): ");

                row = scanner.nextInt() - 1;
                column = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && column >= 0 && column < 3 && board.isMoveValid(row, column)) {
                    break;
                } else {
                    System.out.println("Invalid move! That position is either already taken or outside of the Tic Tac Toe Grid. Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers between 1 and 3.");
                scanner.nextLine();
            }
        }


        board.makeMove(row, column, symbol);
    }
}
