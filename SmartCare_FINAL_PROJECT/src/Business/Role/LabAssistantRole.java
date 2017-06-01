/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Rajat
 */
public class LabAssistantRole extends Role {

    @Override
    public LabAssistantWorkAreaJPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization, enterprise,business);
    }
    
     @Override
    public String toString() {
        return "Lab Assistant"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
