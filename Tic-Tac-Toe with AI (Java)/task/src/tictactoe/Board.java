package tictactoe;

public class Board {
    private final char[][] board = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    public boolean setMove(int row, int col, char symbol) {
        if (isEmpty(row, col)) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol))
                return true;
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean isDraw() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }

    public char[][] getBoardCopy() {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++)
            System.arraycopy(board[i], 0, copy[i], 0, 3);
        return copy;
    }
}
