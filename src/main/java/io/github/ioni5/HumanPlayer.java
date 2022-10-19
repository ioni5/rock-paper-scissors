package io.github.ioni5;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        shape = this.obtainShape();
    }

    private String obtainShape() {
        String shape;
        boolean error = false;
        do {
            Console console = new Console();
            shape = console.read("\nJuega " + name + ": ");
            error = !this.isValidShape(shape);
            if (error) {
                console.write("\nError: jugada no válida.");
            }
        } while (error);
        return shape;
    }

}
