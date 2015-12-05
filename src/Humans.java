package oop.flu;

import java.util.Random;

public class Humans extends LivingBeing {
	public Humans(){
		super(Type.HUMAN,State.HEALTHY,Disease.NONE, 0);
	}
	public Humans(State state, Disease disease, int time){
		super(Type.HUMAN,state,disease, time);
	}

    public void changeState() {
        if (mayChangeState == false) return;
        if (stateEnum.equals(State.HEALTHY)) {
            System.out.println("He is healthy");
            setState(State.SICK);
        }
        else if (stateEnum.equals(State.SICK)) setState(State.CONTAGIOUS);
        else if (stateEnum.equals(State.CONTAGIOUS)) {
            Random rand = new Random();
            int randomNumber;
            randomNumber = rand.nextInt(101);
            // juste pour tester
            // il faudra le mettre en constante
            int percentage = 42;
            if (randomNumber >= percentage) {
                setState(State.DEAD);
                setDead(true);
            } 
            else {
                setState(State.IMUN);
                setHealthy(true);
            }
        }
    }
	
	public String toString(){
		String screen;
        String type="",state="",disease ="";
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

        screen = ""+type+" "+state+" "+disease;
        return screen;
	}

}
