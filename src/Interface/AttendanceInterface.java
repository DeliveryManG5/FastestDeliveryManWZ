/*
 * To change this license header, choose License Headers in Project * To change this template file, choose Tools | Templates
 Properties.
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author ADmin
 */
public interface AttendanceInterface<T> {
    AttendanceInterface filterStatus();
    AttendanceInterface filterRecord(String Status);
    T selectRecord(String id);
    int getNumberOfEntries();
    T get(int givenPosition);
    boolean isEmpty();
    boolean addRecord(T newDetails);
    boolean searchRecord(String id);
    boolean updateRecord(int givenPosition, T newAttendance);
    T getRecord(String inputID);
    int getPosition(String id);
    
}
