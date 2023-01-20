package com.example.tictactoe;

import java.util.Random;

public class TicTacToeLogic {
    TicTacToeGameState ticTacToeGameState = new TicTacToeGameState();

    public TicTacToeLogic(TicTacToeGameState ticTacToeGameState) {
        this.ticTacToeGameState = ticTacToeGameState;
    }

    private char move;
    private boolean xTurn;
    private boolean oTurn;
    private boolean endGame;
    private int currentRound = 0;

    public boolean isEndGame() {
        return endGame;
    }


    public int getCurrentRound() {
        return this.currentRound;
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

    public char currentMove() {
        if (xTurn) {
            move = 'X';
            xTurn = false;
            oTurn = true;

            return 'X';

        } else if (oTurn) {
            move = 'O';
            oTurn = false;
            xTurn = true;
            return 'O';
        }
        return move;
    }


    public void playMove(int x, int y, char move, char[][] board) {
        board[x][y] = move;
        ticTacToeGameState.setCurrentRound(getCurrentRound() + 1);
    }


    public boolean checkForDraw() {
        boolean result = false;
        if (ticTacToeGameState.getBoardSize() == 3) {
            if (ticTacToeGameState.getCurrentRound() == 9) {
                endGame = true;
                System.out.println("draw");
                result = true;
            }
        }
        if (ticTacToeGameState.getBoardSize() == 10) {
            if (ticTacToeGameState.getCurrentRound() == 100) {
                endGame = true;
                System.out.println("draw");
                result = true;
            }
        }
        return result;
    }

    public void managePlayerMove() {
        boolean fieldTaken;
        do {
            ticTacToeGameState.playerMoveOnX();
            ticTacToeGameState.playerMoveOnY();
            fieldTaken = ticTacToeGameState.isFieldTaken();
            if (!fieldTaken) {
                playMove(
                        ticTacToeGameState.getMoveOnX(),
                        ticTacToeGameState.getMoveOnY(),
                        currentMove(),
                        ticTacToeGameState.getBoard());
                fieldTaken = false;
            }
        } while (fieldTaken);
    }

    public boolean checkForWinInRows(char[][] board, int boardSize, char move, int x, int y) {
        int count = 0;
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[x][i] == move) {
                count++;
            }
            if (board[x][i] != move) {
                count = 0;
            }
            if (count == 3 && boardSize == 3) {
                endGame = true;
                return true;

            } else if (count == 5 && boardSize == 10) {
                endGame = true;
                return true;
            }
        }
        return false;
    }

    public boolean checkForWinInColumns(char[][] board, int boardSize, char move, int x, int y) {
        int count = 0;
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i][y] == move) {
                count++;
            }
            if (board[i][y] != move) {
                count = 0;
            }
            if (count == 3 && boardSize == 3) {
                return true;
            } else if (count == 5 && boardSize == 10) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForWinInFirstCross(char[][] board, int boardSize, char move, int x, int y) {
        int count = 0;
        for (int i = 0; i <= boardSize - 1; i++) {
            if (board[i][i] == move) {
                count++;
            }
            if (board[i][i] != move) {
                count = 0;
            }
            if (count == 3 && boardSize == 3) {
                return true;
            } else if (count == 5 && boardSize == 10) {
                return true;
            }
        }

        return false;
    }

    public boolean checkForWinInSecondCross(char[][] board, int boardSize, char move, int x, int y) {
        int count = 0;
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i][(board.length - 1) - i] == move) {
                count++;
            }
            if (board[i][(board.length - 1) - i] != move) {
                count = 0;
            }
            if (count == 3 && boardSize == 3) {
                return true;
            } else if (count == 5 && boardSize == 10) {
                return true;
            }
        }
        return false;
    }


    public boolean checkIfSomeOneWon() {
        if (ticTacToeGameState.getMoveOnX() == ticTacToeGameState.getMoveOnY()) {
            if (checkForWinInFirstCross(ticTacToeGameState.getBoard(),
                    ticTacToeGameState.getBoardSize(),
                    move,
                    ticTacToeGameState.getMoveOnX(),
                    ticTacToeGameState.getMoveOnY())) {
                endGame = true;
                return true;
            }
        }
        if (ticTacToeGameState.getMoveOnX() + ticTacToeGameState.getMoveOnY() == ticTacToeGameState.getBoardSize() - 1) {
            if (checkForWinInSecondCross(ticTacToeGameState.getBoard(),
                    ticTacToeGameState.getBoardSize(),
                    move,
                    ticTacToeGameState.getMoveOnX(),
                    ticTacToeGameState.getMoveOnY())) {
                endGame = true;
                return true;
            }
        }
        if (checkForWinInRows(ticTacToeGameState.getBoard(),
                ticTacToeGameState.getBoardSize(),
                move,
                ticTacToeGameState.getMoveOnX(),
                ticTacToeGameState.getMoveOnY()) ||
                checkForWinInColumns(ticTacToeGameState.getBoard(),
                        ticTacToeGameState.getBoardSize(),
                        move,
                        ticTacToeGameState.getMoveOnX(),
                        ticTacToeGameState.getMoveOnY())) {
            endGame = true;
            return true;
        }
        return false;
    }
}