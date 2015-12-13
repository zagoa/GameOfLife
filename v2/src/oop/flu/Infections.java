package oop.flu;

/**
 * Created by Arnaud on 23/11/2015.
 */
public class Infections {
    private boolean infected;
    private int time;



    public Infections(LivingBeing that) {
        this.time = that.getTime();
        this.infected = that.isInfected();
        Infected(that);

    }

    public void Infected(LivingBeing thing) {
        int nbRand = (int) (Math.random() * ((100)));
        if (thing.isNew() == true){
            thing.setNew(false);
        }
        else if ((this.infected = true)  && (nbRand<20) &&(time>=2) && (time<=5)){
            thing.setDisease(Disease.H1N1);
            thing.setState(State.DEAD);
            thing.setTime(0);
            thing.setInfected(false);
            thing.setDead(true);
        }
        else if (this.infected = true) {

            switch (time) {
                case 0: //passe au stade de SICK
                    thing.setDisease(Disease.H1N1);
                    thing.setState(State.SICK);
                    thing.setTime(time + 1);
                    thing.setInfected(true);
                    break;
                case 1:
                    thing.setTime(time + 1);
                    break;
                case 2: //passe au stade de CONTAGIOUS
                    thing.setDisease(Disease.H1N1);
                    thing.setState(State.CONTAGIOUS);
                    thing.setTime(time + 1);
                    thing.setInfected(true);
                    break;
                case 3:
                    thing.setTime(time + 1);
                    break;
                case 4:
                    thing.setTime(time + 1);
                    break;
                case 5: //passe au stade de RECOVERING
                    thing.setState(State.RECOVERING);
                    thing.setTime(time + 1);
                    thing.setInfected(true);
                    break;
                case 6:
                    thing.setTime(time + 1);
                    break;
                case 7:
                    thing.setTime(time + 1);
                    break;
                case 8:
                    thing.setState(State.IMUN);
                    thing.setDead(true);
                    thing.setInfected(false);
                    break;

            }
        }



    }
}
