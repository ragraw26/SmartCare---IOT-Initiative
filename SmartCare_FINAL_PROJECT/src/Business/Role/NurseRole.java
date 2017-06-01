/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.NurseRole.NursePatientMedicationWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.NurseRole.NurseWorkAreaJPanel;

/**
 *
 * @author Rajat
 */
public class NurseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel pnl, UserAccount ua, Organization o, Enterprise e, EcoSystem es) {
        return new NurseWorkAreaJPanel(pnl, ua, (NurseOrganization)o, e,es);
    }

    @Override
    public String toString() {
        return "Nurse"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
