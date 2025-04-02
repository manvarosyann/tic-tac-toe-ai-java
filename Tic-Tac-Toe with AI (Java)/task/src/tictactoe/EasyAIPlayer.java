package tictactoe;

import java.util.Random;

public class EasyAIPlayer implements Player {
    private final char symbol;
    private final Random random = new Random();

    public EasyAIPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (board.setMove(row, col, symbol)) break;
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
