package com.example.tictactoe;

public class TicTacToeMenu {
    public void ticTacToeBoard(char[][] board) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

}