package io.github.ioni5;

public class RockPaperScissors {

    private static final int MIN_PLAYERS = 1;

    private static final int MAX_PLAYERS = 2;

    private Player[] players;

    public RockPaperScissors(int numPlayers) {
        assert isValidNumPlayers(numPlayers);
        if (numPlayers == MIN_PLAYERS) {
            players = new Player[] {
                new HumanPlayer("Jugador1"),
                new RobotPlayer("Mr. Roboto")
            };
        } else {
            players = new Player[] {
                new HumanPlayer("Jugador1"),
                new HumanPlayer("Jugador2")
            };
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
        return numPlayers == MIN_PLAYERS || numPlayers == MAX_PLAYERS;
    }
}
