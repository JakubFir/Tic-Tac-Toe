package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToeComputerLogic {
    TicTacToeGameState ticTacToeGameState;
    TicTacToeLogic ticTacToeLogic;
    public TicTacToeComputerLogic(TicTacToeGameState ticTacToeGameState,TicTacToeLogic ticTacToeLogic) {
        this.ticTacToeGameState = ticTacToeGameState;
        this.ticTacToeLogic = ticTacToeLogic;
    }

    Random rnd = new Random();

    public int[] computerMove() {
        int[] move = null;
        List<int[]> emptyFields = new ArrayList<>();
        for (int i = 0; i <= ticTacToeGameState.getBoardSize() - 1; i++) {
            for (int j = 0; j <= ticTacToeGameState.getBoardSize() - 1; j++) {
                if (ticTacToeGameState.getBoard()[i][j] != 'X' && ticTacToeGameState.getBoard()[i][j] != 'O') {
                    emptyFields.add(new int[]{i, j});
                }
            }
        }
        if (emptyFields.size() > 0) {
             move = emptyFields.get(rnd.nextInt(emptyFields.size()));
            ticTacToeGameState.setMoveOnX(move[0]);
            ticTacToeGameState.setMoveOnY(move[1]);
        }
        emptyFields.clear();
    return move;
    }
     public void manageComputerMoves(){
        computerMove();
        ticTacToeLogic.playMove(
                ticTacToeGameState.getMoveOnX(),
                ticTacToeGameState.getMoveOnY(),
                ticTacToeLogic.currentMove(),
                ticTacToeGameState.getBoard());
        ticTacToeLogic.checkIfSomeOneWon();
    }
}
