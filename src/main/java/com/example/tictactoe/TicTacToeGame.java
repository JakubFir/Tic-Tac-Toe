package com.example.tictactoe;

public class TicTacToeGame {
    private boolean fieldTaken;
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeGameState ticTacToeGameState = new TicTacToeGameState(ticTacToeLogic);

    public void startGame() {
        ticTacToeGameState.playerChoiceBetweenMode();
        ticTacToeGameState.playerBoardChoice();
        ticTacToeMenu.gameInstructions();
        ticTacToeLogic.randomStart();
        do {
            ticTacToeGameState.printCurrentStateOfBoard();
            do {
                ticTacToeGameState.playerMoveOnX();
                ticTacToeGameState.playerMoveOnY();
                fieldTaken = ticTacToeGameState.isFieldTaken(
                        ticTacToeGameState.getMoveOnX(),
                        ticTacToeGameState.getMoveOnY(),
                        ticTacToeGameState.choicedBoard());
                if (!fieldTaken) {
                    ticTacToeLogic.playMove(
                            ticTacToeGameState.getMoveOnX(),
                            ticTacToeGameState.getMoveOnY(),
                            ticTacToeLogic.currentMove(),
                            ticTacToeGameState.choicedBoard());
                    fieldTaken = false;
                }
            } while (fieldTaken);
            if (!ticTacToeLogic.checkIfSomeOneWon(
                    ticTacToeGameState.choicedBoard(),
                    ticTacToeGameState.getBoardSize(),
                    ticTacToeGameState.whoseTurn(),
                    ticTacToeGameState.getMoveOnX(),
                    ticTacToeGameState.getMoveOnY())) {
                ticTacToeLogic.checkForDraw(ticTacToeGameState.getBoardSize(), ticTacToeGameState.getCurrentRound());
            }
            if (ticTacToeGameState.isComputerModeOn()) {
                ticTacToeGameState.computerMove(ticTacToeGameState.getMoveOnX(), ticTacToeGameState.getMoveOnY());
            }
        } while (!ticTacToeLogic.isEndGame());
        ticTacToeGameState.printCurrentStateOfBoard();
    }
}


