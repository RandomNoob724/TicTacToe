package bettertictactoe;

class RuleEngine {
    int winCondition = 3;
    Board board;
    Controller controller;

    public RuleEngine(Controller _controller, Board _board) {
        this.controller = _controller;
        this.board = _board;
    }

    public boolean checkIfPlayerWin(int playerNr) {
        int winCounter = 0;
        char[][] boardToCheck = board.getBoard();
        int boardSize = controller.boardSize;
        char playerToCheck = controller.player[playerNr].getPlayerChar();

        // Check horizontal win
        for (int i = 0; i < boardSize; i += 1)
            for (int k = 0; k < boardSize; k += 1) {
                if (k + 1 < boardSize && boardToCheck[k][i] != ' ')
                    if (boardToCheck[k][i] == playerToCheck && boardToCheck[k + 1][i] == playerToCheck) {
                        winCounter += 1;
                        if (winCounter == winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;

        // Check Vertical
        for (int i = 0; i < boardSize; i += 1)
            for (int k = 0; k < boardSize; k += 1) {
                if (k + 1 < boardSize && boardToCheck[k][i] != ' ')
                    if (boardToCheck[i][k] == playerToCheck && boardToCheck[i][k + 1] == playerToCheck) {
                        winCounter += 1;
                        if (winCounter == winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;

        //diagonal Right
        for (int i = 0; i < boardSize; i += 1)
            for (int k = 0; k < boardSize; k += 1) {
                if (k + 1 < boardSize && i + k + 1 < boardSize && boardToCheck[i + k][k] != ' ')
                    if (boardToCheck[i + k][k] == playerToCheck && boardToCheck[i + k + 1][k + 1] == playerToCheck) {
                        winCounter += 1;
                        if (winCounter == winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }
        winCounter = 0;

        for (int i = 0; i < boardSize; i += 1)
            for (int k = 0; k < boardSize; k += 1) {
                if (k + 1 < boardSize && i + k + 1 < boardSize && boardToCheck[k][k + i] != ' ')
                    if (boardToCheck[k][k + i] == playerToCheck && boardToCheck[k + 1][i + k + 1] == playerToCheck) {
                        winCounter += 1;
                        if (winCounter == winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }

        //Diagonal up right
        for (int i = boardSize - 1; i >= 0; i -= 1)
            for (int k = 0; k < boardSize; k += 1) {
                if (i - k - 1 >= 0 && k + 1 < boardSize && boardToCheck[i - k][k] != ' ')
                    if (boardToCheck[i - k][k] == playerToCheck && boardToCheck[i - k - 1][k + 1] == playerToCheck) {
                        winCounter += 1;
                        if (winCounter == winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }

        for (int i = boardSize - 1; i >= 0; i -= 1)
            for (int k = 0; k < boardSize; k += 1) {
                if (boardSize - 2 - k >= 0 && boardSize - i + k < boardSize && boardToCheck[boardSize - 1 - k][boardSize - 1 - i + k] != ' ')
                    if (boardToCheck[boardSize - 1 - k][boardSize - 1 - i + k] == playerToCheck && boardToCheck[boardSize - 2 - k][boardSize - i + k] == playerToCheck) {
                        winCounter += 1;
                        if (winCounter == winCondition - 1)
                            return true;
                    } else
                        winCounter = 0;
            }

        return false;
    }

    public boolean playerMove(int thisPlayerTurn, int r, int c) {
        if (board.spaceIsEmpty(r, c)) {
            board.setPlayerOnPosition(controller.player[thisPlayerTurn], r, c);
            return true;
        } else {
            return false;
        }
    }
}
