import java.util.Random;


class SpiceMixGame{
  private SpiceMix answer;
  public LinkedList list;
  public Attempt A;

  public SpiceMixGame(SpiceMix sm0){
    answer = sm0; 
  }
  public LinkedList get_list(){
    return  this.list;
  }
  
  public SpiceMixGame(){
    char[] TEST = {'a','a','a','a','a'}; 
    Random random = new Random();
    for (int i = 0; i<5; i++){
      char randomizedCharacter = (char) (random.nextInt(7) + 'N');
      TEST[i] = randomizedCharacter;
    }
    answer = new SpiceMix(TEST);
  }

  public boolean attemptSpiceMix(SpiceMix spiceMix){
    if (this.list == null){
      list = new LinkedList();
    }
    A = new Attempt(spiceMix, getSolution());
    if (A.isCorrect() == true){
      return true;
    }
    else{
      this.list = LinkedList.insert(this.list, spiceMix);
      return false;
    }
  }

  public String getPreviousAttempts(){
    if (list == null){
      return null;
    }
    else{
      return list.printList(list);
    }
  }


  public SpiceMix getSolution(){
    return this.answer;
  }

}



