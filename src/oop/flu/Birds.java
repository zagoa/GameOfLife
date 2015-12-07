package oop.flu;

/**
* A class representing common characteristics of birds
* @version 2015.12.07
*/
public abstract class Birds extends Animals{

	/**
    * default constructor
    * @param type Type of bird (chiken or duck)
    * @param state its state (healthy, sick, etc.)
    * @param time /to specify/
    * by default disease is set to H5N1
    */
	public Birds(Type type, State state, int time) {
		super(type,state,Disease.H5N1, time);
		// TODO Auto-generated constructor stub
	}

}
