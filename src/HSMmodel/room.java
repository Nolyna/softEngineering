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
public class room {
    private int roomNum;
    private int numGuests;
    private boolean reminderNeeded;
    private Date checkOut;
    private String specialRequest;

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public boolean isReminderNeeded() {
        return reminderNeeded;
    }

    public void setReminderNeeded(boolean reminderNeeded) {
        this.reminderNeeded = reminderNeeded;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
    
    
}
