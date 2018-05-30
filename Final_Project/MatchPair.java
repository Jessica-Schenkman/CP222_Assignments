public class MatchPair{

  Fighter boxer;
  Fighter mma_fighter;

  public MatchPair(Fighter _boxer, Fighter _mma_fighter){
      boxer = _boxer;
      mma_fighter = _mma_fighter;
  }

    public Fighter getBoxer(){
      return boxer;
    }

    public Fighter getMMAFighter(){
      return mma_fighter;
    }
}
