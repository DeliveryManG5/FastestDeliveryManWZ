/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ADmin
 */
public class Deliveryman {
    private String deliveryManID;
    private String deliveryManName;
    private String IC;
    private String contactNum;
    private String emailAddress;
    private String address;
    private String joinDate;
    private String leavingDate;
    private String status;

    public Deliveryman() {
    }

    public Deliveryman(String deliveryManID, String deliveryManName, String IC, String contactNum, String emailAddress, String address, String joinDate, String leavingDate, String status) {
        this.deliveryManID = deliveryManID;
        this.deliveryManName = deliveryManName;
        this.IC = IC;
        this.contactNum = contactNum;
        this.emailAddress = emailAddress;
        this.address = address;
        this.joinDate = joinDate;
        this.leavingDate = leavingDate;
        this.status = status;
    }

    public String getDeliveryManID() {
        return deliveryManID;
    }

    public String getDeliveryManName() {
        return deliveryManName;
    }

    public String getIC() {
        return IC;
    }

    public String getContactNum() {
        return contactNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setDeliveryManID(String deliveryManID) {
        this.deliveryManID = deliveryManID;
    }

    public void setDeliveryManName(String deliveryManName) {
        this.deliveryManName = deliveryManName;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return deliveryManID + "|" + deliveryManName + "|" + IC + "|" + contactNum + "|" + emailAddress + "|" + address + "|" + joinDate + "|" + leavingDate + "|" + status;
    }
    
    
}
