package oop.flu;

/**
* A class representing disease
* @author Baisangour Akhmadov
* @version 2015.12.13
*/
public class Disease {
    public DiseaseEnum diseaseName;
    public int contagiousTime;
    public int recoveryTime;
    public int deathRate;

    /**
    * constructor setting default contagious time, recovery time and death rate
    * @param disease Specific disease
    */
    public Disease(DiseaseEnum disease){
        diseaseName = disease;
        if(disease == DiseaseEnum.H1N1){
            contagiousTime = 2;
            recoveryTime = 5;
            deathRate = 70;
        }
        else if(disease == DiseaseEnum.H5N1){
            contagiousTime = 4;
            recoveryTime = 10;
            deathRate = 90;
        }
    }

    /** 
    * @return death rate 
    */
    public int getDeathRate(){ return deathRate; }

    /** 
    * @return contagious time 
    */
    public int getContagiousTime(){ return contagiousTime; }

    /** 
    * @return recovery time 
    */
    public int getRecoveryTime(){ return recoveryTime; }

    /** 
    * @return disease name 
    */
    public DiseaseEnum getName(){ return diseaseName; }
}
