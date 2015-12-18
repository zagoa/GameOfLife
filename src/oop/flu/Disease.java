package oop.flu;

/**
 * Created by Bais on 08/12/2015
 */
public class Disease {
    public DiseaseEnum diseaseName;
    public int contagiousTime;
    public int recoveryTime;
    public int deathRate;

    public Disease(DiseaseEnum disease){
        diseaseName=disease;
        if(disease== DiseaseEnum.H1N1){
            contagiousTime=2;
            recoveryTime=5;
            deathRate=70;
        }
        else if(disease== DiseaseEnum.H5N1){
            contagiousTime=4;
            recoveryTime=10;
            deathRate=90;
        }
    }

    public int getDeathRate(){ return deathRate; }
    public int getContagiousTime(){ return contagiousTime; }
    public int getRecoveryTime(){ return recoveryTime; }
    public DiseaseEnum getName(){ return diseaseName; }
}
