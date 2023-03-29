class SpiceMix {
  private char[] Spices;

  public SpiceMix(char[] character) {
    this.Spices = character;
  }


  public char[] gSpices(){ //returns private variable Spices
    return this.Spices;
  }

  public char getSpice(int i){
      return gSpices()[i];
  }
  
  public String toString(){
    String spices = Character.toString(getSpice(0));
    for (int i=1; i < gSpices().length; i++){
      spices += " ".concat(Character.toString(getSpice(i)));
    }
    return spices;
  }


}


