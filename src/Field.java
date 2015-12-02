package oop.flu;

public class Field {
	// The depth and width of the field.
    private int height, width;

    // Storage for population
    private LivingBeing[][] field;

    private boolean areDead;
    private boolean areHealthy;

/**
* contructor
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
* @param lb to be placed
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
* @return bool checking if all living being on the field are dead
*/
    public boolean areAllDead() {
    	this.areDead = false;
    	for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++) {
                if (!field[i][j].isDead()) {
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
* @return bool checking if all living beings are healthy on the field
*/
	public boolean areAllHealthy() {
		this.areHealthy = false;
		for (int j = 0; j < this.height; j++) {
			for (int i = 0; i < this.width; i++) {
				if (!field[width][height].isHealthy()) {
					return areHealthy;
				}
			}
		}
		areHealthy = true;
		return areHealthy;
	}
    
    @Override
    public String toString() {
        String screen = "";
        for (int i = 0; i < this.height; i++) {

            screen += "\n";
            screen += "|";
            for (int j = 0; j < this.height; j++) {
                if (field[i][j] == null) screen += " NULL ";
                else screen += field[i][j].toString();
                if (j + 1 == this.width) screen += "|";
                else screen += " || ";
            }
        }
        return screen;
    }
}