package bettertictactoe;

import javax.swing.*;

public class Controller{
  int playerTurn = 0;
  int nrOfPlayers = 3;
  int boardSize = 5;
  View view;
  Board board;
  RuleEngine ruleEngine;
  Player[] player;

  public Controller(){
    board = new Board(this);
    ruleEngine = new RuleEngine(this, board);
    view = new View(this);
    player = new Player[nrOfPlayers];

    for (int i = 0;i < nrOfPlayers;i++) {
      player[i] = new Player();
      player[i].setPlayerChar(((char)(88+i)));
    }
  }

  // Function sets the clicked units char to the player objects char
  public void unitClicked(int r, int c){
    if(ruleEngine.playerMove(playerTurn, r, c)){
      view.setButtonText(player[playerTurn].getPlayerChar(), r, c);
      if(ruleEngine.checkIfPlayerWin(playerTurn)){
        view.setPlayerLabelText("Player " + (playerTurn+1) + " Wins!!");
      }
      playerTurn = (playerTurn+1)%nrOfPlayers;
    }else{
      view.setPlayerLabelText("Illegal move");
    }
  }
}
