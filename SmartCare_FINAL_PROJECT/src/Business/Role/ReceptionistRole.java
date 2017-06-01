 /*    
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import UserInterface.ReceptionistRole.ReceptionistPatientAppJPanel;
import javax.swing.JPanel;
import userinterface.ReceptionistRole.ReceptionistWorkAreaJPanel;

/**
 *
 * @author Rajat
 */
public class ReceptionistRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel pnl, UserAccount ua, Organization o, Enterprise e, EcoSystem es) {
        return new ReceptionistWorkAreaJPanel(pnl, ua, (ReceptionistOrganization)o, e , es);
    }
        
    @Override
    public String toString() {
        return "Receptionist";
    }
    
    
}
