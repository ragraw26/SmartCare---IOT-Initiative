/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Laboratory;

import java.util.ArrayList;

/**
 *
 * @author Rajat
 */
public class LaboratoryTestHistory {

    private ArrayList<LaboratoryTest> laboratoryTestHistory;

    public LaboratoryTestHistory() {
        this.laboratoryTestHistory = new ArrayList<>();
    }

    public ArrayList<LaboratoryTest> getLaboratoryTestHistory() {
        return laboratoryTestHistory;
    }

    public void setLaboratoryTestHistory(ArrayList<LaboratoryTest> laboratoryTestHistory) {
        this.laboratoryTestHistory = laboratoryTestHistory;
    }

    public LaboratoryTest addLabTest() {

        LaboratoryTest laboratoryTest = new LaboratoryTest();
        laboratoryTestHistory.add(laboratoryTest);
        return laboratoryTest;
    }

    public void removeLabTesr(LaboratoryTest laboratoryTest) {

        laboratoryTestHistory.remove(laboratoryTest);
    }
}
