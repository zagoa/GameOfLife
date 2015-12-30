package oop.flu;

/**
 * A class representing a pig
 *
 * @version 2015.12.07
 * @Akhmadov Baisangour
 */
public class Pig extends Animals {

    /**
     * default constructor
     * defaut type PIG
     *
     * @param state its state (healthy, sick, etc.)
     * @param time  /to specify/
     */
    public Pig(State state, int time) {
        super(Type.PIG, state, DiseaseEnum.H1N1, time);
    }

    public void setDisease() {
        disease = new Disease(DiseaseEnum.H1N1);
    }

    public Type getType() {
        return Type.PIG;
    }
}
