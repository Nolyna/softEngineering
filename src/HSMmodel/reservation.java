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
 */
public class reservation {
    private Date startDate;
    private Date endDate;
    private double estimate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getEstimate() {
        return estimate;
    }

    public void setEstimate(double estimate) {
        this.estimate = estimate;
    }
    
    
}
