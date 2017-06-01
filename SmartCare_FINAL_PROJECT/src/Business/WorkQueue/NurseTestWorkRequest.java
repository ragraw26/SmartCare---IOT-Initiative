/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.Patient;

/**
 *
 * @author Rajat
 */
public class NurseTestWorkRequest extends WorkRequest{
    
    private String TestResult;
    private Patient patient;

    public String getTestResult() {
        return TestResult;
    }

    public void setTestResult(String TestResult) {
        this.TestResult = TestResult;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    
}
