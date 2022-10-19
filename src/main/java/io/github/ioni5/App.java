package io.github.ioni5;

public class App {
    
    public static void main(String[] args) {
        Console console = new Console();
        if (args.length != 1) {
            console.write("\nUso: Main<número de jugadores>\n");
            return;
        }
        int numPlayers = Integer.parseInt(args[0]);
        if (!RockPaperScissors.isValidNumPlayers(numPlayers)) {
            console.write("\nError: número de jugadores inválido.\n");
            return;
        }
        new RockPaperScissors(numPlayers).start();
    }
}
