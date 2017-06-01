/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medication;

/**
 *
 * @author Rajat
 */
public class Medication {

    private String medCategory;
    private String medName;
    private int numberofDays;
    private int quantity;
    private String medInstruction;
    private String medAdvice;
    private String medSummary;

    public String getMedCategory() {
        return medCategory;
    }

    public void setMedCategory(String medCategory) {
        this.medCategory = medCategory;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public int getNumberofDays() {
        return numberofDays;
    }

    public void setNumberofDays(int numberofDays) {
        this.numberofDays = numberofDays;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedInstruction() {
        return medInstruction;
    }

    public void setMedInstruction(String medInstruction) {
        this.medInstruction = medInstruction;
    }

    public String getMedAdvice() {
        return medAdvice;
    }

    public void setMedAdvice(String medAdvice) {
        this.medAdvice = medAdvice;
    }

    public String getMedSummary() {
        return medSummary;
    }

    public void setMedSummary(String medSummary) {
        this.medSummary = medSummary;
    }

}
