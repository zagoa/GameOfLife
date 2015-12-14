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
	public Animals(Type type, State state, DiseaseEnum disease, int time){
		super(type,state,disease,time);
	}

    /**
    * change the current state of an animal
    */

    @Override
    public void changeState(Disease disease) {
        if (mayChangeState == false) return;
        if (stateEnum.equals(State.HEALTHY)) {
            setState(State.SICK);
            setDisease(disease);
        }
        else if (stateEnum.equals(State.SICK) && getTime()>disease.getContagiousTime()) setState(State.CONTAGIOUS);


        else if (stateEnum.equals(State.CONTAGIOUS) && getTime()>disease.getRecoveryTime()) {
            // generate a random integer between 0 and 100
            Random rand = new Random();
            int randomNumber;
            randomNumber = (int) (Math.random() * (100));
            if (randomNumber >= disease.getDeathRate()) {
                setState(State.DEAD);
                setDead(true);
            }
        }
    }
}
