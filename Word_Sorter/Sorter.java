/*
Jessica Schenkman
Sorter.java
January/Febuary 2016
The following program will sort a text file of words alphabetically using a linked list to store the words as they are being sorted.
*/

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;




public class Sorter{

  LinkedListNode<String> current_node;
  String current_element;
  String first_element;
  String second_element;

  int x;
  public LinkedList<String> sorter(LinkedList<String> dictionary_list){

  int x = dictionary_list.size();

  for(int j = 0; j <  dictionary_list.size(); j++){

    current_node = dictionary_list.getFirst();
    for(int i = 0; i < x; i++){
    if(current_node.getNeighbor() != null){
      first_element = current_node.getElement();
      second_element = current_node.getNeighbor().getElement();

    //System.out.println("First: " + first_element);
    //System.out.println("Second: " + second_element);

      if(first_element.compareTo(second_element) > 0){
      //  System.out.println("switch");

        current_node.setElement(second_element);
        current_node.getNeighbor().setElement(first_element);


      }

        current_node = current_node.getNeighbor();
    }
  }
  System.out.println(j);
    x--;
  }
  return dictionary_list;
}




  public static void main(String[] args) {


    Sorter my_sorter = new Sorter();

    LinkedList<String> dictionary_list = new LinkedList<String>();



    try{

      System.out.println("Enter the Unsorted document: ");
      Scanner myScannerUnsorted = new Scanner(System.in);
      String unsorted_doc = myScannerUnsorted.nextLine();

      System.out.println("Enter the new Sorted document: ");
      Scanner myScannerSorted = new Scanner(System.in);
      String sorted_doc = myScannerSorted.nextLine();



      Scanner myScanner = new Scanner(new File(unsorted_doc));

          while (myScanner.hasNext()) {
              dictionary_list.addLast(myScanner.next());
          }

              LinkedList<String> dictionary_list1 = my_sorter.sorter(dictionary_list);

                  PrintWriter pw = new PrintWriter(sorted_doc);
                  LinkedListNode<String> current_node_writer;
                  current_node_writer = dictionary_list1.getFirst();
                    for(int j = 0; j <  dictionary_list1.size(); j++){
                        pw.write(current_node_writer.getElement() + "\n");
                        pw.flush();
                        if(current_node_writer.getNeighbor() != null){
                        current_node_writer = current_node_writer.getNeighbor();
                    }
        }

        // dictionary_list1.printList();


    }
    catch(FileNotFoundException e){
        System.out.println("Error" + e);
    }

  }
}
