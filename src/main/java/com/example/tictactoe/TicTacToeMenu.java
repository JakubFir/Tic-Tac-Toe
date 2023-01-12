package com.example.tictactoe;

import java.util.Scanner;

public class TicTacToeMenu {
    TicTacToeMenageMode ticTacToeMenageMode = new TicTacToeMenageMode();

    Scanner scanner = new Scanner(System.in);

    public void ticTacToeGameMode() {
        System.out.println("choice mode you would like to play: ");
        System.out.println("1. vs player");
        System.out.println("2. vs computer");
        int answer = scanner.nextInt();
        if (answer == 1) {
            ticTacToeMenageMode.playerVsPlayerMode();
        } else if (answer == 2) {
            ticTacToeMenageMode.playerVsComputerMode();
        }
    }

    public void ticTacToeBoard(char[][] board) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

}