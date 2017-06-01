package Business.Validation;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rajat
 */
public class Validation {

    public static void isEmptyFieldOnFocusLost(java.awt.event.FocusEvent evt) {
        //boolean flag =false;
        JTextField jt = (JTextField) evt.getSource();
        if (jt.getText().equals("")) {
            jt.setText("");
            jt.setBackground(Color.yellow);
            //flag = false;
        } else {
            jt.setBackground(Color.white);
            //flag = true;

        }
    }

    public static void isEmptyFieldOnFocusLostTextArea(java.awt.event.FocusEvent evt) {
        //boolean flag =false;
        JTextArea jt = (JTextArea) evt.getSource();
        if (jt.getText().equals("")) {
            jt.setText("");
            jt.setBackground(Color.yellow);
            //flag = false;
        } else {
            jt.setBackground(Color.white);
            //flag = true;

        }
    }

    public static void restrictNumericinTxtFields(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        JTextField jt = (JTextField) evt.getSource();
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE))) {
            //getToolkit().beep();
            jt.setText("");
            jt.setBackground(Color.yellow);
            evt.consume();
        } else {
            jt.setBackground(Color.white);
        }
    }

    public static boolean isEmpty(JTextField jTextField) {
        boolean flag = true;
        if (jTextField.getText().trim().equalsIgnoreCase("") || jTextField.getText().length() == 0) {
            flag = false;
        }
        return flag;
    }

    public static boolean isEmpty(JPasswordField jPasswordField) {
        boolean flag = true;
        if (jPasswordField.getPassword().length == 0) {
            flag = false;
        }
        return flag;
    }

    public static boolean isEmpty(JTextArea jTextArea) {
        boolean flag = true;
        if (jTextArea.getText().trim().equalsIgnoreCase("") || jTextArea.getText().length() == 0) {
            flag = false;
        }
        return flag;
    }

    public static void restrictAlphabetinTxtFields(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        JTextField jt = (JTextField) evt.getSource();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z')
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_PERIOD))) {
            jt.setText("");
            jt.setBackground(Color.yellow);
            evt.consume();
        } else {
            jt.setBackground(Color.white);
        }
    }

    public static void restrictUserinTxtFields(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        JTextField jt = (JTextField) evt.getSource();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z')
                || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD))) {
            jt.setText("");
            jt.setBackground(Color.yellow);
            evt.consume();
        } else {
            jt.setBackground(Color.white);
        }
    }

    public static boolean EmailAddressValidator(String email) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
