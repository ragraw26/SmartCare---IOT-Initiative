/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SpecialCareOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.SpecialCareRole.SpecialCareWorkAreaJPanel;

/**
 *
 * @author Rajat
 */
public class SpecialCareRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
          return new SpecialCareWorkAreaJPanel(userProcessContainer, account, (SpecialCareOrganization)organization, enterprise);
    }
    
     @Override
    public String toString() {
        return "Special Care Team"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
