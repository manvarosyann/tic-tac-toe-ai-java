package tictactoe;

import java.util.Random;

public class MediumAIPlayer implements Player {
    private final char symbol;

    public MediumAIPlayer(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public void makeMove(Board board) {
        char[][] boardCopy = board.getBoardCopy();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardCopy[i][j] == ' ') {
                    boardCopy[i][j] = symbol;
                    if (new BoardHelper(boardCopy).isWin(symbol)) {
                        board.setMove(i, j, symbol);
                        System.out.println("Making move level \"medium\"");
                        return;
                    }
                    boardCopy[i][j] = ' ';
                }
            }
        }

        char opponent = (symbol == 'X') ? 'O' : 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardCopy[i][j] == ' ') {
                    boardCopy[i][j] = opponent;
                    if (new BoardHelper(boardCopy).isWin(opponent)) {
                        board.setMove(i, j, symbol);
                        System.out.println("Making move level \"medium\"");
                        return;
                    }
                    boardCopy[i][j] = ' ';
                }
            }
        }
        new EasyAIPlayer(symbol).makeMove(board);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
