package oop.flu;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Simulation{

	// les parametres par defaut
	private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 25;
    // rempli la moitie de champ
    private static final double POPULATION_RATE = 0.5;
    // neighbourhood par defaut
    private static final Neighbourhood DEFAULT_NEIGHBOURHOOD = Neighbourhood.FOUR_N;

    private int width;
    private int heigth;
    private double populationRate;
    private Field field;
    private List<SimulatorView> views;
    private List<LivingBeing> animals;
    private int step;




    private Neighbourhood neighbourhood;

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
        animals = new ArrayList<>();
        views = new ArrayList<>();

        SimulatorView view = new GridView(width, heigth);
        //HEALTHY
        view.setColor(Humans.class,State.HEALTHY, Color.BLUE);
        view.setColor(Chicken.class,State.HEALTHY, Color.ORANGE);
        view.setColor(Pig.class,State.HEALTHY, Color.PINK);
        view.setColor(Duck.class,State.HEALTHY, Color.GREEN);

        //SICK

        view.setColor(Humans.class,State.SICK, Color.RED);
        view.setColor(Chicken.class,State.SICK, Color.RED);
        view.setColor(Pig.class,State.SICK, Color.RED);
        view.setColor(Duck.class,State.SICK, Color.RED);

        //CONTAGIOUS
        view.setColor(Humans.class,State.CONTAGIOUS, Color.BLACK);
        view.setColor(Chicken.class,State.CONTAGIOUS, Color.BLACK);
        view.setColor(Pig.class,State.CONTAGIOUS, Color.BLACK);
        view.setColor(Duck.class,State.CONTAGIOUS, Color.BLACK);

        //DEAD
        view.setColor(Humans.class,State.DEAD, Color.MAGENTA);
        view.setColor(Chicken.class,State.DEAD, Color.MAGENTA);
        view.setColor(Pig.class,State.DEAD, Color.MAGENTA);
        view.setColor(Duck.class,State.DEAD, Color.MAGENTA);

        //RECOVERING
        view.setColor(Humans.class,State.RECOVERING, Color.CYAN);
        view.setColor(Chicken.class,State.RECOVERING, Color.CYAN);
        view.setColor(Pig.class,State.RECOVERING, Color.CYAN);
        view.setColor(Duck.class,State.RECOVERING, Color.CYAN);

        //IMMUNITY
        view.setColor(Humans.class,State.IMUN, Color.CYAN);
        view.setColor(Chicken.class,State.IMUN, Color.CYAN);
        view.setColor(Pig.class,State.IMUN, Color.CYAN);
        view.setColor(Duck.class,State.IMUN, Color.CYAN);

        views.add(view);

        // Setup a valid starting point.
        // reset();
    }


    /**
* @return a random sick animal
* used to fill the field
*/
    public LivingBeing createRandomSickAnimal() {
        Random rand = new Random();
        if (rand.nextDouble() < 0.3) {
            Pig pig  = new Pig(State.CONTAGIOUS, 0);
            return pig;
        }
        else if (rand.nextDouble() < 0.6) {
            Chicken chicken = new Chicken(State.CONTAGIOUS, 0);
            return chicken;
        }
        else {
            Duck duck = new Duck(State.CONTAGIOUS, 0);
            return duck;
        }
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
                    Random newRandom = new Random();

                    if (newRandom.nextDouble() <= 0.5) {
                        Humans person = new Humans();
                        animals.add(person);
                        field.place(person, i, j);
                    }
                    else {
                        LivingBeing animal = createRandomSickAnimal();
                        animals.add(animal);
                        field.place(animal, i, j);
                    }
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

    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

    //reinitialize changeable state of everybody on the field
    public void reset() {
        for (int j = 0; j < field.getHeight(); j++) {
            for (int i = 0; i < field.getWidth(); i++) {
                if (field.getLivingBeing(i, j) != null) field.getLivingBeing(i, j).setChangeable(true);
            }
        }
    }

// TODO
    public void simulateOneStep() {
        System.out.println("In simulateOneStep");
        step++;
        reset();
        // temporary field - a copy of a current field to compare while doing next step
        Field tmp = this.field;
        for (int j = 0; j < field.getHeight(); j++) {
            for (int i = 0; i < field.getWidth(); i++) {
                // si il y a qqn qui est malade et peut transmettre la maladie
                if ((tmp.getLivingBeing(i, j) != null) && (tmp.getLivingBeing(i, j).getState().equals(State.CONTAGIOUS))) {
                    // System.out.println("i = " + i + " j = " + j + " is CONTAGIOUS");
                    // change state of neighbour on the rigth
                    if (indexGood(i+1, j, field) && (field.getLivingBeing(i+1, j) != null) && field.getLivingBeing(i+1, j).mayChangeState()) {
                        field.getLivingBeing(i+1, j).changeState();
                        field.getLivingBeing(i+1, j).setChangeable(false);
                    }
                    // change state of neighbour on the left
                    if (indexGood(i-1, j, field) && (field.getLivingBeing(i-1, j) != null) && field.getLivingBeing(i-1, j).mayChangeState()) {
                        field.getLivingBeing(i-1, j).changeState();
                        field.getLivingBeing(i-1, j).setChangeable(false);
                    }
                    // change state of neighbour on the top
                    if (indexGood(i, j-1, field) && (field.getLivingBeing(i, j-1) != null) && field.getLivingBeing(i, j-1).mayChangeState()) {
                        field.getLivingBeing(i, j-1).changeState();
                        field.getLivingBeing(i, j-1).setChangeable(false);
                    }
                    // change state of neighbour on the bottom
                    if (indexGood(i, j+1, field) && (field.getLivingBeing(i, j+1) != null) && field.getLivingBeing(i, j+1).mayChangeState()) {
                        field.getLivingBeing(i, j+1).changeState();
                        field.getLivingBeing(i, j+1).setChangeable(false);
                    }
                }
            }
        }
    updateViews();
    }

    private void updateViews() {
        for (SimulatorView view : views) {
            view.showStatus(step, field);
        }
    }

    public void run() throws InterruptedException {
        while(!field.areAllDead() || !field.areAllHealthy()) {
            simulateOneStep();
            System.out.println(field.toString());
            try{
                Thread.sleep(2000);
                //this.wait(1000);
            }catch(Exception e){
                System.out.println("Probleme");
            }
        }
    }

    // check indexes to avoid NullPointerException
    public boolean indexGood(int i, int j, Field field) {
        if (0 <= i && i < field.getWidth() && 0 <= j && j < field.getHeight() ) return true;
        return false;
    }
}