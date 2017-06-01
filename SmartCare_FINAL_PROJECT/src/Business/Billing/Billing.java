/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Billing;

import java.util.Date;

/**
 *
 * @author Rajat
 */
public class Billing {

    private String serviceName;
    private Date serviceDate;
    private Float serviceCharge;
    private Date paymentGenerateDate;
    private Date paymentdueDate;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Float getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Float serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Date getPaymentGenerateDate() {
        return paymentGenerateDate;
    }

    public void setPaymentGenerateDate(Date paymentGenerateDate) {
        this.paymentGenerateDate = paymentGenerateDate;
    }

    public Date getPaymentdueDate() {
        return paymentdueDate;
    }

    public void setPaymentdueDate(Date paymentdueDate) {
        this.paymentdueDate = paymentdueDate;
    }
    
    

}