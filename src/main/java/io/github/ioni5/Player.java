package io.github.ioni5;

public abstract class Player {

    protected static final String SHAPES[] = {"PIEDRA", "PAPEL", "TIJERA"};

    protected String name;

    protected String shape;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void play();

    protected boolean isValidShape(String shape) {
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