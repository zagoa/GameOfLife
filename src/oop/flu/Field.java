package oop.flu;

/**
* A class describing a field of simulation
* @version 2015.12.07
* @author Liavona Zheltanosava
*/
public class Field {
	// The depth and width of the field.
    private int height, width;

    // Storage for population
    private LivingBeing[][] field;

    // indicators of wether everyone is dead or alive
    private boolean areDead;
    private boolean areHealthy;

/**
* default contructor
* @param height height of the field
* @param width width of the field
*/
    public Field(int height, int width) {
    	this.height = height;
    	this.width = width;
    	field = new LivingBeing[width][height];
    }

/**
* empty field
*/
    public void emptyField() {
    	for (int j = 0; j < height; j++) {
    		for (int i = 0; i < width; i++) {
    			field[i][j] = null;
    		}
    	}
    }
/**
* remove LB from field[width][height]
* @param width where to remove LB from
* @param height where to remove LB from
*/
    public void remove(int width, int height){ field[width][height] = null;}

    /**
* @param LB to be placed
* @param width where to place LB
* @param height where to place LB
*/
    public void place(LivingBeing lb, int width, int height) {
    	field[width][height] = lb;
    }
/**
* @return LivingBeing in case [width][height]
*/
    public LivingBeing getLivingBeing(int width, int height) {
    	return field[width][height];
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
    public boolean areAllDead() {
        this.areDead = false;
        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++){
                // if there is someone and he is not dead
                if ((field[i][j] != null) && (!field[i][j].isDead())) {
                    //System.out.println("World is not dead");
                    return areDead;
                }
            }
        }
        //System.out.println("World is dead muahahahaha");
        areDead = true;
        return areDead;
    }
/**
* @return wether all LB on the field are healthy
*/
	public boolean areAllHealthy() {
        this.areHealthy = false;
        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++) {
                if ((field[i][j] != null) && (!field[i][j].isHealthy())) {
                    return areHealthy;
                }
            }
        }
        areHealthy = true;
        return areHealthy;
    }
    
/**
* toString method
*/
    @Override
    public String toString() {
        String result = "";
        for (int j = 0; j < this.height; j++) {
            result += "\n";
            result += "|| ";
            for (int i = 0; i < this.width; i++) {
                if (field[i][j] == null) result += "  NULL ";
                else result += field[i][j].toString();
                if (i+1 == this.width) result += " ||";
                else result += " | ";
            }
        }
        return result;
    }

// TODO : comments
    public Object getObjectAt(int row, int col) {
        return field[row][col];
    }
    public LivingBeing getCreatureAt(int row, int col) {
        return (LivingBeing)field[row][col];
    }
}