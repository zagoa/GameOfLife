package oop.flu;

/**
* A class representing chicken
* @version 2015.12.07
*/
public class Chicken extends Birds{

    /**
    * default constructor
    * defaut type CHICKEN
    * @param state its state (healthy, sick, etc.)
    * @param time /to specify/
    */
	public Chicken(State state, int time) {
		super(Type.CHICKEN, state, time);
	}

    public Type getType(){
        return Type.CHICKEN;
    }
}
