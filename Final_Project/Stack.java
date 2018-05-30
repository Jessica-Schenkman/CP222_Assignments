public class Stack<T>{

  LinkedList<T> myStacklist = new LinkedList<T>();


        public void pop(){
         if(myStacklist.isListEmpty() == false){
            myStacklist.removeFirst();
          }
          else{
            System.out.println("Stack is Empty");
          }
        }

        public void push(T element){
          myStacklist.addFirst(element);
        }

        public LinkedListNode<T> peek(){
          return myStacklist.getFirst();
        }

        public boolean isStackEmpty(){
          return myStacklist.isListEmpty();
        }

        public int getSize(){
          return myStacklist.size();
        }

        public void printStack(){
          myStacklist.printList();
        }

      public static void main(String[] args) {

        Stack<String> myStack = new Stack<String>();

      //  myStack.push("ellie");
      //  myStack.push("carl");
      //  myStack.push("manny");
        myStack.pop();

        System.out.println("first element is " + myStack.peek());
        System.out.println("Size:" + myStack.getSize());

        myStack.printStack();
      }


}
// does not matter t or e will be passed through the same
