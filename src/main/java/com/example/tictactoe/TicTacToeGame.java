package com.example.tictactoe;

public class TicTacToeGame {
    private boolean fieldTaken;
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeGameState ticTacToeGameState = new TicTacToeGameState(ticTacToeLogic, ticTacToeMenu);

    public void startGame() {
        ticTacToeMenu.choiceMenuBetweenComputerOrPlayer();
        ticTacToeMenu.choiceBoardSize();
        ticTacToeMenu.gameInstructions();
        ticTacToeLogic.randomStart();
        ticTacToeGameState.manageGameMode();
        do {
            ticTacToeGameState.printCurrentStateOfBoard();
            do {
                ticTacToeGameState.playerMoveOnX();
                ticTacToeGameState.playerMoveOnY();
                fieldTaken = ticTacToeGameState.isFieldTaken(
                        ticTacToeGameState.getMoveOnX(),
                        ticTacToeGameState.getMoveOnY(),
                        ticTacToeGameState.getBoard());
                if (!fieldTaken) {
                    ticTacToeLogic.playMove(
                            ticTacToeGameState.getMoveOnX(),
                            ticTacToeGameState.getMoveOnY(),
                            ticTacToeLogic.currentMove(),
                            ticTacToeGameState.getBoard());
                    fieldTaken = false;
                }
            } while (fieldTaken);
            if (!ticTacToeLogic.checkIfSomeOneWon(
                    ticTacToeGameState.getBoard(),
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


