package com.example.tictactoe;

import java.util.List;
import java.util.Random;

public class TicTacToeLogic {
    TicTacToeData ticTacToeData = new TicTacToeData();
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeMoveValidator ticTacToeMoveValidator = new TicTacToeMoveValidator();
    private char move;
    private boolean xTurn;
    private boolean oTurn;
    private boolean endGame;


    public void gameStart() {
        ticTacToeMenu.ticTacToeBoard(ticTacToeData.getMovesBoard());
        randomStart();
        do {
            ticTacToeMoveValidator.validateMove();
            if (!isFieldTaken(ticTacToeMoveValidator.getMove())) {
                makeMove(ticTacToeMoveValidator.getMove());
                ticTacToeMenu.ticTacToeBoard(ticTacToeData.getMovesBoard());
            }
        } while (!endGame);
    }

    private void randomStart() {
        Random rnd = new Random();
        int randomStart = rnd.nextInt(1, 3);
        if (randomStart == 1) {
            xTurn = true;
        }
        if (randomStart == 2) {
            oTurn = true;
        }
    }

    private char currentMove() {
        if (xTurn) {
            move = 'X';
            xTurn = false;
            oTurn = true;
            ticTacToeData.addMoveOfXPlayer(ticTacToeMoveValidator.getMove());
            checkIfSomeOneWon(ticTacToeData.getWinningMoves(), ticTacToeData.getMovesOfXPlayer());
            return 'X';

        } else if (oTurn) {
            move = 'O';
            oTurn = false;
            xTurn = true;
            ticTacToeData.addMoveOfOPlayer(ticTacToeMoveValidator.getMove());
            checkIfSomeOneWon(ticTacToeData.getWinningMoves(), ticTacToeData.getMovesOfOPlayer());
            return 'O';
        }
        return move;
    }

    private void makeMove(int move) {
        switch (move) {
            case 1 -> ticTacToeData.setMove(0, 0, currentMove());
            case 2 -> ticTacToeData.setMove(0, 1, currentMove());
            case 3 -> ticTacToeData.setMove(0, 2, currentMove());
            case 4 -> ticTacToeData.setMove(1, 0, currentMove());
            case 5 -> ticTacToeData.setMove(1, 1, currentMove());
            case 6 -> ticTacToeData.setMove(1, 2, currentMove());
            case 7 -> ticTacToeData.setMove(2, 0, currentMove());
            case 8 -> ticTacToeData.setMove(2, 1, currentMove());
            case 9 -> ticTacToeData.setMove(2, 2, currentMove());
        }
    }

    private boolean isFieldTaken(int move) {
        boolean isFieldTaken;
        if (ticTacToeData.getMovesOfOPlayer().contains(move) || ticTacToeData.getMovesOfXPlayer().contains(move)) {
            System.out.println("field taken");
            isFieldTaken = true;
        } else {
            isFieldTaken = false;
        }
        return isFieldTaken;
    }

    public boolean checkIfSomeOneWon(List<List> winningMoves, List<Integer> playerMoves) {
        for (List list : winningMoves) {
            if (playerMoves.containsAll(list)) {
                System.out.println("winner is " + move);
                endGame = true;
                return true;
            }
        }
        return false;
    }
}