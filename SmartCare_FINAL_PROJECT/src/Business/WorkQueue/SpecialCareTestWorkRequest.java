/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Rajat
 */
public class SpecialCareTestWorkRequest extends ReceptionistTestWorkRequest{
    
    private String TestResult;
 
    public String getTestResult() {
        return TestResult;
    }

    public void setTestResult(String TestResult) {
        this.TestResult = TestResult;
    }    
}
