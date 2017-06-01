/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Billing.BillingHistory;
import Business.Laboratory.LaboratoryTest;
import Business.Laboratory.LaboratoryTestHistory;
import Business.Medication.MedicationHistory;
import Business.Organization.Organization;
import Business.VitalSign.VitalSignHistory;
import java.util.Date;

/**
 *
 * @author Rajat
 */
public class Patient {

    private String patientId;
    private String patientName;
    private Date patientDOB;
    private int Age;
    private String eMail;
    private String contactNo;
    private VitalSignHistory vitalSignHistory;
    private MedicationHistory medicationHistory;
    private LaboratoryTestHistory laboratoryTestHistory;
    private BillingHistory billingHistory;
    
    public Patient() {
        this.vitalSignHistory = new VitalSignHistory();
        this.medicationHistory = new MedicationHistory();
        this.laboratoryTestHistory = new LaboratoryTestHistory();
        this.billingHistory = new BillingHistory();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(Date patientDOB) {
        this.patientDOB = patientDOB;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public MedicationHistory getMedicationHistory() {
        return medicationHistory;
    }

    public void setMedicationHistory(MedicationHistory medicationHistory) {
        this.medicationHistory = medicationHistory;
    } 

    public LaboratoryTestHistory getLaboratoryTestHistory() {
        return laboratoryTestHistory;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }    

    public void setLaboratoryTestHistory(LaboratoryTestHistory laboratoryTestHistory) {
        this.laboratoryTestHistory = laboratoryTestHistory;
    }

    public BillingHistory getBillingHistory() {
        return billingHistory;
    }

    public void setBillingHistory(BillingHistory billingHistory) {
        this.billingHistory = billingHistory;
    }  
    
    
    @Override
    public String toString() {
        return  patientId;
    }

    
}
