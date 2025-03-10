package controllers;

import interfaces.Player;
import models.AIPlayer;
import models.Board;
import models.PlayerOne;

public class TicTacToeGame {
    private Board board;
    private Player player;
    private Player aiPlayer;


    public TicTacToeGame() {
        board = new Board();
        player = new PlayerOne('X');
        aiPlayer = new AIPlayer('O');
    }

    public void startGame() {

        greeting();
        board.printBoard();

        while (true) {
            playerMove();
            if (isGameOver()) break;

            aiMove();
            if (isGameOver()) break;
        }
    }

    private void greeting() {
        System.out.println("Welcome to Tic Tac Toe! You will play as the 'X'.");
        System.out.println("Select your position by entering desired row and column like this: 1 2");
        System.out.println("This example will place an 'X' on the top row middle column");
        System.out.println("Good Luck! Have Fun!");
    }

    private void playerMove() {
        player.makeMove(board);
        board.printBoard();
    }

    private void aiMove() {
        aiPlayer.makeMove(board);
        board.printBoard();
    }

    private void gameResultsMessage(char symbol) {
        if (symbol == 'X') {
            System.out.println("You Win!");
        } else if (symbol == 'O') {
            System.out.println("AI Wins!");
        } else System.out.println("It's a Tie!");

    }

    private boolean isGameOver() {
        if (board.checkWinner(player.getSymbol())) {
            gameResultsMessage(player.getSymbol());
            return true;
        }
        if (board.checkWinner(aiPlayer.getSymbol())) {
            gameResultsMessage(aiPlayer.getSymbol());
            return true;
        }
        if (board.isBoardFull()) {
            gameResultsMessage('T');
            return true;
        }
        return false;
    }
}
