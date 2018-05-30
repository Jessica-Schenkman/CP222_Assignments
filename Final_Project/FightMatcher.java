import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class FightMatcher{

  ArrayList<Fighter> boxer_list = new ArrayList<Fighter>();
  ArrayList<Fighter> mmafighter_list = new ArrayList<Fighter>();
  ArrayList<MatchPair> match_pair_list = new ArrayList<MatchPair>();

  Queue<Fighter> mma_fighter_queue = new Queue<Fighter>();
  Stack<Fighter> boxer_stack = new Stack<Fighter>();
  Stack<MatchPair> match_pair_stack = new Stack<MatchPair>();


  Sorter my_sorter = new Sorter();

//creates array list of boxers
  public void addToBoxerList(){
    try{
      File boxer_file = new File("Boxers.txt");

      Scanner my_scanner = new Scanner(boxer_file);

      while(my_scanner.hasNext()){
          String name = my_scanner.next();
          System.out.println(name);
          int reach = my_scanner.nextInt();
          int rank = my_scanner.nextInt();
          Fighter current_boxer = new Fighter(name, reach, rank);
          boxer_list.add(current_boxer);

      }
    }
    catch(FileNotFoundException e){
      System.out.println("Error!" + e);
    }
  }

//creates a list of mma fighters
  public void addToMmaFighterlist(){
    try{
      File mma_file = new File("MMAFighters.txt");

      Scanner my_scanner = new Scanner(mma_file);

      while(my_scanner.hasNext()){
          String name = my_scanner.next();
          int reach = my_scanner.nextInt();
          int rank = my_scanner.nextInt();
          Fighter current_mma_fighter = new Fighter(name, reach, rank);
          mmafighter_list.add(current_mma_fighter);


      }
    }
    catch(FileNotFoundException e){
      System.out.println("Error!" + e);
    }
  }

//sorts useing sorter class list of boxers from shortest reach to longest reach and puts this sorted list in to a stack
  public void sortBoxers(){
    my_sorter.sortLowtoHigh(boxer_list);
    for(int i = 0; i < boxer_list.size(); i++){
      boxer_stack.push(boxer_list.get(i));
    }
  }

//sorts useing sorter class list of mmafighters from longest reach to shortest reach and puts this sorted list in to a queue
  public void sortMmaFighters(){
    my_sorter.sortHightoLow(mmafighter_list);
    for(int i = 0; i < mmafighter_list.size(); i++){
      mma_fighter_queue.Enqueue(mmafighter_list.get(i));
    }
  }

  public void printBoxerArray(){
    for(int i = 0; i < boxer_list.size(); i++){
      System.out.println("Name: " + boxer_list.get(i).getName() + " Reach: " + boxer_list.get(i).getReach());
    }
  }

  public void printMMAArray(){
    for(int i = 0; i < mmafighter_list.size(); i++){
      System.out.println("Name: " + mmafighter_list.get(i).getName() + " Reach: " + mmafighter_list.get(i).getReach());
    }
  }

//this method matches the fighters on the mmaqueue and the boxer stack based on how long there reach is, the longest reach gets paired together... and the shortest reach will get paired together
//it will then put the pairs into a match pair object which will then go into a list, each mmafighter will then be dequeued and the boxers will be poped from the stack once they have been processed
  public void matchFighters(){
    while(boxer_stack.getSize() != 0) {

      //System.out.println(boxer_stack.peek().getElement().getRank() + " Vs. " + mma_fighter_queue.lookAtLast().getElement().getRank());
      MatchPair current_match_pair = new MatchPair(boxer_stack.peek().getElement(), mma_fighter_queue.lookAtLast().getElement());
      match_pair_list.add(current_match_pair);

          boxer_stack.pop();

          if(mma_fighter_queue.getSize() != 1){
            mma_fighter_queue.Dequeue();
          }
    }
  }

//this method sorts the  matches based on the collective ranking of the two fighters involved in the fight, to see how interesting the fight would be
//lower collective ranking mean that the fight would be more interesting because the fighters  would be more highly ranked (closer to number 1).
  public void sortMatches(){
    my_sorter.sortMatchesLowtoHigh(match_pair_list);
    for(int i = 0; i < match_pair_list.size(); i++){
      System.out.println(i + 1 + ": " + match_pair_list.get(i).getBoxer().getName() + " Vs. " + match_pair_list.get(i).getMMAFighter().getName());
    }
  }




  public static void main(String[] args) {

    FightMatcher my_fight_matcher = new FightMatcher();

    my_fight_matcher.addToBoxerList();
    my_fight_matcher.addToMmaFighterlist();


    my_fight_matcher.sortBoxers();
  //  my_fight_matcher.printBoxerArray();


    my_fight_matcher.sortMmaFighters();
  // my_fight_matcher.printMMAArray();
    my_fight_matcher.matchFighters();
    my_fight_matcher.sortMatches();


  }
}
