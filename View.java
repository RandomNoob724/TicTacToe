package bettertictactoe;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class View extends JFrame{
  int boardSize;
  JFrame frame;
  JPanel buttonPanel;
  JPanel textPanel;
  JPanel mainPanel;
  JLabel playerLabel;

  JButton[][] buttonGrid;
  Controller controller;

  public void setButtonText(char playerChar, int r, int c){
    buttonGrid[r][c].setText(Character.toString(playerChar));
  }

  public void setPlayerLabelText(String input){
    playerLabel.setText(input);
  }

  public View(Controller _controller){
    frame = new JFrame("BetterTicTacToe");
    buttonPanel = new JPanel();
    textPanel = new JPanel();
    mainPanel = new JPanel();
    playerLabel = new JLabel("player 1's turn", SwingConstants.CENTER);
    buttonGrid = new JButton[_controller.boardSize][_controller.boardSize];

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buttonPanel.setLayout(new GridLayout(_controller.boardSize, _controller.boardSize));
    textPanel.setLayout(new GridLayout(1,1));
    textPanel.setPreferredSize(new Dimension(150,50));
    mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
    mainPanel.add(buttonPanel);
    mainPanel.add(textPanel);
    textPanel.add(playerLabel);

    frame.getContentPane().add(mainPanel);

    this.controller = _controller;
    boardSize = controller.boardSize;
    for (int r = 0; r < boardSize; r++) {
      for (int c = 0;c < boardSize;c++) {
        final int _r = r;
        final int _c = c;
        JButton button = buttonGrid[r][c] = new JButton();
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
            controller.unitClicked(_r, _c);
          }
        });
        buttonPanel.add(button);
      }
    }
    frame.pack();
    frame.setVisible(true);
  }
}
