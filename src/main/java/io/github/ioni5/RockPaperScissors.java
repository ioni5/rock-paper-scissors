package io.github.ioni5;

public class RockPaperScissors {

    private static final int MAX_PLAYERS = 2;

    private Player[] players = new Player[MAX_PLAYERS];

    public RockPaperScissors(int numPlayers) {
        assert isValidNumPlayers(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new HumanPlayer(i + 1);
        }
        for (int i = numPlayers; i < MAX_PLAYERS; i++) {
            players[i] = new RobotPlayer(i - numPlayers + 1);
        }
    }

    public void start() {
        Console console = new Console();
        console.write("\nPiedra, Papel o Tijera");
        do {
            for (Player player : players) {
                player.play();
            }
            if (!this.hasWinner()) {
                console.write("\n¡Estan empatados!");
            }
        } while (!this.hasWinner());
        console.write("\n¡" + this.getWinner().getName() + " gana!\n");
    }

    private Player getWinner() {
        assert this.hasWinner();
        return players[0].winTo(players[1]) ? players[0] : players[1];
    }

    private boolean hasWinner() {
        return !players[0].isSameShape(players[1]);
    }

    public static boolean isValidNumPlayers(int numPlayers) {
        return numPlayers >= 0 && numPlayers <= MAX_PLAYERS;
    }
}
