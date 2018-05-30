public class LinkedList<T> {

  private LinkedListNode<T> first;
  private LinkedListNode<T> last;

  boolean list_empty;

  public LinkedList() {
    first = null;
    last = null;
  }

  public boolean isListEmpty(){
    if(last == null){
      list_empty = true;
    }
    else{
      list_empty = false;
    }
    return list_empty;  
  }

  public void addLast(T new_element) {
    LinkedListNode<T> new_node = new LinkedListNode<T>(new_element);

    // Check if list is empty
    if (last == null) {
      first = new_node;
      last = new_node;
    }
    // List is not empty
    else {
      last.setNeighbor(new_node);
      last = new_node;
    }
  }

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


  public LinkedListNode<T> getLast(){
    return last;
  }

  public LinkedListNode<T> getFirst(){
    return first;
  }

  public void removeLast(){
    LinkedListNode<T> current_node = first;

    while(current_node.getNeighbor() != last){
      current_node = current_node.getNeighbor();
    }

    last = current_node;
    last.setNeighbor(null);
  }

  public void removeFirst(){
    first = first.getNeighbor();
  }



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
