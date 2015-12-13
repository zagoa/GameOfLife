package oop.flu;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
* A class describing a simulation
* @version 2015.12.13
* @author Baisangour Akhmadov
* @author Arnaud Zago
* @author Liavona Zheltanosava
*/
public class Simulation{

	// default parameters
	private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 25;
    private static final double POPULATION_RATE = 0.5;
    private static final Neighbourhood DEFAULT_NEIGHBOURHOOD = Neighbourhood.FOUR_N;

    private int width;
    private int height;
    private double populationRate;
    private Neighbourhood neighbourhood;
    private Field field;
    private List<SimulatorView> views;
    private List<LivingBeing> livingBeings;
    private int step;

/**
* default constructor
*/
    public Simulation() {
    	this(DEFAULT_WIDTH, DEFAULT_HEIGHT, POPULATION_RATE, DEFAULT_NEIGHBOURHOOD);
    }
/**
* constructor of simulation
* @param width Width of the field
* @param height Height of the field
* @param populationRate Percentage of the field to be filled
*/
    public Simulation (int width, int height, double populationRate, Neighbourhood n) {
    // si les valeurs sont negatives on les remet par defaut
    	if (width <= 0 || height <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            this.height = DEFAULT_HEIGHT;
            this.width = DEFAULT_WIDTH;
        }
        else{
            this.height = height;
            this.width = width;
        }
        if (populationRate <= 0) {
            System.out.println("The population rate must be > 0");
            System.out.println("Using default values.");
            this.populationRate = POPULATION_RATE;
        }
        else this.populationRate = populationRate;

        neighbourhood = n;
        field = new Field(this.width, this.height);
        livingBeings = new ArrayList<>();
        views = new ArrayList<>();

        SimulatorView view = new GridView(this.width, this.height);
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
        view.setColor(Humans.class,State.CONTAGIOUS, Color.lightGray);
        view.setColor(Chicken.class,State.CONTAGIOUS, Color.lightGray);
        view.setColor(Pig.class,State.CONTAGIOUS, Color.lightGray);
        view.setColor(Duck.class,State.CONTAGIOUS, Color.lightGray);

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

        //DISEASES
     /*   view.setColor(Humans.class,DiseaseEnum.H1N1, new Color(122,95,229));
        view.setColor(Humans.class,DiseaseEnum.H5N1, new Color(54,43,98));
        view.setColor(Chicken.class,DiseaseEnum.H5N1, new Color(197,161,0));
        view.setColor(Pig.class,DiseaseEnum.H1N1, new Color(74,32,73));
        view.setColor(Duck.class,DiseaseEnum.H5N1, new Color(8,59,0));
*/
        views.add(view);
    }


/**
* @return a random healthy or contagious animal
*/
    public LivingBeing createRandomSickAnimal() {
        Random rand = new Random();
        if (rand.nextDouble() < 0.3) {
            Pig pig;
            if(rand.nextDouble() > 0.5){
                pig = new Pig(State.HEALTHY, 0);
                return pig;
            }
            pig = new Pig(State.CONTAGIOUS, 0);
            pig.setDisease();
            return pig;
        }
        else if (rand.nextDouble() < 0.6) {
            Chicken chicken;
            if(rand.nextDouble() > 0.5){
                chicken = new Chicken(State.HEALTHY, 0);
                return chicken;
            }
            chicken = new Chicken(State.CONTAGIOUS, 0);
            chicken.setDisease();
            return chicken;
        }
        else {
            Duck duck;
            if(rand.nextDouble() > 0.5){
                duck= new Duck(State.HEALTHY, 0);
                return duck;
            }
            duck = new Duck(State.CONTAGIOUS, 0);
            duck.setDisease();
            return duck;
        }
    }
/**
* fill the field with humans and animals
* @param populationRate Percentage of the field to be filled
*/
    public void fillField (double populationRate) {
        Random rand = new Random();
        rand.nextDouble();
        field.emptyField();
        for (int j = 0; j < field.getHeight(); j++) {
            for (int i = 0; i < field.getWidth(); i++) {
                if (rand.nextDouble() <= populationRate) {
                    // create a new healthy person and place it on the field
                    Random newRandom = new Random();
                    if (newRandom.nextDouble() <= 0.5) {
                        Humans person = new Humans();
                        livingBeings.add(person);
                        field.place(person, i, j);
                    }
                    else {
                        LivingBeing animal = createRandomSickAnimal();
                        livingBeings.add(animal);
                        field.place(animal, i, j);
                    }
                }
            }
        }
    }

/**
* @return the field
*/
    public Field getField() {
        return field;
    }

/**
* @return the population rate
*/
    public double getPopulationRate() {
        return populationRate;
    }

/**
* @return the type of neighbourhood
*/
    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

/**
* reset changeable state of everybody on the field
* used to change state of LB only once during one step of simulation
*/
    public void reset() {
        for (int j = 0; j < field.getHeight(); j++) {
            for (int i = 0; i < field.getWidth(); i++) {
                if (field.getLivingBeing(i, j) != null) field.getLivingBeing(i, j).setChangeable(true);
            }
        }
    }
/**
* deplace a LB
* @param person a LB to be deplaced
* @param currentX its current X position
* @param currentY its current Y position
* @param adjacentX its future X position
* @param adjacentY its future Y position
* @return wether LB has moved
*/
    public boolean attemptMove(LivingBeing person, int currentX, int currentY, int adjacentX, int adjacentY){
        if(indexGood(adjacentX, adjacentY, field) && field.getLivingBeing(adjacentX,adjacentY) == null){
            Random r = new Random();
            if(r.nextDouble() > 0.7){
                field.remove(currentX, currentY);
                field.place(person, adjacentX, adjacentY);
                return true;
            }
            return false;
        }
        return false;
    }

/**
* check if disease can be transmitted from one LB to another
* @param sick A sick living being
* @param neighbour A neighbour of sick LB
* @return wether disease can be ransmitted
*/
    public boolean checkCompatibility(LivingBeing sick, LivingBeing neighbour){
        if(sick.getDiseaseEnum() == null) return false;
        if(neighbour.getState() == State.IMUN || neighbour.getState() == State.DEAD) return false; //Si le voisin est immunisé, il ne peut pas être contaminé
        if(sick.getClass() == neighbour.getClass()) return true; //Si le malade et son voisin sont de meme type, le voisin peut être contaminé
        if(neighbour.getClass() == Humans.class) return true; //L'humain peut etre contaminé par n'importe quel être contagieux

        //Si c'est un oiseau, il peut contaminer un autre oiseau
        if(sick.getClass().getSuperclass() == neighbour.getClass().getSuperclass() && sick.getClass().getSuperclass() == Birds.class) return true;
        return false;
    }

/**
* transmit disease 
* @param sick A sick living being
* @param neighbourI Neighbour width position
* @param neighbourJ Neighbour heght posiion
*/
    public void affectNeighbour(LivingBeing sick,int neighbourI,int neighbourJ){
        if (indexGood(neighbourI, neighbourJ, field) && (field.getLivingBeing(neighbourI, neighbourJ) != null)  && field.getLivingBeing(neighbourI, neighbourJ).mayChangeState()) {
            LivingBeing neighbour = field.getLivingBeing(neighbourI, neighbourJ);
            if(checkCompatibility(sick, field.getLivingBeing(neighbourI, neighbourJ))) {
                neighbour.changeState(sick.getDisease());
                neighbour.setChangeable(false);
            }
        }
    }

/**
* affect disease to the neighbours
* @param n Type of neighbourhood (may be 4- or 8-)
* @param sick a sick living being
* @param positionX current X position of sick LB
* @param positionY current Y position of sick LB
*/ 
    public void affectNeighbourhood(Neighbourhood n, LivingBeing sick, int positionX, int positionY) {
        // dans tout le cas affecte les 4 voisins
        affectNeighbour(sick, positionX + 1, positionY);
        affectNeighbour(sick, positionX - 1, positionY);
        affectNeighbour(sick, positionX, positionY - 1);
        affectNeighbour(sick, positionX, positionY + 1);
        // affecte encore 4 voisin en diagonale si c'est demande
        if (n.equals(Neighbourhood.EIGTH_N)) {
            affectNeighbour(sick, positionX + 1, positionY - 1);
            affectNeighbour(sick, positionX - 1, positionY - 1);
            affectNeighbour(sick, positionX + 1, positionY + 1);
            affectNeighbour(sick, positionX - 1, positionY + 1);
        }
    }

/**
* run one step of simulation
*/
    public void simulateOneStep() {
        step++;
        // reset all LB of the field to change their states only one time
        reset();
        // temporary field - a copy of a current field to compare while doing next step
        Field tmp = this.field;
        for (int j = 0; j < field.getHeight(); j++) {
            for (int i = 0; i < field.getWidth(); i++) {

                //If a being is dead, he's removed from the field
                if (tmp.getLivingBeing(i, j) != null && (tmp.getLivingBeing(i, j).isDead())) {
                    field.remove(i,j);
                }
                // si il y a qqn qui est malade et peut transmettre la maladie
                if ((tmp.getLivingBeing(i, j) != null) && (tmp.getLivingBeing(i, j).getState().equals(State.CONTAGIOUS))) {
                    LivingBeing sick = field.getLivingBeing(i,j);
                    // change state of neighbours
                    affectNeighbourhood(neighbourhood, sick, i, j);
                    /*affectNeighbour(sick,i+1,j);
                    affectNeighbour(sick,i-1,j);
                    affectNeighbour(sick,i,j-1);
                    affectNeighbour(sick,i,j+1);*/
                }
                // if there is a human and he is not dead, he can move on the field
                if((field.getLivingBeing(i,j) != null) && field.getLivingBeing(i,j) instanceof Humans && field.getLivingBeing(i,j).getState()!=State.DEAD){
                    LivingBeing movingPerson=field.getLivingBeing(i,j);
                    boolean moved;
                    moved = attemptMove(movingPerson, i, j, i+1, j);
                    if(!moved) moved = attemptMove(movingPerson, i, j, i-1, j);
                    if(!moved) moved = attemptMove(movingPerson, i, j, i, j-1);
                    if(!moved) attemptMove(movingPerson, i, j, i, j+1);
                }
            }
        }
        addTime();
        updateViews();
    }

    private void updateViews() {
        for (SimulatorView view : views) {
            view.showStatus(step, field);
        }
    }

/**
* run the simulation
* @throws  InterruptedException /to specify/
*/
    public void run() throws InterruptedException {
        while(!field.areAllDead() || !field.areAllHealthy()) {
            simulateOneStep();
            // System.out.println(field.toString());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println("Probleme");
            }
        }
    }

/**
* manage time
*/
    public void addTime(){
        for (int j = 0; j<height; j++){
            for (int i =0; i<width; i++){
                Field tmp = this.field;
                if ((tmp.getLivingBeing(i, j) != null) && !(tmp.getLivingBeing(i, j).isHealthy())) {
                    field.getLivingBeing(i, j).setTime(field.getLivingBeing(i, j).getTime() + 1);
                    // field.getLivingBeing(i,j).changeState(field.getLivingBeing(i,j).getDisease());
                }
            }
        }
    }

/**
* check indexes to avoid NullPointerException while running the simulation
*/
    public boolean indexGood(int i, int j, Field field) {
        if (0 <= i && i < field.getWidth() && 0 <= j && j < field.getHeight() ) return true;
        return false;
    }
}