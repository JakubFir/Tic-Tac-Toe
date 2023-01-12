package com.example.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeData {

    private List<Integer> movesOfXPlayer = new ArrayList<>();
    private List<Integer> movesOfOPlayer = new ArrayList<>();

    private List<List> winningMoves;

    private char[][] board3x3 = new char[3][3];
    private char[][] board10x10 = new char[10][10];


    public char[][] getBoard3x3() {
        return board3x3;
    }

    public void addMoveOfXPlayer(int move) {
        this.movesOfXPlayer.add(move);
    }

    public void addMoveOfOPlayer(int move) {
        this.movesOfOPlayer.add(move);
    }

    public List<Integer> getMovesOfXPlayer() {
        return this.movesOfXPlayer;
    }

    public List<Integer> getMovesOfOPlayer() {
        return movesOfOPlayer;
    }

    public void setMove(int i, int j, char move) {
        board3x3[i][j] = move;
    }

    private List<List> winningMoves() {
        winningMoves = new ArrayList<>();
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftSide = Arrays.asList(1, 4, 7);
        List middle = Arrays.asList(2, 5, 8);
        List rightSide = Arrays.asList(3, 6, 9);
        List firstCross = Arrays.asList(1, 5, 9);
        List secondCross = Arrays.asList(3, 5, 7);

        winningMoves.add(topRow);
        winningMoves.add(midRow);
        winningMoves.add(bottomRow);
        winningMoves.add(leftSide);
        winningMoves.add(middle);
        winningMoves.add(rightSide);
        winningMoves.add(firstCross);
        winningMoves.add(secondCross);
        return winningMoves;
    }

    public List<List> getWinningMoves() {
        return winningMoves();
    }

}