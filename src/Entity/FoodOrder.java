/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
/**
 *
 * @author BryanLee
 */
public class FoodOrder {
    String foodName;
    double foodPrice;
    int qty, orderID;
    double totalPrice;
    String deliveryManID;
    
    public FoodOrder(){ }
    
    public FoodOrder(int orderID, String foodName, double foodPrice, int qty, double totalPrice, String deliveryManID){
        this.orderID = orderID;  
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.deliveryManID = deliveryManID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public int getQty() {
        return qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    public String getDeliveryManID() {
        return deliveryManID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void setDeliveryManID(String deliveryManID){
        this.deliveryManID = deliveryManID;
    }
}
