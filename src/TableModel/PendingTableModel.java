
package TableModel;

import ADT.LDeliveryman;
import Entity.Delivery;
//import Entity.Deliveryman;
import Interface.DeliverymanInterface;
import javax.swing.table.AbstractTableModel;

public class PendingTableModel extends AbstractTableModel {
    private DeliverymanInterface<Delivery> contents = new LDeliveryman<>();
    String [] columns = {"Deliveryman ID","Name","Order ID"}; 
    
    public PendingTableModel(DeliverymanInterface<Delivery> contents){
        this.contents = contents;
    }
    
    public String getColumnName(int col) {
        return columns[col];
    }
    
    @Override
    public int getRowCount() {
        return this.contents.getNumberOfEntries();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        String deliverymanID = null;
        String name = null;
        String orderID = null;
        row++;
            Delivery delivery = (Delivery) contents.get(row);
             deliverymanID = delivery.getDeliverymanID();
             name = delivery.getDeliverymanName();
             orderID = delivery.getOrderID();
        if(column == 0)
            return deliverymanID;
        else if(column == 1)
            return name;
        else
            return orderID;
       
    }
    
}
