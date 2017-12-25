/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author BryanLee
 */
public interface ListInterface<T> {
    ListInterface filterStatus();
    
    public boolean add(T newEntry);

    public T get(int givenPosition);

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public void clear();

    int generateOrderID();

    T getLast();

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public int getNumberOfEntries();

    public boolean isEmpty();

    public boolean isFull();
    
    boolean searchRecord(int OrderID);
    
    T getRecord(int inputID);
    
    int getPosition(int id);
    
    boolean updateRecord(int givenPosition, T newAttendance);

}
