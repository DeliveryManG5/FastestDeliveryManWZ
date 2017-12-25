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
public class Delivery {
    String deliverymanID;
    String deliverymanName;
    String OrderID;

    public Delivery() {
    }

    public Delivery(String deliverymanID, String deliverymanName, String OrderID) {
        this.deliverymanID = deliverymanID;
        this.deliverymanName = deliverymanName;
        this.OrderID = OrderID;
    }

    public String getDeliverymanID() {
        return deliverymanID;
    }

    public String getDeliverymanName() {
        return deliverymanName;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setDeliverymanID(String deliverymanID) {
        this.deliverymanID = deliverymanID;
    }

    public void setDeliverymanName(String deliverymanName) {
        this.deliverymanName = deliverymanName;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }
    
    
}
