import java.util.Scanner;

class SpiceMixologistCli{
  public SpiceMixGame Spices; 



  public static SpiceMixGame playGame(SpiceMixGame Game){
    Scanner myObj = new Scanner(System.in);


    boolean game = true;
    while (game == true){
      System.out.println("Previous attempts:");
      if (Game.getPreviousAttempts() == null){
        System.out.println("No previous attempts");
        Game.list = new LinkedList();
        }
      else{
          Game.A = new Attempt(Game.list.head.data, Game.getSolution());
          System.out.println(Game.A);
          while (Game.list.head.next != null){
            Game.list.head = Game.list.head.next;
            Game.A = new Attempt(Game.list.head.data, Game.getSolution());
            System.out.println(Game.A);
          }

          
        }

      System.out.println("Enter spice mix:");
      char[] myArray = new char[5];
      String Suggestion = myObj.nextLine();
      myArray[0] = Suggestion.charAt(0);
      myArray[1] = Suggestion.charAt(2);
      myArray[2] = Suggestion.charAt(4);
      myArray[3] = Suggestion.charAt(6);
      myArray[4] = Suggestion.charAt(8);
      Game.list = LinkedList.insert(Game.list,new SpiceMix(myArray));
      Game.A = new Attempt(new SpiceMix(myArray), Game.getSolution());
      char[] Mixes = {'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
      int tests = 0;
      for (int i = 0; i <5; i++){
        for (int j = 0; j <7; j++){
          if (myArray[i] == Mixes[j]){
            tests +=1;
          }
        }
      }
      if (tests != 5){
        System.out.println("Invalid spice mix!");
      }

      if  (Game.A.isCorrect() == true){
        System.out.println("Congratulations!");
        game = false;
        System.exit(0);
      }
      game = true;
    }
    return Game;
  }
  public void main(String[] args){
    this.Spices = new SpiceMixGame();
    playGame(this.Spices);
  }
}