package interfaces;

import models.Board;

public interface Player {

    char getSymbol();

    void makeMove(Board board);
}
