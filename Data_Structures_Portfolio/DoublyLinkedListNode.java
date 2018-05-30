/*
Jessica Schenkman
DoublyLinkedListNode.java
January/Febuary 2016
The following class includes the necessary methods and constructors for doubly linked list nodes used in the implimentation of a doubly linked list
See DoublyLinkedList.java for the implimentation of a binary search tree.
*/

public class DoublyLinkedListNode<T> {

  private T element;
  private DoublyLinkedListNode<T> before_neighbor;
  private DoublyLinkedListNode<T> after_neighbor;

//constructor for node contain neighbor before and after
  public DoublyLinkedListNode(T _element) {
    element = _element;
    before_neighbor = null;
    after_neighbor = null;
  }

//getter for after neighbor
  public DoublyLinkedListNode<T> getAfterNeighbor() {
    return after_neighbor;
  }

//getter for before neighbor
  public DoublyLinkedListNode<T> getBeforeNeighbor(){
    return before_neighbor;
  }

//sets before neighbor as a certain value
  public void setBeforeNeighbor(DoublyLinkedListNode<T> new_neighbor) {
    before_neighbor = new_neighbor;
  }

//sets after neighbor as a certain value
  public void setAfterNeighbor(DoublyLinkedListNode<T> new_neighbor){
    after_neighbor = new_neighbor;
  }

//getter for element contained in node
  public T getElement() {
    return element;
  }

  //provides ability to print node as a string
  public String toString() {
    return element.toString();
  }
}
