/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rajat
 */
public class PatientDirectory {
    
    private ArrayList<Patient> patientDirectory;

    public PatientDirectory() {
        patientDirectory = new ArrayList<>();

    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }

      public Patient addPatient(String Id,String name,Date DOB,int age,String email, String contact) {
        Patient patient = new Patient();
        patient.setPatientId(Id);
        patient.setPatientName(name);
        patient.setPatientDOB(DOB);
        patient.setAge(age);
        patient.seteMail(email);
        patient.setContactNo(contact);
        patientDirectory.add(patient);
        return patient;
    }
 
    public void deletePatient(Patient patient) {
        patientDirectory.remove(patient);
    }

    public Patient searchPatientByPatientID(String PID) {
        for (Patient patient : patientDirectory) {
            if (patient.getPatientId().equals(PID)) {
                return patient;
            }
        }
        return null;

    }
    
}
