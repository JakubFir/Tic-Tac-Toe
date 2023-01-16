package com.example.tictactoe;

import java.util.Random;

public class TicTacToeLogic {

    private char move;
    private boolean xTurn;
    private boolean oTurn;
    public int currentRound = 0;

    public boolean isEndGame() {
        return endGame;
    }

    public char getMove() {
        return move;
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


    public void menageMove(int x, int y, char move, char[][] board) {
        board[x][y] = move;
        currentRound++;

    }

    public boolean isFieldTaken(int x, int y, char[][] board) {
        boolean isFieldTaken = false;
        if (board[x][y] == 'X' || board[x][y] == 'O') {
            System.out.println("field taken");
            isFieldTaken = true;
        } else {
            isFieldTaken = false;
        }
        return isFieldTaken;
    }

    public int boardSize(int choice) {

        if (choice == 1) {
            choice = 3;
        } else if (choice == 2) {
            choice = 10;
        }
        return choice;
    }

    public char[][] getBoard(char[][] board3X3, char[][] board10x10, int choice) {
        if (choice == 1) {
            return board3X3;
        } else
            return board10x10;
    }

    public boolean checkForDraw(int boardSize, int currentRound) {
        boolean result = false;
        if (boardSize == 3) {
            if (currentRound == 9) {
                endGame = true;
                System.out.println("draw");
                result = true;
            }
        } else if (boardSize == 10) {
            if (currentRound == 100) {
                endGame = true;
                System.out.println("draw");
                result = true;
            }
        }
        return result;
    }


    public boolean checkIfSomeOneWon(char[][] board, int boardSize, char move, int x, int y) {
        int count = 0;
        System.out.println(move);
        //Checks rows
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
        count = 0;
        for (int i = 0; i <= board.length - 1; i++) {
            if (board[i][y] == move) {
                count++;
            }
            if (board[i][y] != move) {
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

        count = 0;
        if (x == y) {
            for (int i = 0; i <= board.length - 1; i++) {
                if (board[i][i] == move) {
                    count++;
                }
                if (board[i][i] != move) {
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

        }
        count = 0;
        if (x + y == board.length - 1) {
            for (int i = 0; i <= board.length - 1; i++) {
                if (board[i][(board.length - 1) - i] == move) {
                    count++;
                }
                if (board[i][(board.length - 1) - i] != move) {
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
        }

        return false;
    }
}