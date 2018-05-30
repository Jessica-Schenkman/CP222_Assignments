/*
Jessica Schenkman
LinkedListNode.java
January/Febuary 2016
The following class includes the necessary methods and constructors for linked list nodes used in the implimentation of a linked list
See LinkedList.java for the implimentation of a binary search tree.
*/

public class LinkedListNode<T> {

  private T element;
  private LinkedListNode<T> neighbor;

//constructor for linked list node, describes all the information associated with each linked list node
  public LinkedListNode(T _element) {
    element = _element;
    neighbor = null;
  }

//The following method returns the neighbor of a node
  public LinkedListNode<T> getNeighbor() {
    return neighbor;
  }

//The following method sets the value of a neighbor node
  public void setNeighbor(LinkedListNode<T> new_neighbor) {
    neighbor = new_neighbor;
  }

// The following method returns element stored in a node
  public T getElement() {
    return element;
  }


  public String toString() {
    return element.toString();
  }
}
