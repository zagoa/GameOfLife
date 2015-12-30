package oop.flu;

/**
 * A class describing a field of simulation
 *
 * @author Liavona Zheltanosava
 * @author Arnaud Zago (isFinish())
 * @version 2015.12.07
 */
public class Field {
    // The depth and width of the field.
    private int height, width;

    // Storage for population
    private LivingBeing[][] field;

    // indicators of wether everyone is dead or alive
    private boolean finish;


    /**
     * default contructor
     *
     * @param height height of the field
     * @param width  width of the field
     */
    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        field = new LivingBeing[height][width];
    }

    /**
     * empty field
     */
    public void emptyField() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = null;
            }
        }
    }

    /**
     * remove LB from field[width][height]
     *
     * @param width  where to remove LB from
     * @param height where to remove LB from
     */
    public void remove(int height, int width) {
        field[height][width] = null;
    }

    /**
     * @param lb     to be placed
     * @param width  where to place LB
     * @param height where to place LB
     */
    public void place(LivingBeing lb, int height, int width) {
        field[height][width] = lb;
    }

    /**
     * @return LivingBeing in case [height][width]
     */
    public LivingBeing getLivingBeing(int height, int width) {
        return field[height][width];
    }

    /**
     * @return width of the field
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height of the field
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return wether all LB on the field are dead
     */
    public boolean isFinished() {
        this.finish = false;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                // if there is someone and he is Sick or Contagious the simulation isn't over yet
                if ((field[i][j] != null) && ((field[i][j].getState() == State.SICK) || (field[i][j].getState() == State.CONTAGIOUS))) {
                    return finish;
                }
            }
        }
        this.finish = true;
        System.out.println("THIS IS THE END");
        return finish;
    }


    // TODO : comments
    public Object getObjectAt(int row, int col) {
        return field[row][col];
    }

}