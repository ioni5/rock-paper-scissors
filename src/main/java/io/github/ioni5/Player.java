package io.github.ioni5;

public class Player {

    private static final String SHAPES[] = {"PIEDRA", "PAPEL", "TIJERA"};

    private String name;

    private String shape;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void play() {
        shape = this.obtainShape();
    }

    private String obtainShape() {
        boolean error = false;
        do {
            Console console = new Console();
            shape = console.read("\nJuega " + name + ": ");
            error = !this.isValidShape(shape);
            if (error) {
                console.write("\nError: jugada no valida.");
            }
        } while (error);
        return shape;
    }

    private boolean isValidShape(String shape) {
        for (String validShape : SHAPES) {
            if (shape.equalsIgnoreCase(validShape)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSameShape(Player player) {
        return shape.equalsIgnoreCase(player.shape);
    }

    public boolean winTo(Player player) {
        return shape.equalsIgnoreCase(SHAPES[0]) && player.shape.equalsIgnoreCase(SHAPES[2])
            || shape.equalsIgnoreCase(SHAPES[1]) && player.shape.equalsIgnoreCase(SHAPES[0])
            || shape.equalsIgnoreCase(SHAPES[2]) && player.shape.equalsIgnoreCase(SHAPES[1]);
    }
}