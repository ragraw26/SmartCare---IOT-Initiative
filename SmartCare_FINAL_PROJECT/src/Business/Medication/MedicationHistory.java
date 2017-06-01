/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medication;

import java.util.ArrayList;

/**
 *
 * @author Rajat
 */
public class MedicationHistory {
    
    private ArrayList<Medication> medicationHistory;

    public MedicationHistory() {
        this.medicationHistory = new ArrayList<>();
    }

    public ArrayList<Medication> getMedicationHistory() {
        return medicationHistory;
    }

    public void setMedicationHistory(ArrayList<Medication> medicationHistory) {
        this.medicationHistory = medicationHistory;
    }
    
    public Medication addMedication() {

        Medication medication = new Medication();
        medicationHistory.add(medication);
        return medication;
    }

    public void removeVitalSign(Medication medication) {

        medicationHistory.remove(medication);
    }
         
    
    
    
}
