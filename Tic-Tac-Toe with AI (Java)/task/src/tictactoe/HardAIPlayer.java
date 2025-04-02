package tictactoe;

public class HardAIPlayer implements Player {
    private final char symbol;
    private final char opponent;

    public HardAIPlayer(char symbol) {
        this.symbol = symbol;
        this.opponent = (symbol == 'X') ? 'O' : 'X';
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Making move level \"hard\"");

        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        char[][] grid = board.getBoardCopy();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = symbol;
                    int score = minimax(grid, false);
                    grid[i][j] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }

        board.setMove(bestRow, bestCol, symbol);
    }

    private int minimax(char[][] grid, boolean isMaximizing) {
        if (isWin(grid, symbol)) return 10;
        if (isWin(grid, opponent)) return -10;
        if (isDraw(grid)) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == ' ') {
                        grid[i][j] = symbol;
                        int score = minimax(grid, false);
                        grid[i][j] = ' '; // Reset
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == ' ') {
                        grid[i][j] = opponent;
                        int score = minimax(grid, true);
                        grid[i][j] = ' '; // Reset
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    private boolean isWin(char[][] grid, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }

        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) return true;
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) return true;

        return false;
    }

    private boolean isDraw(char[][] grid) {
        for (char[] row : grid)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }
}

