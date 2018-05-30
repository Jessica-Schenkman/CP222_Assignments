/*
Jessica Schenkman
LinkedList.java
January/Febuary 2016
This is an Implimentation of a Linked List.
*/
public class LinkedList<T> {

  private LinkedListNode<T> first;
  private LinkedListNode<T> last;

  boolean list_empty;

  public LinkedList() {
    first = null;
    last = null;
  }

//The following method checks to see if the list is empty - O(1)
  public boolean isListEmpty(){
    if(last == null){
      list_empty = true;
    }
    else{
      list_empty = false;
    }
    return list_empty;
  }

//The following method add to last of list - O(1)
  public void addLast(T new_element) {
    LinkedListNode<T> new_node = new LinkedListNode<T>(new_element);

    // Check if list is empty
    if (last == null) {
      first = new_node;
      last = new_node;
    }
    //if List is not empty
    else {
      last.setNeighbor(new_node);
      last = new_node;
    }
  }

//The following method adds first node to list - O(1)
  public void addFirst(T new_element){
    LinkedListNode<T> new_node = new LinkedListNode<T>(new_element);
      if(last == null){
        first = new_node;
        last = new_node;
      }
      else{
        new_node.setNeighbor(first);
        first = new_node;
    }
  }

//The following method returns the last node - O(1)
  public LinkedListNode<T> getLast(){
    return last;
  }

//The following method returns the first node - O(1)
  public LinkedListNode<T> getFirst(){
    return first;
  }

//The following method removes last node -  O(n)
  public void removeLast(){
    LinkedListNode<T> current_node = first;

    while(current_node.getNeighbor() != last){
      current_node = current_node.getNeighbor();
    }

    last = current_node;
    last.setNeighbor(null);
  }

//The following method removes first node - O(1)
  public void removeFirst(){
    first = first.getNeighbor();
  }


//The following method removes element where a specific valueis given - O(n)
  public void removeElementByValue(T element_to_remove){
      LinkedListNode<T> current_node = first;

        while(current_node.getNeighbor() != null && current_node.getNeighbor().getElement() != element_to_remove ){

          current_node = current_node.getNeighbor();
        }
        System.out.println(current_node.getNeighbor());
        if(current_node.getNeighbor() == null){
          System.out.println("Item does not exist in list");
        }
        else{
          current_node.setNeighbor(current_node.getNeighbor().getNeighbor());
        }
  }


//The following method inserts a node after where a specific valueis given  - O(n)
  public void insertElementAfterByValue(T previous_element, T new_element){
    LinkedListNode<T> new_node = new LinkedListNode<T>(new_element);
    LinkedListNode<T> current_node = first;

      while(current_node != null && current_node.getElement() != previous_element){
       //System.out.println(current_node);
        current_node = current_node.getNeighbor();
      }
     System.out.println(current_node.getNeighbor());
     if(current_node == null){
       System.out.println("Item does not exist in list");
     }
   else{
     new_node.setNeighbor(current_node.getNeighbor());
     current_node.setNeighbor(new_node);

      }
   }

//The following method inserts node by position - O(n)
   public void insertElementAfterByPosition(int element_position, T new_element){
     LinkedListNode<T> new_node = new LinkedListNode<T>(new_element);
     LinkedListNode<T> current_node = first;
     int current_position = 0;

       while(current_node != null && current_position != element_position - 1){
        //System.out.println(current_node);
         current_node = current_node.getNeighbor();
         current_position++;
       }

      if(current_node == null){
        System.out.println("Item does not exist in list");
      }
    else{
      new_node.setNeighbor(current_node.getNeighbor());
      current_node.setNeighbor(new_node);

       }
    }

//The following method checks list for a specific element - O(n)
  public void checkListForElement(T check_element){
      LinkedListNode<T> new_node = new LinkedListNode<T>(check_element);
      LinkedListNode<T> current_node = first;

          while(current_node != null && current_node.getElement() != check_element){
            current_node = current_node.getNeighbor();
          }
      if (current_node == null){
        System.out.println("Element does not exist.");
      }
      else{
        System.out.println("Element Exists in list:" + " " + check_element);

      }


  }

//The following method prints linked list elements as strings
  public void printList() {
    LinkedListNode<T> current_node = first;
    while (current_node != null) {
      System.out.println(current_node);
      current_node = current_node.getNeighbor();
    }
  }

  public int size() {
    LinkedListNode<T> current_node = first;
    int count = 0;
    while (current_node != null) {
      count++;
      current_node = current_node.getNeighbor();
    }
    return count;
  }




  public static void main(String[] args) {

    LinkedList<String> names = new LinkedList<String>();

    names.addFirst("Sam");
    names.addLast("Matthew");
    names.addLast("Tracy");
    names.addLast("Jack");
    names.addLast("Sally");

  //  names.removeFirst();
  //  names.removeLast();


   //names.removeElementByValue("matthew");
  // names.insertElementAfterByPosition(3, "Marta");
   //names.checkListForElement("matthew");
   names.printList();
  //  System.out.println(names.getFirst().getNeighbor());
    System.out.println("Size is : " + names.size());


  }

}


/* public void removeElement(LinkedListNode<T> node_to_remove){
    LinkedListNode<T> current_node = first;

      while(current_node.getNeighbor() != node_to_remove && current_node.getNeighbor() != null){
       //System.out.println(current_node);
        current_node = current_node.getNeighbor();
      }
  current_node.setNeighbor(current_node.getNeighbor().getNeighbor());
} */
// LinkedListNode<String> temp_node = names.getFirst().getNeighbor();
//names.removeElement(names.getFirst().getNeighbor());
