/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Billing.Billing;
import Business.Medication.Medication;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Rajat
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    //For patient Appoitment
    private String patientID;
    private String patientName;
    private String DocName;
    private Date appointmentDate;
    private String appointmentTime;
    private Date finalAppointment;

    //Special Care Team
    private String specialCarePerson;

    //Nurse - Medication Request
    private Medication medication;
    private String patientMedication;

    //Lab - Test Request
    private String patientLabTestReq;
    
    //Billing
    private Billing billing;
    

    public WorkRequest() {
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String DocName) {
        this.DocName = DocName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSpecialCarePerson() {
        return specialCarePerson;
    }

    public void setSpecialCarePerson(String specialCarePerson) {
        this.specialCarePerson = specialCarePerson;
    }

    public String getPatientMedication() {
        return patientMedication;
    }

    public void setPatientMedication(String patientMedication) {
        this.patientMedication = patientMedication;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getPatientLabTestReq() {
        return patientLabTestReq;
    }

    public void setPatientLabTestReq(String patientLabTestReq) {
        this.patientLabTestReq = patientLabTestReq;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    } 

    public Date getFinalAppointment() {
        return finalAppointment;
    }

    public void setFinalAppointment(Date finalAppointment) {
        this.finalAppointment = finalAppointment;
    }  
    

    @Override
    public String toString() {
        return  this.patientID;
    }
    

}
