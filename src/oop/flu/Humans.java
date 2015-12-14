package oop.flu;

import java.util.Random;

/**
* A class representing common characteristics of humans
* @version 2015.12.13
* @author Baisangour Akhmadov
* @author Liavona Zheltanosava
* @author Arnaud Zago
*/
public class Humans extends LivingBeing {

    private static boolean isVaccinated;
    /**
    * default constructor
    * human is healthy
    */
	public Humans(){
		super(Type.HUMAN, State.HEALTHY, DiseaseEnum.NONE, 0);
        this.isVaccinated = false;
	}

    /**
    * constructor
    * @param state Human's state (healthy, sick, etc.)
    * @param disease Current disease
    * @param time
    */
	public Humans(boolean isVaccinated){
		super(Type.HUMAN, State.HEALTHY, DiseaseEnum.NONE, 0);
        this.isVaccinated = isVaccinated;
	}

    /**
    * change the current human's state
    * @param disease A disease with its own parameters
    */
    @Override
    public void changeState(Disease disease) {
        if (mayChangeState == false || isVaccinated == true) return;
        if (stateEnum.equals(State.HEALTHY)) {
            setState(State.SICK);
            setDisease(disease);
        }

        else if (stateEnum.equals(State.SICK) && (getTime()>disease.getContagiousTime())) {
            setState(State.CONTAGIOUS);
        }
        else if (stateEnum.equals(State.CONTAGIOUS) && (getTime()>disease.getRecoveryTime())) {
            Random rand = new Random();
            int randomNumber;
            randomNumber = rand.nextInt(101);
            if (randomNumber >= disease.getDeathRate()) {
                setState(State.DEAD);
                setDead(true);
            }
            else {
                setState(State.IMUN);
                cureDisease();
                setHealthy(true);
            }
        }
    }

    /**
    * @param disease A disease to be set
    */
    public void setDisease(Disease disease){
        diseaseEnum=disease.getName();
        this.disease =new Disease(disease.getName());
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }


/**
* toString method
*/
	public String toString(){
		String screen;
        String type = "", state = "", disease = "";
        type = "Hu";
        switch (this.stateEnum) {
            case SICK:
                state = "S";
                break;
            case HEALTHY:
                state = "H";
                break;
            case CONTAGIOUS:
                state = "C";
                break;
            case RECOVERING:
                state = "R";
                break;
            case DEAD:
                state = "D";
                break;
            case IMUN:
                state = "I";
                break;
        }
        switch(this.diseaseEnum) {
            case NONE:
                disease = "NO";
                break;
            case H1N1:
                disease = "H1";
                break;
            case H5N1:
                disease = "H5";
                break;
        }

        screen = "" + type + " " + state + " " + disease;
        return screen;
	}

    /**
    * @return type of living being (human)
    */
    public Type getType(){
        return Type.HUMAN;
    }
}
