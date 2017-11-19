/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HSMmodel;

import java.util.Date;

/**
 *
 * @author soumb
 * @author C. Joseph
 */
public class amenities {

    String amenityType;
    Date reserveDate;
    double totalCharge;
    int numHours;

    public amenities(String type, Date date, double total, int hours) {
        amenityType = type;
        reserveDate = date;
        totalCharge = total;
        numHours = hours;
    }

    public String getamenityType() {
        return amenityType;
    }

    public Date getreserveDate() {
        return reserveDate;
    }

    public double gettotalCharge() {
        return totalCharge;
    }

    public int getnumHours() {
        return numHours;
    }

    public void setamenityType(String x) {
        amenityType = x;
    }

    public void setreserveDate(Date x) {
        reserveDate = x;
    }

    public void settotalCharge(double x) {
        totalCharge = x;
    }

    public void setnumHours(int x) {
        numHours = x;
    }
}
