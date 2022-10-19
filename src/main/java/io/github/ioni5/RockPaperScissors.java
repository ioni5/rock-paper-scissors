package io.github.ioni5;

public class RockPaperScissors 
{
    private Player[] players;

    public RockPaperScissors() {
        players = new Player[] {
            new Player("Jugador1"),
            new Player("Jugador2")
        };
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
}
