// Jessica Schenkman, CP222, Take Home Test 1, Tuesday, February 7th, 2017
import java.util.ArrayList;

public class DoubleBubble{

  int save_int;

    public void bubbleSort(ArrayList<Integer> unsorted_list){

      //the outer loop
      for(int k = 0; k < unsorted_list.size(); k++){

        //inner loop that bubbles up values
        for(int i = 0; i > unsorted_list.size() - 1; i++){
          System.out.println("i: " + i);
          if(unsorted_list.get(i) > unsorted_list.get(i + 1)){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_int = unsorted_list.get(i);
            //switches the lower and higher value
            unsorted_list.set(i + 1, unsorted_list.get(i));
            unsorted_list.set(i, save_int);
          }
        }

        // inner loop that bubbles down values
        for(int j = 1; j < unsorted_list.size(); j++){

          if(unsorted_list.get(j) < unsorted_list.get(j - 1)){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_int = unsorted_list.get(j);
            //switches the lower and higher values
            unsorted_list.set(j, unsorted_list.get(j - 1));
            unsorted_list.set(j - 1, save_int);
          }
        }

      }
    }

  public static void main(String[] args) {


    DoubleBubble test = new DoubleBubble();

    ArrayList<Integer> unsorted_list = new ArrayList<Integer>();

    //set unsorted_list to random array of numbers

    test.bubbleSort(unsorted_list);
    System.out.println(unsorted_list);

  }
}
