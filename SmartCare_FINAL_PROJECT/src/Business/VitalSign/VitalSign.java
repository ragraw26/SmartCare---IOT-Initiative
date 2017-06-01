/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSign;

import java.util.Date;

/**
 *
 * @author Rajat
 */
public class VitalSign {

    private int respRate;
    private int heartRate;
    private int sysbloodPressure;
    private int Weight;
    private Date timestamp;

    public int getRespRate() {
        return respRate;
    }

    public void setRespRate(int respRate) {
        this.respRate = respRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSysbloodPressure() {
        return sysbloodPressure;
    }

    public void setSysbloodPressure(int sysbloodPressure) {
        this.sysbloodPressure = sysbloodPressure;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return timestamp + "";
    }

}
