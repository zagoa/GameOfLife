package oop.flu;

/**
* A class representing common characteristics of birds
* @version 2015.12.13
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
		super(type,state, DiseaseEnum.H5N1, time);
	}

	/**
	* set a specified (H5N1) virus to a bird
	*/
	public void setDisease(){
		disease = new Disease(DiseaseEnum.H5N1);
	}

}
