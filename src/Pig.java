package oop.flu;

public class Pig extends Animals{
	public Pig(State state, Disease disease){
		super(Type.PIG,state,disease);
	}
	
	public String toString(){
		String screen;
        String type="",state="",disease ="";
        type = "Pi";
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
            case H1N1:
                disease = "H1";
                break;
            case H5N1:
                disease = "H5";
                break;
        }

        screen = ""+type+" "+state+" "+disease;
        return screen;
	}
}
