package oop.flu;


/**
 * Created by Arnaud on 29/11/2015.
 */
public class Main {

    public static void main(String[] args) {
        Area world = new Area(6,6,20);
        LivingBeing[][] pop = world.getPopulation();

        System.out.printf(world.toString());


    }
}
