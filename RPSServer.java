import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class RPSServer {
    private static final int PORT = 12345;
    private static Socket player1;
    private static Socket player2;

    public static void main(String[] args) {
        System.out.println("[SERVER] Starting Rock-Paper-Scissors Server...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[SERVER] Waiting for Player 1 to connect...");
            player1 = serverSocket.accept();
            System.out.println("[SERVER] Player 1 connected.");

            System.out.println("[SERVER] Waiting for Player 2 to connect...");
            player2 = serverSocket.accept();
            System.out.println("[SERVER] Player 2 connected.");

            // Start game handling in a separate thread
            GameHandler game = new GameHandler(player1, player2);
            new Thread(game).start();

        } catch (IOException e) {
            System.err.println("[SERVER ERROR] " + e.getMessage());
        }
    }
}

class GameHandler implements Runnable {
    private Socket p1, p2;
    private BufferedReader in1, in2;
    private PrintWriter out1, out2;

    public GameHandler(Socket p1, Socket p2) throws IOException {
        this.p1 = p1;
        this.p2 = p2;
        in1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        in2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        out1 = new PrintWriter(p1.getOutputStream(), true);
        out2 = new PrintWriter(p2.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                out1.println("Enter your move (rock, paper, scissors): ");
                String move1 = in1.readLine();

                out2.println("Enter your move (rock, paper, scissors): ");
                String move2 = in2.readLine();

                String result = Utils.determineWinner(move1, move2);
                out1.println("Result: " + result);
                out2.println("Result: " + result);

                out1.println("Play again? (yes/no): ");
                out2.println("Play again? (yes/no): ");

                if (!in1.readLine().equalsIgnoreCase("yes") ||
                    !in2.readLine().equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("[GAME ERROR] " + e.getMessage());
        } finally {
            try {
                p1.close();
                p2.close();
            } catch (IOException ignored) {}
            System.out.println("[SERVER] Game ended.");
        }
    }
}

class Utils {
    public static String determineWinner(String move1, String move2) {
        if (move1.equals(move2)) return "It's a draw!";
        if ((move1.equals("rock") && move2.equals("scissors")) ||
            (move1.equals("scissors") && move2.equals("paper")) ||
            (move1.equals("paper") && move2.equals("rock"))) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }
}
