package oop.flu;

import java.util.Random;

/**
* A class representing common characteristics of humans
* @version 2015.12.07
*/
public class Humans extends LivingBeing {
    /**
    * default constructor
    * human is healthy
    */
	public Humans(){
		super(Type.HUMAN,State.HEALTHY, DiseaseEnum.NONE, 0);
	}


    public Humans(State state) {
        super(Type.HUMAN, state, DiseaseEnum.NONE, 0);
    }

    /**
    * change the current human's state
    */
    @Override
    public void changeState(Disease disease) {
        if (!mayChangeState || stateEnum.equals(State.VACCINATE)) return;
        if (stateEnum.equals(State.HEALTHY)) {
            setState(State.SICK);
            setDisease(disease);
        }

        else if (stateEnum.equals(State.SICK) && (getTime()>disease.getContagiousTime())) {
            setState(State.CONTAGIOUS);
        }
        else if (stateEnum.equals(State.CONTAGIOUS) && (getTime()>disease.getRecoveryTime())) {
            // TODO : faire un random correct
            // TODO : mettre le pourcentage dans une constante
            Random rand = new Random();
            int randomNumber;
            randomNumber = rand.nextInt(101);


            if (randomNumber >= disease.getDeathRate()) {
                setState(State.DEAD);
            //    setDead(true);
            }
            else {
                setState(State.IMUN);
                cureDisease();
            //    setHealthy(true);
            }

        }
    }

    /**
     * Affect a disease to the human
     * @param disease the disease that we will set
     */
    public void setDisease(Disease disease){
        diseaseEnum=disease.getName();
        this.disease =new Disease(disease.getName());
    }

    public Type getType(){
        return Type.HUMAN;
    }
}
