package tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.print("Input command: ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split(" ");

            if (parts[0].equals("exit")) break;

            if (parts[0].equals("start") && parts.length == 3) {
                String playerX = parts[1];
                String playerO = parts[2];

                if (isValidPlayer(playerX) && isValidPlayer(playerO)) {
                    Game game = new Game(createPlayer(playerX, 'X'), createPlayer(playerO, 'O'));
                    game.playGame();
                    return;
                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    public boolean isValidPlayer(String player) {
        return player.equals("user") || player.equals("easy") || player.equals("medium") || player.equals("hard");
    }

    private Player createPlayer(String type, char symbol) {
        return switch (type) {
            case "user" -> new UserPlayer(symbol, scanner);
            case "easy" -> new EasyAIPlayer(symbol);
            case "medium" -> new MediumAIPlayer(symbol);
            case "hard" -> new HardAIPlayer(symbol);
            default -> throw new IllegalArgumentException("Unknown player type: " + type);
        };
    }
}

