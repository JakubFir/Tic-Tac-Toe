package com.example.tictactoe;

public class TicTacToeMenu {
    TicTacToePlayerChoiceValidator ticTacToePlayerChoiceValidator = new TicTacToePlayerChoiceValidator();
    private int chosenGameMode;
    private int chosenBoardSize;

    public int getChosenGameMode() {
        return chosenGameMode;
    }

    public void setChosenGameMode(int chosenGameMode) {
        this.chosenGameMode = chosenGameMode;
    }

    public void choiceMenuBetweenComputerOrPlayer() {
        System.out.println("choice mode you would like to play: ");
        System.out.println("1. vs player");
        System.out.println("2. vs computer");
        chosenGameMode = ticTacToePlayerChoiceValidator.validateMenuChoice();
        setChosenGameMode(chosenGameMode);
    }


    public void setChosenBoardSize(int chosenBoardSize) {
        this.chosenBoardSize = chosenBoardSize;
    }

    public int getChosenBoardSize() {
        return chosenBoardSize;
    }

    public void gameInstructions() {
        System.out.println("Make moves on rows and columns");
        System.out.println("Each box has hes own coordinates");
        System.out.print("  " + 0);
        System.out.print(" " + 1);
        System.out.print(" " + 2 + " ");
        System.out.println();
        for (int i = 0; i <= 2; i++) {
            System.out.print(i);
            for (int j = 0; j <= 2; j++) {
                System.out.print("|" + " ");
            }
            System.out.println("|");
        }
        System.out.println("Good luck !");
        System.out.println();
    }

    public void choiceBoardSize() {
        System.out.println("Choice board size: ");
        System.out.println("1. 3x3");
        System.out.println("2. 10x10");
        chosenBoardSize = ticTacToePlayerChoiceValidator.validateMenuChoice();
        setChosenBoardSize(chosenBoardSize);
    }


    public char[][] ticTacToeBoard(char[][] board, int boardSize) {
        for (int i = 0; i <= boardSize - 1; i++) {
            for (int j = 0; j <= boardSize - 1; j++) {
                if (board[i][j] != 'O' && board[i][j] != 'X') {
                    System.out.print("|" + ' ');
                } else {
                    System.out.print("|" + board[i][j]);
                }
            }
            System.out.println("|");
        }
        return board;
    }


}