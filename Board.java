package bettertictactoe;
class Board{
  // used to represent the character that is on a button in the game
  public char[][] boardGrid;
  public Board(Controller _controller){
    boardGrid = new char[_controller.boardSize][_controller.boardSize];
  }

  //Used to place a players character on a position
  public void setPlayerOnPosition(Player playerToSet, int row, int column){
    boardGrid[row][column] = playerToSet.getPlayerChar();
  }

  // used to get the player that is on a specific position
  public char getPlayerOnPosition(int row, int column){
    return boardGrid[row][column];
  }

  // Checks if a specific unit is empty in the game
  public boolean spaceIsEmpty(int row, int column){
    if(boardGrid[row][column] == 0){
      return true;
    }else{
      return false;
    }
  }

  public char[][] getBoard(){
    return boardGrid;
  }
}
