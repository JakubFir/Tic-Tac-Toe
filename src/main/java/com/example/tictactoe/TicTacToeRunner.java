package com.example.tictactoe;

public class TicTacToeRunner {
    public static void main(String[] args) {
        TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
        TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
        ticTacToeLogic.gameStart();
    }
}