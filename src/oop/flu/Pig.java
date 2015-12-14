package oop.flu;

/**
* A class representing a pig
* @version 2015.12.13
* @author Baisangour Akhmadov
* @author Liavona Zheltanosava 
*/
public class Pig extends Animals{

    /**
    * default constructor
    * defaut type PIG
    * @param state its state (healthy, sick, etc.)
    * @param time /to specify/
    */
	public Pig(State state, int time){
		super(Type.PIG,state, DiseaseEnum.H1N1, time);
	}
	
    /**
    * toString method
    */
	public String toString(){
		String screen;
        String type = "", state = "", disease = "";
        type = "Pi";
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
        }

        screen = "" + type + " " + state + " " + disease;
        return screen;
	}

    public void setDisease(){
        disease = new Disease(DiseaseEnum.H1N1);
    }
    public Type getType(){
        return Type.PIG;
    }
}
