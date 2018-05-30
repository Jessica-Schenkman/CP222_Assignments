/*
Jessica Schenkman
Queue.java
January/Febuary 2016
This is an implimentation of a Queue.
*/

public class Queue<T>{

LinkedList<T> myQueuelist = new LinkedList<T>();

//The following method adds to back of queue - O(1)
    public void Enqueue(T element){
      myQueuelist.addFirst(element);
    }

//The following method removes from front of queue - O(1)
    public void Dequeue(){
      if(myQueuelist.isListEmpty() == false){
         myQueuelist.removeLast();
       }
       else{
         System.out.println("Queue is Empty");
       }
     }

//The following method looks at first node in queue - O(1)
    public LinkedListNode<T> lookAtFirst(){
      return myQueuelist.getFirst();
    }

//The following method checks to see if queue is empty
    public void isQueueEmpty(){
        myQueuelist.isListEmpty();
    }

//The following method gets the size of the queue - O(n)
    public int getSize(){
        return myQueuelist.size();

    }

//The following method prints out the queue
    public void printQueue(){
      myQueuelist.printList();
    }

  public static void main(String[] args) {

      Queue<String> myQueue = new Queue<String>();

      myQueue.Enqueue("Q1");
      myQueue.Enqueue("Q2");
      myQueue.Enqueue("Q3");

      myQueue.Dequeue();

      myQueue.printQueue();

  }
}
