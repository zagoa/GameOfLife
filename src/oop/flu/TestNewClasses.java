package oop.flu;

public class TestNewClasses {

    public static void main(String[] args) throws InterruptedException {
    	// create new simulation with field 5x5 and poputation rate = 0.5
        Simulation simul = new Simulation(10,10, 0.5);
        // fill the field of simul
        simul.fillField(simul.getPopulationRate());
        System.out.println("Width = " + simul.getField().getWidth());
        System.out.println("Height = " + simul.getField().getHeight());
        // show the field
        System.out.println(simul.getField().toString());
        
        // test one step
        simul.simulateOneStep();
        System.out.println(simul.getField().toString());
        // Humans person = new Humans();
        // person.changeState();
        // System.out.println(person.toString());
        System.out.println("Are they all dead? : " + simul.getField().areAllDead());
        System.out.println("Are they all healthy? : " + simul.getField().areAllHealthy());
        
        simul.run();
    }
}