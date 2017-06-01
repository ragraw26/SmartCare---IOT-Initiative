/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Laboratory.LaboratoryTest;
import Business.Laboratory.LaboratoryTestHistory;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Validation.Validation;
import Business.WorkQueue.LabTestWorkRequest;
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
public class DoctorPatientLabRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private LaboratoryTestHistory laboratoryTestHistory;

    /**
     * Creates new form DoctorPatientLabRequestJPanel
     */
    public DoctorPatientLabRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        populateTable();
        populateLabtestRequest();
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

    public void populateLabtestRequest() {
        DefaultTableModel dtm = (DefaultTableModel) tblLabTest.getModel();
        dtm.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {
                for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
                    if (txtName1.getText().equals(patient.getPatientName())) {
                        laboratoryTestHistory = patient.getLaboratoryTestHistory();
                        for (LaboratoryTest laboratoryTest : laboratoryTestHistory.getLaboratoryTestHistory()) {
                            if (laboratoryTest.getPatientLabTest().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No Medication is added for this patient", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                Object[] r = new Object[6];
                                r[0] = patient.getPatientId();
                                r[1] = laboratoryTest.getPatientLabTest();
                                Date date = new Date();
                                r[2] = date;
                                dtm.addRow(r);
                            }
                        }
                    }
                }
            }
        }
    }

    public void refreshTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblLabTest.getModel();
        dtm.setRowCount(0);
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {
                for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
                    if (txtName1.getText().equals(patient.getPatientName())) {
                        laboratoryTestHistory = patient.getLaboratoryTestHistory();
                        for (LaboratoryTest laboratoryTest : laboratoryTestHistory.getLaboratoryTestHistory()) {
                            if (laboratoryTest.getPatientLabTest().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No Medication is added for this patient", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                Object[] r = new Object[6];
                                r[0] = patient.getPatientId();
                                r[1] = laboratoryTest.getPatientLabTest();
                                Date date = new Date();
                                r[2] = date;
                                dtm.addRow(r);
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
        tblLabTest = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLabRequest = new javax.swing.JTextArea();
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

        txtName1.setEditable(false);
        txtName1.setEnabled(false);
        txtName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Patient ID");
        jLabel14.setToolTipText("");

        txtPatientID.setEditable(false);
        txtPatientID.setEnabled(false);

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
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tblLabTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient ID", "Lab Test Request", "Requested Date"
            }
        ));
        jScrollPane1.setViewportView(tblLabTest);

        txtLabRequest.setColumns(20);
        txtLabRequest.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtLabRequest.setRows(5);
        txtLabRequest.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLabRequestFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(txtLabRequest);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Request Lab Test");

        btnViewDetails.setBackground(new java.awt.Color(1, 126, 1));
        btnViewDetails.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnViewDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDetails.setText("Add Request");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnViewDetails)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetails)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAppointmentMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblAppointment.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to process", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            txtPatientID.setText((String) tblAppointment.getValueAt(selectedRow, 0).toString());
            txtName1.setText((String) tblAppointment.getValueAt(selectedRow, 1).toString());
            populateLabtestRequest();
        }
    }//GEN-LAST:event_tblAppointmentMouseClicked

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1ActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        if (!Validation.isEmpty(txtLabRequest)) {
            JOptionPane.showMessageDialog(null, "Please add test to be performed", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String patientID = txtPatientID.getText();
            String patientName = txtName1.getText();
            String patientMed = txtLabRequest.getText();

            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof PatientOrganization) {
                    for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
                        if (txtName1.getText().equals(patient.getPatientName())) {
                            LaboratoryTest laboratoryTest = patient.getLaboratoryTestHistory().addLabTest();
                            laboratoryTest.setPatientLabTest(patientMed);
                        }
                    }
                }
            }
            populateLabtestRequest();
            refreshTable();

        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblLabTest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select request to process", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            LabTestWorkRequest request = new LabTestWorkRequest();
            String pID = txtPatientID.getText();
            String pName = txtName1.getText();
            String pLabest = ((String) tblLabTest.getValueAt(selectedRow, 1).toString());

            request.setPatientID(pID);
            request.setPatientName(pName);
            request.setPatientLabTestReq(pLabest);
            request.setSender(userAccount);
            request.setStatus("Sent");
            Date date = new Date();
            request.setRequestDate(date);

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof LabOrganization) {
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

    private void txtLabRequestFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLabRequestFocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLostTextArea(evt);
    }//GEN-LAST:event_txtLabRequestFocusLost

    public void refreshfields() {
        txtLabRequest.setText("");
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
    private javax.swing.JTable tblLabTest;
    private javax.swing.JTextArea txtLabRequest;
    public javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtPatientID;
    // End of variables declaration//GEN-END:variables
}
