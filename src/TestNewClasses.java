package oop.flu;

public class TestNewClasses {

    public static void main(String[] args) {
    	// create new simulation with field 5x5 and poputation rate = 0.5
        Simulation simul = new Simulation(5,5, 0.5);
        // fill the field of simul
        simul.fillField(simul.getPopulationRate());
        System.out.println("Width = " + simul.getField().getWidth());
        System.out.println("Height = " + simul.getField().getHeight());
        // show the field
        System.out.println(simul.getField().toString());

    }
}