public class Fighter{

  String name;
  int reach;
  int rank;

  public Fighter(String _name, int _reach, int _rank){
      name = _name;
      reach = _reach;
      rank = _rank;
  }

    public String getName(){
      return name;
    }

    public int getReach(){
      return reach;
    }

    public int getRank(){
      return rank;
    }
}
