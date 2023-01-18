package com.example.tictactoe;

import java.util.Random;

public class TicTacToeLogic {

    private char move;
    private boolean xTurn;
    private boolean oTurn;
    private int currentRound;

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public char getMove() {
        return move;
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    private boolean endGame;


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


    public void manageMove(int x, int y, char move, char[][] board) {
        board[x][y] = move;
        setCurrentRound(getCurrentRound() + 1);
    }

    public boolean isFieldTaken(int x, int y, char[][] board) {
        boolean isFieldTaken;
        if (board[x][y] == 'X' || board[x][y] == 'O') {
            System.out.println("field taken");
            isFieldTaken = true;
        } else {
            isFieldTaken = false;
        }
        return isFieldTaken;
    }

    public int boardSize(int choice) {
        int boardSize = 0;
        if (choice == 1) {
            boardSize = 3;
        } else if (choice == 2) {
            boardSize = 10;
        }
        return boardSize;
    }

    public char[][] getBoard(char[][] board3X3, char[][] board10x10, int boardSize) {
        if (boardSize == 3) {
            return board3X3;
        } else if (boardSize == 10) {
            return board10x10;
        }
        return null;
    }

    public boolean checkForDraw(int boardSize, int currentRound) {
        boolean result = false;
        if (boardSize == 3) {
            if (currentRound == 9) {
                endGame = true;
                System.out.println("draw");
                result = true;
            }
        }
        if (boardSize == 10) {
            if (currentRound == 100) {
                endGame = true;
                System.out.println("draw");
                result = true;
            }
        }
        return result;
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
        for (int i = 0; i <= board.length - 1; i++) {
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


    public boolean checkIfSomeOneWon(char[][] board, int boardSize, char move, int x, int y) {
        if (x == y) {
            if (checkForWinInFirstCross(board, boardSize, move, x, y)) {
                endGame = true;
                return true;
            }
        }
        if (x + y == boardSize - 1) {
            if (checkForWinInSecondCross(board, boardSize, move, x, y)) {
                endGame = true;
                return true;
            }
        }
        if (checkForWinInRows(board, boardSize, move, x, y) ||
                checkForWinInColumns(board, boardSize, move, x, y)) {
            endGame = true;
            return true;
        }
        return false;
    }
}