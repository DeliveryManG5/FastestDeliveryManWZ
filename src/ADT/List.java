package ADT;

import Client.HomePage;
//import static Client.HomePage.list;
import Entity.FoodOrder;
import Interface.ListInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author BryanLee
 */
public class List<T> implements ListInterface<T> {

    private Node firstNode; // reference to first node
    private int numberOfEntries;  	// number of entries in list

    @Override
    public int generateOrderID() {
        int orderID;

        if (isEmpty()) {
            return orderID = 1000;
        } else {
            FoodOrder foodorder = (FoodOrder) this.getLast();
            int lastID = foodorder.getOrderID();
            
            return orderID = lastID + 1;
        }
    }

    @Override
    public T getLast() {
        T result = null;

        if (isEmpty()) // if empty list
        {
            result = null;
        } else {
            Node currentNode = firstNode;	// traverse linked list with p pointing to the current node
            while (currentNode.next != null) {	// while have not reached the last node
                currentNode = currentNode.next;
            }
            result = currentNode.data;// currentNode is pointing to the last node
        }

        return result;
    }

    @Override
    public ListInterface filterStatus() {
        ListInterface<FoodOrder> statusList = new List<>();
        if(!HomePage.list.isEmpty()){
            
            Node currentNode = firstNode;
            for(int i = 0; i < numberOfEntries; i++){
                FoodOrder foodOrder = (FoodOrder)currentNode.data;
                String deliveryManID = foodOrder.getDeliveryManID();
                if(deliveryManID == null){
                     statusList.add(foodOrder);
                }
                currentNode = currentNode.next;
            }
        }
        return statusList;  
    }

    public boolean searchRecord(int OrderID) {
        boolean found = false;
        Node currentNode = firstNode;
        for(int i = 0; i < numberOfEntries; i++) {
          
          FoodOrder foodOrder = (FoodOrder)currentNode.data;
          int orderID = foodOrder.getOrderID();
          if(orderID == OrderID){
            found = true;
          }
          else{
              currentNode = currentNode.next;
          }
        }
        return found;
    }

    @Override
    public T getRecord(int inputID) {
        
        T result = null;
        
        if(HomePage.list.isEmpty()){// if empty list       
            result = null;
        }else {                       
            Node currentNode = firstNode;	// traverse linked list with p pointing to the current node
            for(int i = 0; i < numberOfEntries; i++){
                
                FoodOrder foodOrder = (FoodOrder)currentNode.data;

                int orderID = foodOrder.getOrderID();

                if(orderID == inputID)
                    result = currentNode.data;
                else
                    currentNode = currentNode.next;
            }
        }
        return result;
    }

    @Override
    public int getPosition(int id) {
        int position = 0;
        Node currentNode = firstNode;
        for(int i = 1; i <= numberOfEntries; i++) {
         
          FoodOrder foodOrder = (FoodOrder)currentNode.data;
          int orderID = foodOrder.getOrderID();
          if(orderID == id){
            position = i;
            break;
          }
          else
              currentNode = currentNode.next;
        }
        
        return position;    }

    @Override
    public boolean updateRecord(int givenPosition, T newFoodOrder) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
          Node currentNode = firstNode;
          for (int i = 0; i < givenPosition - 1; ++i) {
            currentNode = currentNode.next;		// advance currentNode to next node
          }
          currentNode.data = newFoodOrder;	// currentNode is pointing to the node at givenPosition
        } else {
          isSuccessful = false;
        }

        return isSuccessful;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public T get(int givenPosition) // returns the element at the specified position in the list.
    {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);

            if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
                newNode.next = firstNode;
                firstNode = newNode;
            } else {								                      // case 2: list is not empty and newPosition > 1
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }

                newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
                nodeBefore.next = newNode;		// make the node before point to the new node
            }

            numberOfEntries++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);	// create the new node

        if (isEmpty()) // if empty list
        {
            firstNode = newNode;
        } else {                        // add to end of nonempty list
            Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
            while (currentNode.next != null) {		// while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }

        numberOfEntries++;
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;                 // return value

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {      // case 1: remove first entry
                result = firstNode.data;     // save entry to be removed
                firstNode = firstNode.next;
            } else {                         // case 2: givenPosition > 1
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                result = nodeBefore.next.data;  // save entry to be removed
                nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
            } 																// one to be deleted (to disconnect node from chain)

            numberOfEntries--;
        }

        return result;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                // System.out.println("Trace| currentNode.data = " + currentNode.data + "\t, i = " + i);
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

}
