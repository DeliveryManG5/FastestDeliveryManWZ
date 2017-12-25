/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import ADT.LAttendance;
import Entity.Attendance;
import Interface.AttendanceInterface;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADmin
 */
public class StatusTableModel  extends AbstractTableModel {
    
    private AttendanceInterface<Attendance> contents = new LAttendance<>();
  
    String[]  columns = {"Deliveryman ID", "Name", "ClockIn", "ClockOut", "Status"};
    
    public StatusTableModel(AttendanceInterface<Attendance> contents){
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
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        String deliverymanID = null;
        String name = null;
        String clockIn = null;
        String clockOut = null;
        String status = null;
        
        row++;
            Attendance attendance = (Attendance) contents.get(row);
             deliverymanID = attendance.getDeliverymanID();
             name = attendance.getName();
             clockIn = attendance.getClockIn();
             clockOut = attendance.getClockOut();
             status = attendance.getStatus();
        if(column == 0)
            return deliverymanID;
        else if(column == 1)
            return name;
        else if(column == 2)
            return clockIn;
        else if(column == 3)
            return clockOut;
        else
            return status;
    }
    
}

