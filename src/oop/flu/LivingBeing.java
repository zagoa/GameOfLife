package oop.flu;

/**
* A class representing common characteristics of all living beings of the simulation
* @version 2015.12.07
* @author Arnaud Zago
*/

public class LivingBeing {
    // type of living being
    protected final Type type;
    // inutile
//    private State[] allState = {State.HEALTHY, State.SICK, State.CONTAGIOUS, State.RECOVERING, State.DEAD,State.IMUN};
//    private Disease[] allDisease = {Disease.NONE, Disease.H1N1, Disease.H5N1};
//    private Type[] allType = {Type.HUMAN, Type.PIG, Type.DUCK, Type.CHICKEN};
    // state of living being
    protected State stateEnum;
    protected String state;
    // disease of living being
    protected Disease diseaseEnum;
    private String disease;
    private int time;
    // wether it is infected
    private boolean infected = false;
    // ???
    private boolean isNew = false;
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
    public LivingBeing(Type type, State state, Disease disease, int time) {
    	this.stateEnum = state;
        this.state = state.toString();
        this.diseaseEnum = disease;
        this.disease = disease.toString();
        this.type = type;
        this.time = time;
        this.mayChangeState = true;
    }

    //@Override
   /* public String toString(){
        String screen;
        String type="",state="",desease ="";

        switch (this.type) {
            case HUMAN:
                type = "Hu";
                break;
            case PIG:
                type = "Pi";
                break;
            case CHICKEN:
                type = "Ch";
                break;
            case DUCK:
                type = "Du";
                break;
        }
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
                desease = "NO";
                break;
            case H1N1:
                desease = "H1";
                break;
            case H5N1:
                desease = "H5";
                break;
        }

        screen = ""+type+" "+state+" "+desease;
        return screen;

    }
*/

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
    public Disease getDisease() {
        return diseaseEnum;
    }

/**
* @return current state
*/
    public void setState(State state) {
        this.stateEnum = state;
        //this.state=this.stateEnum.toString();
    }

/**
* @param disease a disease to be set
*/
    public void setDisease(Disease disease) {
        this.diseaseEnum = disease;
        //this.disease=this.diseaseEnum.toString();
    }
/**
* @param time a time to be set
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
    public boolean isNew() {
        return isNew;
    }
    public void setNew(boolean aNew) {
        isNew = aNew;
    }

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
* kill LB
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

    public void changeState(){}
}
