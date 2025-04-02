package tictactoe;

import java.util.Scanner;

public class UserPlayer implements Player {
    private final char symbol;
    private final Scanner scanner;

    public UserPlayer(char symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Board board) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt()) {
                int row = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int col = scanner.nextInt();
                    if (row >= 1 && row <= 3 && col >= 1 && col <= 3) {
                        if (board.setMove(row - 1, col - 1, symbol)) {
                            break;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
