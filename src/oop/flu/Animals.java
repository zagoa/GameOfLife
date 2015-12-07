package oop.flu;

import java.util.Random;

public abstract class Animals extends LivingBeing {
	// percentage mortality rate of an animal
    private static final int MORTALITY_RATE = 42;
	public Animals(Type type, State state, Disease disease, int time){
		super(type,state,disease,time);
	}

    @Override
	public void changeState() {
        if (mayChangeState == false) return;
        if (stateEnum.equals(State.HEALTHY)) setState(State.SICK);
        else if (stateEnum.equals(State.SICK)) setState(State.CONTAGIOUS);
        else if (stateEnum.equals(State.CONTAGIOUS)) {
            Random rand = new Random();
            int randomNumber;
            randomNumber = (int) (Math.random() * (100));
            if (randomNumber >= MORTALITY_RATE) {
                setState(State.DEAD);
                setDead(true);
            } 
        }
    }
}