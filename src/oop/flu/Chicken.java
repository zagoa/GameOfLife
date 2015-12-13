package oop.flu;

/**
* A class representing chicken
* @version 2015.12.13
*/
public class Chicken extends Birds{

    /**
    * default constructor
    * defaut type CHICKEN
    * @param state its state (healthy, sick, etc.)
    * @param time
    */
	public Chicken(State state, int time) {
		super(Type.CHICKEN, state, time);
	}

    /**
    * toString method
    */
	public String toString(){
		String screen;
        String type = "",state = "",disease = "";
        type = "Ch";
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
            case H5N1:
                disease = "H5";
                break;
        }

        screen = "" + type + " " + state + " " + disease;
        return screen;
	}

    /**
    * @return type of a bird (chicken)
    */
    public Type getType(){
        return Type.CHICKEN;
    }
}
