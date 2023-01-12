package com.example.tictactoe;

import java.util.List;
import java.util.Random;

public class TicTacToeLogic {
    TicTacToeData ticTacToeData = new TicTacToeData();
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeMoveValidator ticTacToeMoveValidator = new TicTacToeMoveValidator();
    TicTacToeComputerLogic ticTacToeComputerLogic = new TicTacToeComputerLogic();
    private char move;
    private boolean xTurn;
    private boolean oTurn;
    private boolean playerTurn;
    private boolean computerTurn;

    private boolean computerMode = false;
    private boolean endGame;

    public void setComputerMode(boolean computerMode) {
        this.computerMode = computerMode;
    }

    public void randomStart() {
        Random rnd = new Random();
        int randomStart = rnd.nextInt(1, 3);
        if (randomStart == 1) {
            xTurn = true;
        }
        if (randomStart == 2) {
            oTurn = true;
        }
    }

    public void gameStart(boolean computerMode) {
        ticTacToeMenu.ticTacToeBoard(ticTacToeData.getBoard3x3());
        if (!computerMode) {
            randomStart();
            do {
                if (!checkIfSomeOneWon(ticTacToeData.getWinningMoves(), ticTacToeData.getMovesOfXPlayer(), ticTacToeData.getMovesOfOPlayer()) && !checkForDraw()) {
                    ticTacToeMoveValidator.validateMove();
                    if (!isFieldTaken(ticTacToeMoveValidator.getMove())) {
                        menageMove(ticTacToeMoveValidator.getMove(), currentMove());
                        ticTacToeMenu.ticTacToeBoard(ticTacToeData.getBoard3x3());
                    }
                }
            } while (!endGame);
        } else if (computerMode) {
            do {
                if (!checkIfSomeOneWon(ticTacToeData.getWinningMoves(),
                        ticTacToeData.getMovesOfXPlayer(),
                        ticTacToeComputerLogic.getComputerMoves())
                        && !checkForDraw()) {
                    do {
                        playerTurn = true;
                        ticTacToeMoveValidator.validateMove();
                        if (!isFieldTaken(ticTacToeMoveValidator.getMove())) {
                            menageMove(ticTacToeMoveValidator.getMove(), 'X');
                            ticTacToeData.addMoveOfXPlayer(ticTacToeMoveValidator.getMove());
                            playerTurn = false;
                        }
                    } while (playerTurn);
                }
                if (!checkIfSomeOneWon(ticTacToeData.getWinningMoves(),
                        ticTacToeData.getMovesOfXPlayer(),
                        ticTacToeComputerLogic.getComputerMoves())
                        && !checkForDraw()) {
                    do {
                        computerTurn = true;
                        ticTacToeComputerLogic.computerMove(ticTacToeData.getMovesOfXPlayer());
                        menageMove(ticTacToeComputerLogic.getComputerMove(), 'O');
                        ticTacToeComputerLogic.addComputerMove(ticTacToeComputerLogic.getComputerMove());
                        computerTurn = false;

                    } while (computerTurn);
                }
                ticTacToeMenu.ticTacToeBoard(ticTacToeData.getBoard3x3());
            } while (!endGame);
        }
    }

    private char currentMove() {
        if (xTurn) {
            move = 'X';
            xTurn = false;
            oTurn = true;
            ticTacToeData.addMoveOfXPlayer(ticTacToeMoveValidator.getMove());
            return 'X';

        } else if (oTurn) {
            move = 'O';
            oTurn = false;
            xTurn = true;
            ticTacToeData.addMoveOfOPlayer(ticTacToeMoveValidator.getMove());
            return 'O';
        }
        return move;
    }

    public void menageMove(int place, char move) {
        switch (place) {
            case 1 -> ticTacToeData.setMove(0, 0, move);
            case 2 -> ticTacToeData.setMove(0, 1, move);
            case 3 -> ticTacToeData.setMove(0, 2, move);
            case 4 -> ticTacToeData.setMove(1, 0, move);
            case 5 -> ticTacToeData.setMove(1, 1, move);
            case 6 -> ticTacToeData.setMove(1, 2, move);
            case 7 -> ticTacToeData.setMove(2, 0, move);
            case 8 -> ticTacToeData.setMove(2, 1, move);
            case 9 -> ticTacToeData.setMove(2, 2, move);
        }
    }

    public boolean isFieldTaken(int move) {
        boolean isFieldTaken = false;
        if (!computerMode) {
            if (ticTacToeData.getMovesOfOPlayer().contains(move) || ticTacToeData.getMovesOfXPlayer().contains(move)) {
                System.out.println("field taken");
                isFieldTaken = true;
            } else {
                isFieldTaken = false;
            }
        }
        if (computerMode) {
            if (ticTacToeComputerLogic.getComputerMoves().contains(move) || ticTacToeData.getMovesOfXPlayer().contains(move)) {
                System.out.println("field taken");
                isFieldTaken = true;
            } else {
                isFieldTaken = false;
            }
        }
        return isFieldTaken;
    }


    public boolean checkForDraw() {
        if (ticTacToeData.getMovesOfXPlayer().size() + ticTacToeComputerLogic.getComputerMoves().size() == 9) {
            System.out.println("draw");
            endGame = true;
            return true;
        } else if (ticTacToeData.getMovesOfXPlayer().size() + ticTacToeData.getMovesOfOPlayer().size() == 9) {
            System.out.println("draw");
            endGame = true;
            return true;
        }
        return false;
    }

    public boolean checkIfSomeOneWon(List<List> winningMoves, List<Integer> playerMoves, List<Integer> secondPlayer) {
        for (List list : winningMoves) {
            if (playerMoves.containsAll(list)) {
                System.out.println("winner is " + 'X');
                System.out.println("won in " + list);
                endGame = true;
                return true;
            } else if (secondPlayer.containsAll(list)) {
                System.out.println("winner is " + 'O');
                System.out.println("won in " + list);
                endGame = true;
                return true;
            }
        }
        return false;
    }
}