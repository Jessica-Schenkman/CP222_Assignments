import java.util.ArrayList;

public class Sorter{

  Fighter save_fighter;
  MatchPair save_match_pair;

    public void sortLowtoHigh(ArrayList<Fighter> unsorted_list){

      //the outer loop
      for(int k = 0; k < unsorted_list.size(); k++){

        //inner loop that bubbles up values
        for(int i = 0; i > unsorted_list.size() - 1; i++){
          System.out.println("i: " + i);
          if(unsorted_list.get(i).getReach() > unsorted_list.get(i + 1).getReach()){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_fighter = unsorted_list.get(i);
            //switches the lower and higher value
            unsorted_list.set(i + 1, unsorted_list.get(i));
            unsorted_list.set(i, save_fighter);
          }
        }

        // inner loop that bubbles down values
        for(int j = 1; j < unsorted_list.size(); j++){

          if(unsorted_list.get(j).getReach() < unsorted_list.get(j - 1).getReach()){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_fighter = unsorted_list.get(j);
            //switches the lower and higher values
            unsorted_list.set(j, unsorted_list.get(j - 1));
            unsorted_list.set(j - 1, save_fighter);
          }
        }

      }
    }


    public void sortHightoLow(ArrayList<Fighter> unsorted_list){

      //the outer loop
      for(int k = 0; k < unsorted_list.size(); k++){

        //inner loop that bubbles up values
        for(int i = 0; i > unsorted_list.size() - 1; i++){
          System.out.println("i: " + i);
          if(unsorted_list.get(i).getReach() < unsorted_list.get(i + 1).getReach()){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_fighter = unsorted_list.get(i);
            //switches the lower and higher value
            unsorted_list.set(i + 1, unsorted_list.get(i));
            unsorted_list.set(i, save_fighter);
          }
        }

        // inner loop that bubbles down values
        for(int j = 1; j < unsorted_list.size(); j++){

          if(unsorted_list.get(j).getReach() > unsorted_list.get(j - 1).getReach()){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_fighter = unsorted_list.get(j);
            //switches the lower and higher values
            unsorted_list.set(j, unsorted_list.get(j - 1));
            unsorted_list.set(j - 1, save_fighter);
          }
        }

      }
    }

    public void sortMatchesLowtoHigh(ArrayList<MatchPair> unsorted_list){

      //the outer loop
      for(int k = 0; k < unsorted_list.size(); k++){

        //inner loop that bubbles up values
        for(int i = 0; i > unsorted_list.size() - 1; i++){
          System.out.println("i: " + i);
          if((unsorted_list.get(i).getBoxer().getRank() + unsorted_list.get(i).getMMAFighter().getRank()) > (unsorted_list.get(i + 1).getBoxer().getRank() + unsorted_list.get(i + 1).getMMAFighter().getRank())){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_match_pair = unsorted_list.get(i);
            //switches the lower and higher value
            unsorted_list.set(i + 1, unsorted_list.get(i));
            unsorted_list.set(i, save_match_pair);
          }
        }

        // inner loop that bubbles down values
        for(int j = 1; j < unsorted_list.size(); j++){

          if((unsorted_list.get(j).getBoxer().getRank() + unsorted_list.get(j).getMMAFighter().getRank()) < (unsorted_list.get(j - 1).getBoxer().getRank() + unsorted_list.get(j - 1).getMMAFighter().getRank())){
            //save_int - saves the int at position j so when you switch the two values you dont loose it
            save_match_pair = unsorted_list.get(j);
            //switches the lower and higher values
            unsorted_list.set(j, unsorted_list.get(j - 1));
            unsorted_list.set(j - 1, save_match_pair);
          }
        }

      }
    }


    }
