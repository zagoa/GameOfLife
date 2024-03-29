package oop.flu;

import java.awt.Color;

/**
 * A graphical view of the simulation grid. This interface defines all possible
 * different views.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public interface SimulatorView {
    /**
     * Define a color to be used for a given class of animal.
     * 
     * @param beingClass
     *            The animal's Class object.
     * @param color
     *            The color to be used for the given class.
     */
    void setColor(Class beingClass, State state, Color color);

    void setColor(Class beingClass, Color color);

    /**
     * Determine whether the simulation should continue to run.
     * 
     * @return true If there is more than one species alive.
     */
    boolean isViable(Field field);

    /**
     * Show the current status of the field.
     * 
     * @param step
     *            Which iteration step it is.
     * @param field
     *            The field whose status is to be displayed.
     */
    void showStatus(int step, Field field);

    /**
     * Prepare for a new run.
     */
    void reset();


}