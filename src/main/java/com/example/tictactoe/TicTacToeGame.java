package com.example.tictactoe;

public class TicTacToeGame {
    private boolean computerMode = false;
    private boolean fieldTaken;
    TicTacToeData ticTacToeData = new TicTacToeData();
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeMoveValidator ticTacToeMoveValidator = new TicTacToeMoveValidator();
    TicTacToeComputerLogic ticTacToeComputerLogic = new TicTacToeComputerLogic();
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    int moveOnX;
    int moveOnY;
    int boardSize = ticTacToeLogic.boardSize(ticTacToeMenu.choiceBoardSize());
    char[][] board = ticTacToeLogic.getBoard(ticTacToeData.getBoard3x3(), ticTacToeData.getBoard10x10(), boardSize);

    public void checkIfComputerMode() {
        if (computerMode) {
            ticTacToeComputerLogic.computerMove(board, boardSize);
            ticTacToeLogic.menageMove(ticTacToeComputerLogic.getComputerMoveX(),
                    ticTacToeComputerLogic.getComputerMoveY(),
                    ticTacToeLogic.currentMove(),
                    board);
        }
        if (!ticTacToeLogic.checkIfSomeOneWon(board, boardSize, ticTacToeLogic.getMove(), moveOnX, moveOnY)) {
            ticTacToeLogic.checkForDraw(boardSize, ticTacToeLogic.currentRound);
        }
    }

    public void setComputerMode(boolean computerMode) {
        this.computerMode = computerMode;
    }

    public void startGame() {
        if (ticTacToeMenu.ticTacToeGameMode() == 2) {
            setComputerMode(true);
        }
        ticTacToeMenu.gameInstructions();
        ticTacToeLogic.randomStart();
        do {
            ticTacToeMenu.ticTacToeBoard(board, boardSize);
            do {
                moveOnX = ticTacToeMoveValidator.getNextMoveOnX(boardSize);
                moveOnY = ticTacToeMoveValidator.getNextMoveOnY(boardSize);
                fieldTaken = true;
                if (!ticTacToeLogic.isFieldTaken(moveOnX, moveOnY, board)) {
                    ticTacToeLogic.menageMove(moveOnX, moveOnY, ticTacToeLogic.currentMove(), board);
                    fieldTaken = false;
                }
            } while (fieldTaken);
            if (!ticTacToeLogic.checkIfSomeOneWon(board, boardSize, ticTacToeLogic.getMove(), moveOnX, moveOnY)) {
                ticTacToeLogic.checkForDraw(boardSize, ticTacToeLogic.currentRound);
            }
            checkIfComputerMode();
        } while (!ticTacToeLogic.isEndGame());
        ticTacToeMenu.ticTacToeBoard(board, boardSize);
    }
}


