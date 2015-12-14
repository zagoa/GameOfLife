package oop.flu;

/**
* A class representing common characteristics of all living beings of the simulation
* @version 2015.12.07
* @author Arnaud Zago
* @author Liavona Zheltanosava
*/

public class LivingBeing {
    // type of living being
    protected final Type type;
/*    // inutile
    private State[] allState = {State.HEALTHY, State.SICK, State.CONTAGIOUS, State.RECOVERING, State.DEAD,State.IMUN};
    private DiseaseEnum[] allDisease = {DiseaseEnum.NONE, DiseaseEnum.H1N1, DiseaseEnum.H5N1};
    private Type[] allType = {Type.HUMAN, Type.PIG, Type.DUCK, Type.CHICKEN};*/
    // state of living being
    protected State stateEnum;
    protected String state;
    // disease of living being
    protected DiseaseEnum diseaseEnum;
    protected Disease disease;
    private int time;
    // wether it is infected
    private boolean infected = false;
/*    // ???
    private boolean isNew = false;*/
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
        this.state = state.toString();
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
    }

/**
* @param disease a disease to be set
*/
    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public void cureDisease(){
        this.disease = null;
    }

/**
* @return current disease
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
* @return wether a living being is infected or not
*/
    public boolean isInfected() {
        return infected;
    }

/**
* change infection state
* @param infected a boolean to be set
*/
    public void setInfected(boolean infected) {
        this.infected = infected;
    }

/**
* NE SONT PAS UTILISES
*/
/*    public boolean isNew() {
        return isNew;
    }
    public void setNew(boolean aNew) {
        isNew = aNew;
    }*/

/**
* @return wether LB is dead 
*/
    public boolean isDead() {
        return dead;
    }
/**
* @return wether LB is healthy 
*/  
    public boolean isHealthy() {
        return healthy;
    }
/**
* change state of LB to dead
*/
    public void setDead(boolean dead) {
        this.dead = dead;
    }
/**
* change state of LB to helthy
*/
    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
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
/**
* change state of LV
*/
    public void changeState(Disease disease) {}
    
    public Type getType() { return null; }
}
