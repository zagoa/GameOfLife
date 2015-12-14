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

    /**
    * constructor
    * @param state human's state (healthy, sick, etc.)
    * @param disease current disease
    * @param time /to specify/
    */
	public Humans(State state, DiseaseEnum disease, int time){
		super(Type.HUMAN,state,disease, time);
	}

    /**
    * change the current human's state
    */
    @Override
    public void changeState(Disease disease) {
        if (mayChangeState == false) return;
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
            // juste pour tester
            // il faudra le mettre en constante
            int percentage = 80; //taux de mort de la maladie
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
    public void setDisease(Disease disease){
        diseaseEnum=disease.getName();
        this.disease =new Disease(disease.getName());
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
    public Type getType(){
        return Type.HUMAN;
    }
}
