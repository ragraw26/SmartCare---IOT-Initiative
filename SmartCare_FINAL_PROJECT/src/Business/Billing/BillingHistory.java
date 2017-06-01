/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Billing;

import java.util.ArrayList;

/**
 *
 * @author Rajat
 */
public class BillingHistory {

    private ArrayList<Billing> billingHistory;

    public BillingHistory() {

        this.billingHistory = new ArrayList<>();
    }

    public ArrayList<Billing> getBillingHistory() {
        return billingHistory;
    }

    public void setBillingHistory(ArrayList<Billing> billingHistory) {
        this.billingHistory = billingHistory;
    }

    public Billing addBilling() {

        Billing bill = new Billing();
        billingHistory.add(bill);
        return bill;
    }

    public void removeBill(Billing bill) {
        billingHistory.remove(bill);
    }

}
