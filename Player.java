package bettertictactoe;
class Player{
  char playerChar;

  public Player(){}

  // Used to set the players char
  void setPlayerChar(char inputChar){
    playerChar = inputChar;
  }

  // Used in the controller for getting the player objects char
  char getPlayerChar(){
    return playerChar;
  }
}
