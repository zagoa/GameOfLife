package oop.flu;

/**
 * Created by Arnaud on 23/11/2015.
 */
public class LivingBeing {
    protected final Type type;
    private State[] allState = {State.HEALTHY, State.SICK, State.CONTAGIOUS, State.RECOVERING, State.DEAD,State.IMUN};
    private Disease[] allDisease = {Disease.NONE, Disease.H1N1, Disease.H5N1};
    private Type[] allType = {Type.HUMAN, Type.PIG, Type.DUCK, Type.CHICKEN};
    protected State stateEnum;
    private String state;
    protected Disease diseaseEnum;
    private String disease;
    private int time;
    private boolean infected = false;
    private boolean isNew = false;
    private boolean dead = false;
    private boolean healty;

    public LivingBeing(Type type,State state, Disease disease) {
    	this.stateEnum=state;
        this.state = state.toString();
        this.diseaseEnum = disease;
        this.disease=disease.toString();
        this.type = type;
        


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
    public int getTime() {

        return time;
    }

    public State getState() {

        return stateEnum;
    }

    public Disease getDisease() {
        return diseaseEnum;
    }

    public void setState(State state) {
        this.stateEnum = state;
        //this.state=this.stateEnum.toString();
    }

    public void setDisease(Disease disease) {
        this.diseaseEnum = disease;
        //this.disease=this.diseaseEnum.toString();
    }

    public void setTime(int timeSpend) {
        this.time = timeSpend;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isDead() {
        return dead;
    }
    
    public boolean isHealthy() {
        return healty;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
