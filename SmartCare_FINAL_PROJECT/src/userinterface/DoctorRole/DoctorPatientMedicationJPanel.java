/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.Medication.Medication;
import Business.Medication.MedicationHistory;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.ReceptionistOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Validation.Validation;
import Business.WorkQueue.NurseTestWorkRequest;
import Business.WorkQueue.ReceptionistTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.DoctorRole.DoctorPatientSearchJPanel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rajat
 */
public class DoctorPatientMedicationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private MedicationHistory medcationHistory;

    /**
     * Creates new form DoctorPatientMedicationJPanel
     */
    public DoctorPatientMedicationJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        populateTable();
        populateMedicineTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblAppointment.getModel();
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof ReceptionistTestWorkRequest) {
                try {
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date today = new Date();
                    Date todayDay = formatter.parse(formatter.format(today));
                    Date appTime = formatter.parse(formatter.format(request.getFinalAppointment()));

                    if (appTime.equals(todayDay)) {
                        Object[] row = new Object[6];
                        row[0] = request;
                        row[1] = request.getPatientName();
                        row[2] = request.getDocName();
                        row[3] = request.getAppointmentDate();
                        row[4] = request.getAppointmentTime();
                        row[5] = ((ReceptionistTestWorkRequest) request).getAppStatus();
                        model.addRow(row);
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(DoctorPatientSearchJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void populateMedicineTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblMedicine.getModel();
        dtm.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {
                for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
                    if (txtName1.getText().equals(patient.getPatientName())) {
                        medcationHistory = patient.getMedicationHistory();
                        for (Medication medication : medcationHistory.getMedicationHistory()) {
                            if (medcationHistory.getMedicationHistory().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No Medication is added for this patient");
                            } else {
                                if (medication.getMedSummary() != null) {
                                    Object[] r = new Object[6];
                                    Date date = new Date();
                                    r[0] = patient.getPatientId();
                                    r[1] = medication.getMedSummary();
                                    r[2] = date;
                                    dtm.addRow(r);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void refreshTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblMedicine.getModel();
        dtm.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {
                for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
                    if (txtName1.getText().equals(patient.getPatientName())) {
                        medcationHistory = patient.getMedicationHistory();
                        for (Medication medication : medcationHistory.getMedicationHistory()) {
                            if (medcationHistory.getMedicationHistory().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No Medication is added for this patient");
                            } else {
                                if (medication.getMedSummary() != null) {
                                    Object[] r = new Object[6];
                                    Date date = new Date();
                                    r[0] = patient.getPatientId();
                                    r[1] = medication.getMedSummary();
                                    r[2] = date;
                                    dtm.addRow(r);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPatientID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicine = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMed = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnViewDetails = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PaitentID", "Patient Name", "Doctor Name", "AppointmentDate ", "Appointment Time", "Status"
            }
        ));
        tblAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAppointmentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAppointment);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Name");

        txtName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Patient ID");
        jLabel14.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtName1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txtPatientID, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Medication", "Requested Date"
            }
        ));
        jScrollPane1.setViewportView(tblMedicine);

        txtMed.setColumns(20);
        txtMed.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtMed.setRows(5);
        txtMed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMedFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(txtMed);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Add Medicines");

        btnViewDetails.setBackground(new java.awt.Color(1, 126, 1));
        btnViewDetails.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnViewDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDetails.setText("Add Medicines");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(1, 126, 1));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Process Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnViewDetails)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1)
                                .addGap(22, 22, 22)))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetails)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAppointmentMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblAppointment.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first");
        } else {
            txtPatientID.setText((String) tblAppointment.getValueAt(selectedRow, 0).toString());
            txtName1.setText((String) tblAppointment.getValueAt(selectedRow, 1).toString());
            populateMedicineTable();
        }
    }//GEN-LAST:event_tblAppointmentMouseClicked

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1ActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAppointment.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first");
            return;
        }
        if (!Validation.isEmpty(txtMed)) {
            JOptionPane.showMessageDialog(null, "Please add Medicine to be  prescribed", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String patientID = txtPatientID.getText();
            String patientName = txtName1.getText();
            String patientMed = txtMed.getText();

            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof PatientOrganization) {
                    for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
                        if (txtName1.getText().equals(patient.getPatientName())) {
                            Medication medication = patient.getMedicationHistory().addMedication();
                            medication.setMedSummary(patientMed);
                        }
                    }
                }
            }
        }

        populateMedicineTable();
        refreshTable();


    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblMedicine.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select request to process", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            NurseTestWorkRequest request = new NurseTestWorkRequest();
            String pID = txtPatientID.getText();
            String pName = txtName1.getText();
            String pMedicine = ((String) tblMedicine.getValueAt(selectedRow, 1).toString());
            request.setPatientID(pID);
            request.setPatientName(pName);
            request.setPatientMedication(pMedicine);
            request.setSender(userAccount);
            request.setStatus(" Prescribe Medicines");
            request.setTestResult("Patient Served");
            Date date = new Date();
            request.setRequestDate(date);

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof NurseOrganization) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(request);
                for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                    ua.getWorkQueue().getWorkRequestList().add(request);
                }
            }
            JOptionPane.showMessageDialog(null, "Message Processed Successfully");
            refreshfields();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedFocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLostTextArea(evt);
    }//GEN-LAST:event_txtMedFocusLost

    public void refreshfields() {
        txtMed.setText("");
        txtName1.setText("");
        txtPatientID.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblMedicine;
    private javax.swing.JTextArea txtMed;
    public javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtPatientID;
    // End of variables declaration//GEN-END:variables
}
