package ADT;


import Client.HomePage;
import Entity.Delivery;
import Entity.Deliveryman;
import Interface.DeliverymanInterface;


public class LDeliveryman<T> implements DeliverymanInterface<T> {
    
    private Node firstNode; // reference to first node
    private int numberOfEntries; // number of entries in list
    
    public LDeliveryman() {
        clear();
    }
    
    @Override
    public boolean addRecord(T newDetails) {
        
        Node newNode = new Node(newDetails);	// create the new node

        if (isEmpty()) // if empty list
        {
            firstNode = newNode;
        } else {                        // add to end of nonempty list
            Node currentNode = firstNode;	// traverse linked list with p pointing to the current node
            while (currentNode.next != null) {	// while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }

        numberOfEntries++;
        
        return true;
    }
    
    
    @Override
    public boolean updateRecord(int givenPosition, T newDeliveryman) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
          Node currentNode = firstNode;
          for (int i = 0; i < givenPosition - 1; ++i) {
            currentNode = currentNode.next;		// advance currentNode to next node
          }
          currentNode.data = newDeliveryman;	// currentNode is pointing to the node at givenPosition
        } else {
          isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public String generateDeliverymanID() {
        
        String deliveryManID = null;
        if(isEmpty()){
            deliveryManID = "D1001";
        }else{
            Deliveryman deliveryman = (Deliveryman)this.getLast();
            String lastID = deliveryman.getDeliveryManID();
            
            deliveryManID = "D" + (Integer.parseInt(lastID.substring(1,lastID.length()))+1);
        } 
        return deliveryManID;
       
    }
   
   
    @Override
    public DeliverymanInterface<Deliveryman> getActiveRecord() {
        
        DeliverymanInterface<Deliveryman> activeList = new LDeliveryman<>();
        if(!HomePage.deliverymanList.isEmpty()){
            System.out.println("LD:" + HomePage.deliverymanList);
            Node currentNode = firstNode;
            for(int i = 0; i < numberOfEntries; i++){
                Deliveryman deliveryman = (Deliveryman)currentNode.data;
                String status = deliveryman.getStatus();
                if(status.equals("Full-Time") || status.equals("Part-Time")){
                     activeList.addRecord(deliveryman);
                }
                currentNode = currentNode.next;
        
            }
        }
        return activeList;
    }
    
    @Override
    public boolean searchRecord(String id) {
        boolean found = false;
        Node currentNode = firstNode;
        for(int i = 0; i < numberOfEntries; i++) {
          
          Deliveryman deliveryman = (Deliveryman)currentNode.data;
          String deliverymanID = deliveryman.getDeliveryManID();
          if(deliverymanID.equals(id)){
            found = true;
          }
          else{
              currentNode = currentNode.next;
          }
        }
        return found;
    }

    @Override
    public DeliverymanInterface getPendingDelivery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DeliverymanInterface getAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
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
    
    // returns the number of elements in this list.
   public int getNumberOfEntries() {
    return numberOfEntries;
  }
    
    
    public T get(int givenPosition)
    // returns the element at the specified position in the list.
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
    
    public int getPosition(String id){
       
        int position = 0;
        Node currentNode = firstNode;
        for(int i = 1; i <= numberOfEntries; i++) {
         
          Deliveryman deliveryman = (Deliveryman)currentNode.data;
          String deliverymanID = deliveryman.getDeliveryManID();
          if(deliverymanID.equals(id)){
            position = i;
            break;
          }
          else
              currentNode = currentNode.next;
        }
        
        return position;
        
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

    @Override
    public T getRecord(String inputID) {
        
        T result = null;
        
        if(HomePage.deliverymanList.isEmpty()){// if empty list       
            result = null;
        }else {                       
            Node currentNode = firstNode;	// traverse linked list with p pointing to the current node
            for(int i = 0; i < numberOfEntries; i++){
                
                Deliveryman deliveryman = (Deliveryman)currentNode.data;

                String id = deliveryman.getDeliveryManID();

                if(id.equals(inputID))
                    result = currentNode.data;
                else
                    currentNode = currentNode.next;
            }
        }
        return result;
    }
    
    public DeliverymanInterface<Delivery> getPendingRecord() {
        
        DeliverymanInterface<Delivery> pendingList = new LDeliveryman<>();
        if(!HomePage.deliveryList.isEmpty()){
            Node currentNode = firstNode;
            for(int i = 0; i < numberOfEntries; i++){
                Delivery delivery = (Delivery)currentNode.data;
                String orderID = delivery.getOrderID();
                if(orderID != null){
                     pendingList.addRecord(delivery);
                }
                currentNode = currentNode.next;
        
            }
        }
        return pendingList;
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
        


        
    } // end Node
    
}
