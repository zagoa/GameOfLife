package oop.flu;

import java.util.Random;

public class Simulation{

	// les parametres par defaut
	private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 25;
    // rempli la moitie de champ
    private static final double POPULATION_RATE = 0.5;

    private int width;
    private int heigth;
    private double populationRate;
    private Field field;

// constructeur par defaut
    public Simulation() {
    	this(DEFAULT_WIDTH, DEFAULT_HEIGHT, POPULATION_RATE);
    }

    public Simulation (int width, int heigth, double populationRate) {
    // si les valeurs sont negatives on les remet par defaut
    	if (width <= 0 || heigth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            heigth = DEFAULT_HEIGHT;
            width = DEFAULT_WIDTH;
        }

        if (populationRate <= 0) {
            System.out.println("The population rate must be > 0");
            System.out.println("Using default values.");
            this.populationRate = populationRate;
        }

        field = new Field(width, heigth);
    }

/**
* fill the field with humans
* TODO : add animals
*/
    public void fillField (double populationRate) {
        Random rand = new Random();
        rand.nextDouble();
        field.emptyField();
        for (int j = 0; j < field.getHeight(); j++) {
            for (int i = 0; i < field.getWidth(); i++) {
                if (rand.nextDouble() <= POPULATION_RATE) {
                    // create a new person and place it on the field
                    Humans person = new Humans();
                    field.place(person, i, j);
                }
            }
        }
    }
    public Field getField() {
        return field;
    }

    public double getPopulationRate() {
        return populationRate;
    }

// TODO
    public void simulateOneStep() {
        // temporary field - a copy of a current field
        Field tmp = this.field;

    }    
}