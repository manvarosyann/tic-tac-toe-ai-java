package tictactoe;

public interface Player {
    void makeMove(Board board);

    char getSymbol();
}
