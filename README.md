# 💪📄✂️ Distributed Rock-Paper-Scissors Game (Java Socket Programming)

This is a simple terminal-based **Rock-Paper-Scissors multiplayer game** built using **Java Sockets**. It demonstrates basic distributed systems concepts such as client-server communication, multi-threading, and synchronization.

---

## 📌 Features

- Play Rock-Paper-Scissors over a network
- Two-player real-time gameplay
- Terminal-based UI
- TCP-based client-server communication
- Handles synchronization between clients
- Easy to run and extend

---

## 🧠 System Architecture

```
+------------+      TCP Socket      +-------------+      TCP Socket      +------------+
|  Client 1  |  <=================> |   Server    | <=================>  |  Client 2  |
+------------+                     +-------------+                      +------------+
```

---

## 💠 Tech Stack

- Language: **Java 17+**
- Communication: **Java Sockets (TCP)**
- UI: **Terminal**
- Threading: **Java Multi-threading**

---

## 🚀 How to Run

### 1. Compile the project
```bash
javac *.java
```

### 2. Start the server
```bash
java RPSServer
```

### 3. Start two clients (in separate terminals)
```bash
java RPSClient
```

---

## 🎮 Gameplay Flow

1. Both players are prompted to enter their move (rock, paper, or scissors).
2. Server waits until both moves are received.
3. It then compares the moves and sends the result back to both players.
4. Players can then choose to play again or exit.

---

## 📂 Project Structure

```bash
.
├── RPSClient.java        # Client-side logic
├── RPSServer.java        # Server that handles connections and game logic
├── GameHandler.java      # Threaded class to handle each client
├── Utils.java            # Game logic (winner calculation)
```

---

## 🧪 Sample Output

**Client 1**
```
Connected to server.
Enter your move (rock/paper/scissors): rock
Waiting for other player...
Result: You Win! 🎉
```

**Client 2**
```
Connected to server.
Enter your move (rock/paper/scissors): scissors
Waiting for other player...
Result: You Lose 😞
```

---

## 📚 Concepts Demonstrated

- Client-server architecture
- Java Sockets (TCP)
- Multi-threading and synchronization
- Real-time message passing
- Basic distributed game logic

---

## 🔮 Future Improvements

- GUI using JavaFX or Swing
- More players / tournament mode
- Match history log
- WebSocket version

---

## 👤 Author

**Gajanan Rathod, Kunal Puri, Mann Monpar, Shruti Amrutkar**  
🎓 [DISTRIBUTED SYSTEMES MINI PROJECT - SCOE - IT / 8th Semester]  

---

## 📄 License

MIT License – feel free to modify and distribute.
