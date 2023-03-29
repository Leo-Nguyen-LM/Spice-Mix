class Attempt{
  public SpiceMix smA0;//suggested
  public SpiceMix smA1;//real solution

  public char[] options = {'N','O','P','Q','R','S','T'};
  public int[] options1 = {0,0,0,0,0,0,0};
  public int[] options2 = {0,0,0,0,0,0,0};

  public Attempt(SpiceMix sm0,SpiceMix sm1){
    this.smA0 = sm0;
    this.smA1 = sm1;
  }

  public SpiceMix getSpiceMix(){
      return smA0; //Returns suggested solution
    }

  public int getNumGood(){
    int num = 0;
    for (int i=0; i < 6; i++){
      options1[i] = adder(this.options[i], this.smA0.gSpices());
    }
    for (int j=0; j < 6; j++){
      options2[j] = adder(this.options[j], this.smA1.gSpices());
    }
    for (int k=0; k<6; k++){
      if (options1[k] == options2[k] && options2[k] > 0){
        num+=1;
      }
    }
    return num;
  }


  public int getNumWrongQuantity(){
    int num = 0;
    for (int i=0; i < 6; i++){
      options1[i] = adder(this.options[i], this.smA0.gSpices());
    }
    for (int j=0; j < 6; j++){
      options2[j] = adder(this.options[j], this.smA1.gSpices());
    }
    for (int k=0; k<6; k++){
      if (options1[k] != options2[k] && options2[k] > 0 && options1[k] > 0){
        num+=1;
      }
    }
    return num;
  }

  public int adder(char Spice, char[] spiceM){
    int num = 0;
    for (int i=0; i < spiceM.length ; i++){
      if (spiceM[i] == Spice){
        num +=1+i;
      }
    }
    return num;
  }

  public boolean isCorrect(){
    boolean b = false;
    for (int i = 0; i < this.smA0.gSpices().length; i++){
      if (this.smA0.gSpices()[i] == this.smA1.gSpices()[i])
      {
        b = true;
      }
      else{
        return false;
      }
    }
    return b;
  }
  
  public String toString(){
    String answer = smA0 + " (Good "+getNumGood()+", Wrong quantity "+getNumWrongQuantity()+")";
    return answer;
  }


}