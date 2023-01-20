package com.example.tictactoe;

public class TicTacToeGame {
    TicTacToeGameState ticTacToeGameState = new TicTacToeGameState();
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu(ticTacToeGameState);
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic(ticTacToeGameState);
    TicTacToeComputerLogic ticTacToeComputerLogic = new TicTacToeComputerLogic(ticTacToeGameState,ticTacToeLogic);


    public void initializeGame(){
        ticTacToeMenu.choiceMenuBetweenComputerOrPlayer();
        ticTacToeMenu.choiceBoardSize();
        ticTacToeMenu.gameInstructions();
        ticTacToeLogic.randomStart();
        ticTacToeGameState.manageGameMode();
    }
    public void startGame() {
        initializeGame();
        do {
            ticTacToeGameState.printCurrentStateOfBoard();
            ticTacToeLogic.managePlayerMove();
            if (!ticTacToeLogic.checkIfSomeOneWon()) {
                ticTacToeLogic.checkForDraw();
            }
            if (ticTacToeGameState.isComputerModeOn()) {
                ticTacToeComputerLogic.manageComputerMoves();
            }
        } while (!ticTacToeLogic.isEndGame());
        ticTacToeGameState.printCurrentStateOfBoard();
    }
}


