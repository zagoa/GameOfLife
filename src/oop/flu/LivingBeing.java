package oop.flu;

/**
* A class representing common characteristics of all living beings of the simulation
* @version 2015.12.07
* @author Arnaud Zago
*/

public class LivingBeing {
    // type of living being
    protected final Type type;

    // state of living being
    protected State stateEnum;
   // protected String state;
    // disease of living being
    protected DiseaseEnum diseaseEnum;
    protected Disease disease;
    private int time;
    // wether it is infected
    private boolean infected = false;
    // wether it is dead
    private boolean dead = false;
    // wether it is healthy
    private boolean healthy;
    // wether it could change state (need to run simulation properly)
    protected boolean mayChangeState;

    /**
    * default constructor
    * @param type Type of an animal (chiken, duck or pig)
    * @param state its state (healthy, sick, etc.)
    * @param disease current disease
    * @param time /to specify/
    */
    public LivingBeing(Type type, State state, DiseaseEnum disease, int time) {
    	this.stateEnum = state;
     //   this.state = state.toString();
        this.diseaseEnum = disease;
        this.type = type;
        this.time = time;
        this.mayChangeState = true;
    }

/**
* @return time
*/
    public int getTime() {
        return time;
    }

/**
* @return current state
*/
    public State getState() {
        return stateEnum;
    }

/**
* @return current disease
*/
    public DiseaseEnum getDiseaseEnum() {
        return diseaseEnum;
    }

/**
* changes the being's current state
*/
    public void setState(State state) {
        this.stateEnum = state;
        //this.state=this.stateEnum.toString();
    }

/**
* @param disease the disease that we affect
*/
    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    /**
     * Removes the disease from the being
     */
    public void cureDisease(){
        this.disease=null;
    }

    /**
     *
     * @return the disease that is affected to the living being
     */
    public Disease getDisease(){
        return disease;
    }
/**
* @param timeSpend a time to be set
*/
    public void setTime(int timeSpend) {
        this.time = timeSpend;
    }

/**
* change state of LB to dead
*/
  /*  public void setDead(boolean dead) {
        this.dead = dead;
    }
    */
/**
* change state of LB to helthy
*/
   /* public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
    */
/**
* @return wether LB could change state
*/
    public boolean mayChangeState() {
        return mayChangeState;
    }
/**
* reset an indicator of possibility of changing state
*/
    public void setChangeable(boolean changeable) {
        this.mayChangeState = changeable;
    }

    public void changeState(Disease disease){}

    /**
     * Method that is redefined in other classes that returns the type of the being
     * @return the type of the being
     */
    public Type getType(){return null; }
}
