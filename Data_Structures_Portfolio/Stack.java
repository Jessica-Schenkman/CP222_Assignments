/*
Jessica Schenkman
Stack.java
January/Febuary 2016
This is an implimentation of a stack.
*/

public class Stack<T>{

  LinkedList<T> myStacklist = new LinkedList<T>();

//The following method pops the first element off of the stack - O(1)
        public void pop(){
         if(myStacklist.isListEmpty() == false){
            myStacklist.removeFirst();
          }
          else{
            System.out.println("Stack is Empty");
          }
        }

//The following method pushes an element on to the front of the stack - O(1)
        public void push(T element){
          myStacklist.addFirst(element);
        }


//The following method allows to peek at first element on the stack - O(1)
        public LinkedListNode<T> peek(){
          return myStacklist.getFirst();
        }

//The following method checks to see if stack is empty
        public boolean isStackEmpty(){
          return myStacklist.isListEmpty();
        }

//The following method finds size of stack - O(n)
        public int getSize(){
          return myStacklist.size();
        }

//The following method prints out the stack in the terminal
        public void printStack(){
          myStacklist.printList();
        }

      public static void main(String[] args) {

        Stack<String> myStack = new Stack<String>();

        myStack.push("ellie");
        myStack.push("carl");
        myStack.push("manny");
        myStack.pop();

        System.out.println("first element is " + myStack.peek());
        System.out.println("Size:" + myStack.getSize());

        myStack.printStack();
      }

}
