package com.example.tictactoe;

public class TicTacToeMenu {
    TicTacToeGameState ticTacToeGameState;
    TicTacToePlayerChoiceValidator ticTacToePlayerChoiceValidator = new TicTacToePlayerChoiceValidator();

    public TicTacToeMenu(TicTacToeGameState ticTacToeGameState) {
        this.ticTacToeGameState = ticTacToeGameState;
    }

    private int chosenGameMode;
    private int chosenBoardSize;

    public void choiceMenuBetweenComputerOrPlayer() {
        System.out.println("choice mode you would like to play: ");
        System.out.println("1. vs player");
        System.out.println("2. vs computer");
        chosenGameMode = ticTacToePlayerChoiceValidator.validateMenuChoice();
        ticTacToeGameState.setChosenGameMode(chosenGameMode);
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
        ticTacToeGameState.setBoardSize(chosenBoardSize);
    }





}