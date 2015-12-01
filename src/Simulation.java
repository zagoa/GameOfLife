package oop.flu;

public class Simulation{

	// les parametres par defaut
	private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 25;

    private int width;
    private int heigth;
    private Field field;

// constructeur par defaut
    public Simulation() {
    	this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Simulation (int width, int heigth) {
    // si les valeurs sont negatives on les remet par defaut
    	if (width <= 0 || heigth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            heigth = DEFAULT_HEIGHT;
            width = DEFAULT_WIDTH;
        }

        field = new Field(width, heigth);
    }
}