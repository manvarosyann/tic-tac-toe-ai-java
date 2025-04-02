package tictactoe;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;

    public Game(Player playerX, Player playerO) {
        this.board = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void playGame() {
        board.printBoard();
        Player current = playerX;

        while (true) {
            current.makeMove(board);
            board.printBoard();

            if (board.isWin(current.getSymbol())) {
                System.out.println(current.getSymbol() + " wins");
                break;
            } else if (board.isDraw()) {
                System.out.println("Draw");
                break;
            }
            current = (current == playerX) ? playerO : playerX;
        }
    }
}
