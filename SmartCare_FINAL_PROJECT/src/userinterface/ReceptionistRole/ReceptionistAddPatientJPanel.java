/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.ReceptionistOrganization;
import Business.Patient.Patient;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.Validation.Validation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.SignUp.PatientSignUpJPanel;

/**
 *
 * @author Rajat
 */
public class ReceptionistAddPatientJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ReceptionistOrganization organization;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Creates new form ReceptionistAddPatientJPanel
     */
    public ReceptionistAddPatientJPanel(JPanel userProcessContainer, UserAccount userAccount, ReceptionistOrganization organization, EcoSystem business, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.userAccount = userAccount;
        jPanel3.setVisible(false);
        popOrganizationComboBox();

    }

    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();
                  for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof PatientOrganization) {
                        organizationJComboBox.addItem(organization);
                    }
                }
    }
    

    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox.removeAllItems();
        for (Patient patient : organization.getPatientDirectory().getPatientDirectory()) {
            if (txtName1.getText().equals(patient.getPatientName())) {
                employeeJComboBox.addItem(patient);
            }
        }
    }

    private void populateRoleComboBox(Organization organization) {
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            roleJComboBox.addItem(role);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmailID1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateofBirth = new org.jdesktop.swingx.JXDatePicker();
        jLabel13 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        orgcmbbox = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        btnSubmit = new javax.swing.JButton();
        txtContactNo = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUserName1 = new javax.swing.JTextField();
        txtPassword1 = new javax.swing.JPasswordField();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPatientID = new javax.swing.JTextField();
        btnsignIn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));
        jPanel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Name");

        txtName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtName1FocusLost(evt);
            }
        });
        txtName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName1ActionPerformed(evt);
            }
        });
        txtName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtName1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Email ID");

        txtEmailID1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailID1FocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Contact No.");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Date OF Birth");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Age");

        txtAge.setEditable(false);
        txtAge.setEnabled(false);

        orgcmbbox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        orgcmbbox.setText("Organization");

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(1, 126, 1));
        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        try {
            txtContactNo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtContactNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactNoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel13))
                                    .addGap(183, 183, 183)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateofBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                        .addComponent(txtEmailID1)
                                        .addComponent(txtName1)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(organizationJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContactNo))))
                            .addGap(316, 316, 316))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(orgcmbbox)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addGap(252, 252, 252))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orgcmbbox)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmailID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dateofBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 580, 306));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("User Name");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Password");

        txtUserName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserName1FocusLost(evt);
            }
        });

        txtPassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassword1FocusLost(evt);
            }
        });

        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Role");

        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Employee");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Patient ID");
        jLabel14.setToolTipText("");

        txtPatientID.setEditable(false);
        txtPatientID.setEnabled(false);

        btnsignIn.setBackground(new java.awt.Color(1, 126, 1));
        btnsignIn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnsignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnsignIn.setText("Sign Up");
        btnsignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsignInMouseClicked(evt);
            }
        });
        btnsignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnsignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 580, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed

    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if (!Validation.isEmpty(txtName1) || !Validation.isEmpty(txtContactNo) || !Validation.isEmpty(txtEmailID1)) {
            JOptionPane.showMessageDialog(null, "Highlighted Fields cannot be kept empty", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Organization organization = (Organization) organizationJComboBox.getSelectedItem();
                txtPatientID.setText("PID" + String.valueOf(Math.round(100000 * Math.random())));
                txtPatientID.setEditable(false);
                String patientID = txtPatientID.getText();
                String name = txtName1.getText();
                Date dateOfBirth = dateofBirth.getDate();
                if (dateOfBirth == null) {
                    JOptionPane.showMessageDialog(null, "Date of birth cannot be empty");
                    return;
                }
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date today = new Date();
                Date todayDay = formatter.parse(formatter.format(today));
                Date doB = formatter.parse(formatter.format(dateOfBirth));
                if (todayDay.equals(doB)) {
                    JOptionPane.showMessageDialog(null, "Date of birth cannot be equal to today's date");
                    return;
                }
                if (dateOfBirth.after(today)) {
                    JOptionPane.showMessageDialog(null, "Date of birth cannot be in future");
                    return;
                } else {
                    int age = getAge(dateOfBirth);
                    txtAge.setText(String.valueOf(age));
                    String email = txtEmailID1.getText();
                    String contact = txtContactNo.getText();
                    organization.getPatientDirectory().addPatient(patientID, name, dateOfBirth, age, email, contact);
                    if (organization != null) {
                        populateEmployeeComboBox(organization);
                        populateRoleComboBox(organization);
                        jPanel3.setVisible(true);
                        btnSubmit.setVisible(false);
                    }

                }
            } catch (ParseException ex) {
                Logger.getLogger(PatientSignUpJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnsignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsignInMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsignInMouseClicked

    private void btnsignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignInActionPerformed
        // TODO add your handling code here:
        if (!Validation.isEmpty(txtUserName1) || !Validation.isEmpty(txtPassword1)) {
            JOptionPane.showMessageDialog(null, "Highlighted Fields cannot be kept empty", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Organization organization = (Organization) organizationJComboBox.getSelectedItem();
            String userName = txtUserName1.getText();
            String password = txtPassword1.getText();
            Patient patient = (Patient) employeeJComboBox.getSelectedItem();
            Role role = (Role) roleJComboBox.getSelectedItem();
            organization.getUserAccountDirectory().createUserAccount(userName, password, null, patient, role);
            JOptionPane.showMessageDialog(null, "User Profie Created Successfully.Please continue to Login");
            resetAll();
        }
        jPanel3.setVisible(false);
        btnSubmit.setVisible(true);

    }//GEN-LAST:event_btnsignInActionPerformed

    private void txtEmailID1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailID1FocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLost(evt);
        String email = txtEmailID1.getText();
        validate(email);
        if (validate(email) == false) {
            JOptionPane.showMessageDialog(null, "Please enter valid E-mail Address");
            txtEmailID1.setText("");
        }
    }//GEN-LAST:event_txtEmailID1FocusLost

    private void txtUserName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserName1FocusLost
        // TODO add your handling code here:
        boolean name = false;

        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (txtUserName1.getText().equals(userAccount.getUsername())) {
                            name = true;
                            break;
                        }

                    }
                }
            }
        }

        if (name == true) {
            JOptionPane.showMessageDialog(null, "UserName already exisits");
            txtUserName1.setText("");
        }

    }//GEN-LAST:event_txtUserName1FocusLost

    private void txtContactNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactNoFocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLost(evt);
        if (txtContactNo.getText().length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter 10 digit Contact Number");
        }
    }//GEN-LAST:event_txtContactNoFocusLost

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1ActionPerformed

    private void txtName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtName1FocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLost(evt);
    }//GEN-LAST:event_txtName1FocusLost

    private void txtPassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword1FocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLost(evt);
    }//GEN-LAST:event_txtPassword1FocusLost

    private void txtName1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtName1KeyTyped
        // TODO add your handling code here:
        Validation.restrictAlphabetinTxtFields(evt);
    }//GEN-LAST:event_txtName1KeyTyped

    public static int getAge(Date dateOfBirth) {

        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        int age = 0;
        birthDate.setTime(dateOfBirth);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }
        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
        if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3)
                || (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
            age--;
            // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
        } else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
                && (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    public void resetAll() {
        txtAge.setText("");
        txtContactNo.setText("");
        txtEmailID1.setText("");
        txtName1.setText("");
        txtUserName1.setText("");
        txtPassword1.setText("");
        txtPatientID.setText("");
        Date date = new Date();
        dateofBirth.setDate(date);
        employeeJComboBox.setSelectedItem("");
        roleJComboBox.setSelectedItem("");
    }

    public boolean validate(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnsignIn;
    private org.jdesktop.swingx.JXDatePicker dateofBirth;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JLabel orgcmbbox;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTextField txtAge;
    private javax.swing.JFormattedTextField txtContactNo;
    public javax.swing.JTextField txtEmailID1;
    public javax.swing.JTextField txtName1;
    public javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtPatientID;
    public javax.swing.JTextField txtUserName1;
    // End of variables declaration//GEN-END:variables
}
