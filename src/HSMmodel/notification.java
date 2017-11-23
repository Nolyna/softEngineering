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
public class notification {
    
    Date notifyDate;

    public Date getnotifyDate() {
        return notifyDate;
    }

    public void setnotifyDate(Date x) {
        notifyDate = x;
    }

    public void setHour(int x) {
        notifyDate.setHours(x);
    }
}
