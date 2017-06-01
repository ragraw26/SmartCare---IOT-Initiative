package neu.edu.UserInterface;

import java.net.InetAddress;
import javax.swing.*;

//Class to precise who is connected : Client or Server
public class ClientServer {

    public static void main(String[] args) {

        Object[] selectioValues = {"Server", "Patient", "Doctor", "Nurse"};
        String initialSection = "Server";
        String IPServer = "localhost";//InetAddress.getLocalHost().toString();
        String[] arguments = new String[]{IPServer};
        Object selection = JOptionPane.showInputDialog(null, "Login as : ", "MyChatApp", JOptionPane.QUESTION_MESSAGE, null, selectioValues, initialSection);
        if (selection.equals("Server")) {
             arguments = new String[]{};
            new MultiThreadChatServerSync().main(arguments);
        } else if (selection.equals("Patient")) {
            //String IPServer = JOptionPane.showInputDialog("Enter the Server ip adress");
            //String[] arguments = new String[]{IPServer};
            new ChatClient().main(arguments);
        } else if (selection.equals("Doctor")) {
            //String IPServer = JOptionPane.showInputDialog("Enter the Server ip adress");
            //String[] arguments = new String[]{IPServer};
            new ChatClient().main(arguments);
        } else if (selection.equals("Nurse")) {
            //String IPServer = JOptionPane.showInputDialog("Enter the Server ip adress");
            //String[] arguments = new String[]{IPServer};
            new ChatClient().main(arguments);
        }

    }

}
