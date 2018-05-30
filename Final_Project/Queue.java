public class Queue<T>{

LinkedList<T> myQueuelist = new LinkedList<T>();

    public void Enqueue(T element){
      myQueuelist.addFirst(element);
    }

    public void Dequeue(){
      if(myQueuelist.isListEmpty() == false){
         myQueuelist.removeLast();
       }
       else{
         System.out.println("Queue is Empty");
       }
     }


    public LinkedListNode<T> lookAtFirst(){
      return myQueuelist.getFirst();
    }

    public LinkedListNode<T> lookAtLast(){
      return myQueuelist.getLast();
    }


    public boolean isQueueEmpty(){
      return myQueuelist.isListEmpty();
    }

    public int getSize(){
        return myQueuelist.size();

    }

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
