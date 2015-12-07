package oop.flu;
/**
 * Created by Arnaud on 29/11/2015.
 */
public class Area {
    private int width;
    private int height;
    private LivingBeing[][] population;
    private int ratio;
    private boolean areDead;

    public Area(int width, int height, int time) { // prend en paramètre la taille
        this.height = height;
        this.width = width;
        this.population = new LivingBeing[this.width][this.height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                population[j][i] = new Humans(State.HEALTHY, Disease.NONE , 0);
            }

        }
        Infection(time);


    }

    public void Infection(int time) {
        int nbRandH = (int) (Math.random() * (height));
        int nbRandW = (int) (Math.random() * (width));


        System.out.println("Epidémie lancé depuis la colonne: " + nbRandW + " et la ligne: " + nbRandH);
        LivingBeing peopleIll = population[nbRandW][nbRandH];
        peopleIll.setInfected(true);
        new Infections(peopleIll);


        for (int h = 0; h < time; h++) {

            for (int i = 0; i < (this.height); i++) {
                for (int j = 0; j < (this.width); j++) {
                    LivingBeing people = population[j][i];

                    if (people.isInfected() && people.getState()==State.CONTAGIOUS) {

                        try { //infecte la case du dessus
                            ratio = (int) (Math.random() * ((100 - 0)));
                            if ((ratio >= 75) && (population[i - 1][j].isDead() == false) && (population[i - 1][j].isInfected() == false)) {
                                population[i - 1][j].setInfected(true);
                                new Infections(population[i - 1][j]);
                            }


                        } catch (Exception e) {
                        }
                        try {//infecte la case du dessous
                            ratio = (int) (Math.random() * ((100 - 0)));
                            if ((ratio >= 75) && (population[i + 1][j].isDead() == false) && (population[i + 1][j].isInfected() == false)) {
                                population[i + 1][j].setInfected(true);
                                new Infections(population[i + 1][j]);
                                population[i + 1][j].setNew(true);
                            }

                        } catch (Exception e) {
                        }
                        try {//infecte la case à droite
                            ratio = (int) (Math.random() * ((100 - 0)));
                            if ((ratio >= 75) && (population[i][j + 1].isDead() == false) && (population[i][j + 1].isInfected() == false)) {
                                population[i][j + 1].setInfected(true);
                                new Infections(population[i][j + 1]);
                                population[i][j + 1].setNew(true);

                            }

                        } catch (Exception e) {
                        }
                        try {//infecte la case à gauche
                            ratio = (int) (Math.random() * (100));
                            if ((ratio >= 75) && (population[i][j - 1].isDead() == false) && (population[i][j - 1].isInfected() == false)) {
                                population[i][j - 1].setInfected(true);
                                new Infections(population[i][j - 1]);

                            }

                        } catch (Exception e) {
                        }
                        try {//infecte la case coin haut gauche
                            ratio = (int) (Math.random() * ((100 - 0)));
                            if ((ratio >= 90) && (population[i - 1][j - 1].isDead() == false) && (population[i - 1][j - 1].isInfected() == false)) {
                                population[i - 1][j - 1].setInfected(true);
                                new Infections(population[i - 1][j - 1]);


                            }
                        } catch (Exception e) {
                        }
                        try {//infecte la case coin bas gauche
                            ratio = (int) (Math.random() * (100));
                            if ((ratio >= 90) && (population[i + 1][j - 1].isDead() == false) && (population[i + 1][j - 1].isInfected() == false)) {
                                population[i + 1][j - 1].setInfected(true);
                                new Infections(population[i + 1][j - 1]);
                                population[i + 1][j - 1].setNew(true);

                            }
                        } catch (Exception e) {
                        }
                        try {//infecte la case coin bas droit
                            ratio = (int) (Math.random() * ((100 - 0)));
                            if ((ratio >= 90) && (population[i + 1][j + 1].isDead() == false) && (population[i + 1][j + 1].isInfected()) == false) {
                                population[i + 1][j + 1].setInfected(true);
                                new Infections(population[i + 1][j + 1]);
                                population[i + 1][j + 1].setNew(true);

                            }
                        } catch (Exception e) {
                        }
                        try {//infecte la case coin haut droit
                            ratio = (int) (Math.random() * ((100 - 0)));
                            if ((ratio >= 90) && (population[i - 1][j + 1].isDead() == false) && (population[i - 1][j + 1].isInfected() == false)) {
                                population[i - 1][j + 1].setInfected(true);
                                new Infections(population[i - 1][j + 1]);
                            }
                        } catch (Exception e) {
                        }


                    } else if (people.isInfected()) {
                        new Infections(people);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String screen = "";
        for (int i = 0; i < this.height; i++) {

            screen += "\n";
            screen += "|";
            for (int j = 0; j < this.height; j++) {
                screen += population[i][j].toString();
                if (j + 1 == this.width) screen += "|";
                else screen += " || ";

            }
        }


        return screen;

    }
    public boolean areDead() {
        areDead = false;
        for (int i = 0; i <this.height; i++) {
            for (int j = 0; j <this.width; j++) {
                if (!population[i][j].isDead()) {
                    //System.out.println("World is not dead");
                    return areDead;
                }
            }
        }
        //System.out.println("World is dead muahahahaha");
        areDead = true;
        return areDead;
    }


    public LivingBeing[][] getPopulation() {
        return population;
    }

}
