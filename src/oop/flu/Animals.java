package oop.flu;
import java.util.Random;

/**
* A class representing common characteristics of animals
* @version 2015.12.07
* @author Baisangour Akhmadov
*/
public abstract class Animals extends LivingBeing {
	// percentage mortality rate of an animal
    private static final int MORTALITY_RATE = 42;
    /**
    * default constructor
    * @param type Type of an animal (chiken, duck or pig)
    * @param state its state (healthy, sick, etc.)
    * @param disease current disease
    * @param time /to specify/
    */
	public Animals(Type type, State state, Disease disease, int time){
		super(type,state,disease,time);
	}

    /**
    * change the current state of an animal
    */
    @Override
    public void changeState() {
        if (mayChangeState == false) return;
        if (stateEnum.equals(State.HEALTHY)) setState(State.SICK);
        else if (stateEnum.equals(State.SICK) && getTime()>2) setState(State.CONTAGIOUS);
        else if (stateEnum.equals(State.CONTAGIOUS) && getTime()>4) {
            // generate a random integer between 0 and 100
            Random rand = new Random();
            int randomNumber;
            randomNumber = (int) (Math.random() * (100));
            // if (randomNumber <= MORTALITY_RATE) {
            if (randomNumber >= MORTALITY_RATE) {
                setState(State.DEAD);
                setDead(true);
            } 
        }
    }
}
