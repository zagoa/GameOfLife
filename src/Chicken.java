package oop.flu;

public class Chicken extends Birds{

	public Chicken(State state) {
		super(Type.CHICKEN,state);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		String screen;
        String type="",state="",disease ="";
        type = "Ch";
        switch (this.stateEnum) {
            case SICK:
                state = "S";
                break;
            case HEALTHY:
                state = "H";
                break;
            case CONTAGIOUS:
                state = "C";
                break;
            case RECOVERING:
                state = "R";
                break;
            case DEAD:
                state = "D";
                break;
            case IMUN:
                state = "I";
                break;
        }
        switch(this.diseaseEnum) {
            case NONE:
                disease = "NO";
                break;
            case H5N1:
                disease = "H5";
                break;
        }

        screen = ""+type+" "+state+" "+disease;
        return screen;
	}
}
