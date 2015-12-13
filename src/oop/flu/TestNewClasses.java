package oop.flu;

import java.util.*;

public class TestNewClasses {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String param = "";  
        System.out.print("Do you want default simulation? o/n: ");  
        param = scan.nextLine();
        Simulation simul;
        // create a simulation with default parameters
        if (param.equals("o") || param.equals("O")) {
            simul = new Simulation();
        }
        // user enter his parameters
    	else if (param.equals("n") || param.equals("N")) {
            scan.useLocale(Locale.US);
            int width = 0;
            int height = 0;
            double poputationRate = 0;
            System.out.print("Enter width (int): ");
            width = scan.nextInt();
            System.out.print("Enter height (int): ");
            height = scan.nextInt(); 
            System.out.print("Enter population rate (0 < n < 1): ");
            poputationRate = scan.nextDouble(); 
            simul = new Simulation(width, height, poputationRate);
        }
        else {
            System.out.println("Yolo, retry plz");
            return;
        }
        // fill the field of simul
        simul.fillField(simul.getPopulationRate());
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