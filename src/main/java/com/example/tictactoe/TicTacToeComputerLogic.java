package com.example.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeComputerLogic {

    TicTacToeData ticTacToeData = new TicTacToeData();
    private List<Integer> computerMoves = new ArrayList<>();
    int computerMove;

    public int getComputerMove() {
        return computerMove;
    }

    Random rnd = new Random();

    public void addComputerMove(int move) {
        this.computerMoves.add(move);
    }

    public List<Integer> getComputerMoves() {
        return computerMoves;
    }


    public Integer computerMove(List<Integer> playerMoves) {
        do {
            computerMove = rnd.nextInt(1, 9);
            System.out.println(ticTacToeData.getMovesOfXPlayer());
        } while (getComputerMoves().contains(getComputerMove()) || playerMoves.contains(computerMove));

        return computerMove;
    }
}
