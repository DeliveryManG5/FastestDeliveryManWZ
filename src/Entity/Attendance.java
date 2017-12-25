
package Entity;

public class Attendance {
    private String deliverymanID;
    private String name;
    private String clockIn;
    private String clockOut;
    private String status;
    private String orderID;
 

    public Attendance() {
    }

    public Attendance(String deliverymanID, String name, String clockIn, String clockOut, String status, String orderID) {
        this.deliverymanID = deliverymanID;
        this.name = name;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.status = status;
        this.orderID = orderID;
    }

    public String getDeliverymanID() {
        return deliverymanID;
    }

    public String getName() {
        return name;
    }

    public String getClockIn() {
        return clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public String getStatus() {
        return status;
    }
    
    public String getOrderID(){
        return orderID;
    }

    public void setDeliverymanID(String deliverymanID) {
        this.deliverymanID = deliverymanID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setOrderID(String orderID){
        this.orderID = orderID;
    }
}
