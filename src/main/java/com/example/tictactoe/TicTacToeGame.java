package com.example.tictactoe;

public class TicTacToeGame {
    private boolean fieldTaken;
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    private TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeGameState ticTacToeGameState = new TicTacToeGameState(ticTacToeLogic);
    TicTacToeMoveValidator ticTacToeMoveValidator = new TicTacToeMoveValidator();
    int moveOnX;
    int moveOnY;

    public void startGame() {
        ticTacToeGameState.isComputerModeOn(ticTacToeMenu.ticTacToeGameMode());
        ticTacToeMenu.gameInstructions();
        ticTacToeLogic.randomStart();
        do {
            ticTacToeGameState.currentStateOfBoard();
            do {
                moveOnX = ticTacToeMoveValidator.getNextMoveOnX(ticTacToeGameState.getBoardSize());
                moveOnY = ticTacToeMoveValidator.getNextMoveOnY(ticTacToeGameState.getBoardSize());
                fieldTaken = ticTacToeGameState.isFieldTaken(moveOnX, moveOnY, ticTacToeGameState.choicedBoard());
                if (!fieldTaken) {
                    ticTacToeLogic.manageMove(moveOnX, moveOnY, ticTacToeLogic.currentMove(), ticTacToeGameState.choicedBoard());
                    fieldTaken = false;
                }
            } while (fieldTaken);
            if (!ticTacToeLogic.checkIfSomeOneWon(ticTacToeGameState.choicedBoard(), ticTacToeGameState.getBoardSize(), ticTacToeGameState.whosTurn(), moveOnX, moveOnY)) {
                ticTacToeLogic.checkForDraw(ticTacToeGameState.getBoardSize(), ticTacToeGameState.getCurrentRound());
            }
            ticTacToeGameState.checkIfComputerMode(moveOnX, moveOnY);
        } while (!ticTacToeLogic.isEndGame());
        ticTacToeGameState.currentStateOfBoard();
    }
}


