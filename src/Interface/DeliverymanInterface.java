/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author ADmin
 */
public interface DeliverymanInterface<T> {
    boolean addRecord(T newDetails);
    boolean updateRecord(int givenPosition, T newDeliveryman);
    String generateDeliverymanID();
    DeliverymanInterface getActiveRecord();
    T getRecord(String inputID);
    DeliverymanInterface getPendingDelivery();
    DeliverymanInterface getAvailable();
    void clear();
    boolean isEmpty();
    T getLast();
    boolean searchRecord(String id);
    int getNumberOfEntries();
    T get(int givenPosition);
    int getPosition(String id);
    DeliverymanInterface getPendingRecord();    
}
