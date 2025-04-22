// RPSServer.java, GameHandler, and Utils classes already added above.
// Let's now write the RPSClient.java class that connects to the server and handles player input.

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class RPSClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("[CLIENT] Connected to the Rock-Paper-Scissors Server!");

            while (true) {
                // Display prompt from server and take move input
                System.out.println(in.readLine()); // "Enter your move..."
                String move = scanner.nextLine();
                out.println(move);

                // Wait for result
                System.out.println("[CLIENT] Waiting for result...");
                System.out.println(in.readLine()); // result

                // Ask if player wants to play again
                System.out.println(in.readLine()); // "Play again?"
                String answer = scanner.nextLine();
                out.println(answer);

                if (!answer.equalsIgnoreCase("yes")) {
                    System.out.println("[CLIENT] Exiting game. Goodbye!");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("[CLIENT ERROR] " + e.getMessage());
        }
    }
}