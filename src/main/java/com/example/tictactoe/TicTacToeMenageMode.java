package com.example.tictactoe;

public class TicTacToeMenageMode {
    public void playerVsPlayerMode() {
        TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
        ticTacToeLogic.setComputerMode(false);
        ticTacToeLogic.gameStart(false);
    }

    public void playerVsComputerMode() {
        TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
        ticTacToeLogic.setComputerMode(true);
        ticTacToeLogic.gameStart(true);
    }
}
