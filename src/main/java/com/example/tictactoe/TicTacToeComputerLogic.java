package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToeComputerLogic {
    Random rnd = new Random();
    private int computerMoveX;
    private int computerMoveY;

    public int getComputerMoveX() {
        return computerMoveX;
    }

    public int getComputerMoveY() {
        return computerMoveY;
    }

    public void computerMove(char[][] board, int boardSize) {
        List<int[]> emptyFields = new ArrayList<>();
        for (int i = 0; i <= boardSize - 1; i++) {
            for (int j = 0; j <= boardSize - 1; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    emptyFields.add(new int[]{i, j});
                }
            }
        }
        if (emptyFields.size() > 0) {
            int[] move = emptyFields.get(rnd.nextInt(emptyFields.size()));
            computerMoveX = move[0];
            computerMoveY = move[1];
        }
        emptyFields.clear();

    }

}
