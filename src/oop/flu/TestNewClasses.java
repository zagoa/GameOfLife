package oop.flu;

import java.util.*;

public class TestNewClasses {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String param = "";  
        System.out.print("Do you want default simulation? o/n: ");  
        param = scan.nextLine();
        Simulation simul;

        int speed = 0;
        // create a simulation with default parameters
        if (param.equals("o") || param.equals("O")) {
            simul = new Simulation();
            speed = 100;
        }
        // user enter his parameters
        else if (param.equals("n") || param.equals("N")) {
            scan.useLocale(Locale.US);
            int width = 0;
            int height = 0;
            double poputationRate = 0;
            Neighbourhood nb = Neighbourhood.FOUR_N;
            System.out.print("Enter width (int): ");
            width = scan.nextInt();
            System.out.print("Enter height (int): ");
            height = scan.nextInt(); 
            System.out.print("Enter population rate (0 < n < 1): ");
            poputationRate = scan.nextDouble(); 
            System.out.print("Enter type of neighbourhood (4 or 8): ");
            int n = scan.nextInt();
            if (n == 4) nb = Neighbourhood.FOUR_N;
            else if (n == 8) nb = Neighbourhood.EIGTH_N;
            else {
                System.out.println("Type of heighbouthood must be 4 or 8.");
                System.out.println("Using default type.");
                nb = Neighbourhood.FOUR_N;
            }
            System.out.print("Enter speed (ms): ");
            speed = scan.nextInt();
            simul = new Simulation(width, height, poputationRate, nb);
        }
        else {
            System.out.println("Yolo, retry plz");
            return;
        }
        System.out.println("pop rate = " + simul.getPopulationRate());
        System.out.println("width = " + simul.getField().getWidth());
        System.out.println("height = " + simul.getField().getHeight());
        // fill the field of simul
        simul.fillField(simul.getPopulationRate());
        simul.run(speed);
    }
}