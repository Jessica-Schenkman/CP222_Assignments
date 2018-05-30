/*
Jessica Schenkman
LinkedList.java
January/Febuary 2016
This is an Implimentation of a Doubly Linked List.
*/
public class DoublyLinkedList<T> {

  private DoublyLinkedListNode<T> first;
  private DoublyLinkedListNode<T> last;

  boolean list_empty;

//constructor
  public DoublyLinkedList() {
    first = null;
    last = null;
  }

//The following method returns boolean value to tell whether or not a list is empty - O(1)
  public boolean isListEmpty(){
    if(last == null){
      list_empty = true;
    }
    else{
      list_empty = false;
    }
    return list_empty;
  }

//The following method adds an element to end of list - O(n)
  public void addLast(T new_element) {
    DoublyLinkedListNode<T> new_node = new DoublyLinkedListNode<T>(new_element);

    //Checks if list is empty, if list is empty then the new node becomes the first and last node
    if (last == null) {
      first = new_node;
      last = new_node;
    }
    //If the list is not empty then the new element will be set as the last element
    else {
      last.setAfterNeighbor(new_node);
      new_node.setBeforeNeighbor(last);
      last = new_node;

    }
  }

//The following method adds an element to the front of the list - O(1)
  public void addFirst(T new_element){

    DoublyLinkedListNode<T> new_node = new DoublyLinkedListNode<T>(new_element);

      if(last == null){
        first = new_node;
        last = new_node;
      }
      else{
        first.setBeforeNeighbor(new_node);
        new_node.setAfterNeighbor(first);
        first = new_node;
    }
  }

//The following method will return last node - O(1)
  public DoublyLinkedListNode<T> getLast(){
    return last;
  }

//The following method will return the first node - O(1)
  public DoublyLinkedListNode<T> getFirst(){
    return first;
  }

//The following method removes last node - O(1)
  public void removeLast(){
    last = last.getBeforeNeighbor();
    last.setAfterNeighbor(null);
  }

//The following method removes first node - O(1)
  public void removeFirst(){
    first = first.getAfterNeighbor();
  }


//The following method removes an node when the element stored in the node is entered, will travese list and look for the node that contains this element and remove it - O(n)
  public void removeElementByValue(T element_to_remove){
      DoublyLinkedListNode<T> current_node = first;

        while(current_node.getAfterNeighbor() != null && current_node.getElement() != element_to_remove ){

          current_node = current_node.getAfterNeighbor();
        }

        if(current_node.getAfterNeighbor() == null){
          System.out.println("Item does not exist in list");
        }
        else{
          current_node.getAfterNeighbor().setBeforeNeighbor(current_node.getBeforeNeighbor());
          current_node.getBeforeNeighbor().setAfterNeighbor(current_node.getAfterNeighbor());
        }
  }


//The following method will insert a node after the node that contains the entered element - O(n)
  public void insertElementAfterByValue(T previous_element, T new_element){
    DoublyLinkedListNode<T> new_node = new DoublyLinkedListNode<T>(new_element);
    DoublyLinkedListNode<T> current_node = first;

      while(current_node != null && current_node.getElement() != previous_element){
       //System.out.println(current_node);
        current_node = current_node.getAfterNeighbor();
      }
     System.out.println(current_node.getAfterNeighbor());
     if(current_node == null){
       System.out.println("Item does not exist in list");
     }
   else{
     current_node.getAfterNeighbor().setBeforeNeighbor(new_node);
     new_node.setAfterNeighbor(current_node.getAfterNeighbor());

     current_node.setAfterNeighbor(new_node);
     new_node.setBeforeNeighbor(new_node);

      }
   }

//The following method will insert a node after the node at the entered position - O(n)
   public void insertElementByPosition(int element_position, T new_element){
     DoublyLinkedListNode<T> new_node = new DoublyLinkedListNode<T>(new_element);
     DoublyLinkedListNode<T> current_node = first;
     int current_position = 0;

       while(current_node != null && current_position != element_position - 1){
        //System.out.println(current_node);
         current_node = current_node.getAfterNeighbor();
         current_position++;
       }

      if(current_node == null){
        System.out.println("Item does not exist in list");
      }
    else{
      current_node.getAfterNeighbor().setBeforeNeighbor(new_node);
      new_node.setAfterNeighbor(current_node.getAfterNeighbor());

      current_node.setAfterNeighbor(new_node);
      new_node.setBeforeNeighbor(new_node);



       }
    }

// The following method will traverse list an check if there is a node that contains the given element -O(n)
  public void checkListForElement(T check_element){
      DoublyLinkedListNode<T> new_node = new DoublyLinkedListNode<T>(check_element);
      DoublyLinkedListNode<T> current_node = first;

          while(current_node != null && current_node.getElement() != check_element){
            current_node = current_node.getAfterNeighbor();
          }
      if (current_node == null){
        System.out.println("Element does not exist.");
      }
      else{
        System.out.println("Element Exists in list:" + " " + check_element);

      }


  }

//The following method prints elements in list - O(n)
  public void printList() {
    DoublyLinkedListNode<T> current_node = first;
    while (current_node != null) {
      System.out.println(current_node);
      current_node = current_node.getAfterNeighbor();
    }
  }

//The following method finds the size of the list - O(n)
  public int size() {
    DoublyLinkedListNode<T> current_node = first;
    int count = 0;
    while (current_node != null) {
      count++;
      current_node = current_node.getAfterNeighbor();
    }
    return count;
  }




  public static void main(String[] args) {

   //Below is an example of how to build a DoublyLinkedList of names

    //DoublyLinkedList<(input object to be stored in list)> listname = new DoublyLinkedList<String>();

    DoublyLinkedList<String> names = new DoublyLinkedList<String>();



    //names.addFirst("Sam");
    //names.addLast("Matthew");
    //names.addLast("Tracy");
    //names.addLast("Jack");
    //names.addLast("Sally");

    //names.removeFirst();
    //names.removeLast();

    //names.removeElementByValue("Matthew");
    //names.insertElementByPosition(4, "Marta");
    //names.insertElementAfterByValue("Matthew", "Nina");

    //names.checkListForElement("Matthew");

    //names.printList();


//Prints the number of elements in the list
    System.out.println("Size is : " + names.size());


  }

}
