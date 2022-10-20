package io.github.ioni5;

import java.util.Random;

public class RobotPlayer extends Player {

    public RobotPlayer(int number) {
        super("Maquina" + number);
    }

    @Override
    public void play() {
        Console console = new Console();
        console.write("\nJuega " + name + ": ");
        int shapeIndex = new Random().nextInt(Player.SHAPES.length);
        shape = Player.SHAPES[shapeIndex];
        console.write(shape);
    }

}
