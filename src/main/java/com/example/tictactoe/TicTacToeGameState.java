package com.example.tictactoe;

public class TicTacToeGameState {
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeComputerLogic ticTacToeComputerLogic = new TicTacToeComputerLogic();
    TicTacToePlayerChoiceValidator ticTacToeMoveValidator = new TicTacToePlayerChoiceValidator();

    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeData ticTacToeData = new TicTacToeData();
    private boolean computerMode;
    private int gameMode;
    private int boardSize;
    private int moveOnX;
    private int moveOnY;

    public TicTacToeGameState(TicTacToeLogic ticTacToeLogic) {
        this.ticTacToeLogic = ticTacToeLogic;
    }

    public int getMoveOnX() {
        return moveOnX;
    }

    public int getMoveOnY() {
        return moveOnY;
    }

    public void playerMoveOnX() {
        moveOnX = ticTacToeMoveValidator.getNextMoveOnX(getBoardSize());
    }

    public void playerMoveOnY() {
        moveOnY = ticTacToeMoveValidator.getNextMoveOnY(getBoardSize());
    }


    public boolean isComputerModeOn() {
        return computerMode;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public char whoseTurn() {
        return ticTacToeLogic.getMove();
    }

    public void setComputerMode(boolean computerMode) {
        this.computerMode = computerMode;
    }

    public void manageGameMode() {
        if (gameMode == 2) {
            setComputerMode(true);
        }
    }

    public void playerBoardChoice() {
        boardSize = ticTacToeLogic.boardSize(ticTacToeMenu.choiceBoardSize());
    }

    public void playerChoiceBetweenMode() {
        gameMode = ticTacToeMenu.choiceMenuBetweenComputerOrPlayer();
        manageGameMode();
    }

    public char[][] printCurrentStateOfBoard() {
        char[][] state = ticTacToeMenu.ticTacToeBoard(choicedBoard(), boardSize);
        return state;
    }

    public char[][] choicedBoard() {
        return ticTacToeLogic.getBoard(ticTacToeData.getBoard3x3(), ticTacToeData.getBoard10x10(), boardSize);
    }

    public boolean isFieldTaken(int x, int y, char[][] board) {
        return ticTacToeLogic.isFieldTaken(x, y, board);
    }

    public int getCurrentRound() {
        return ticTacToeLogic.getCurrentRound();

    }

    public void computerMove(int moveOnX, int moveOnY) {
        ticTacToeComputerLogic.computerMove(choicedBoard(), getBoardSize());
        ticTacToeLogic.playMove(
                ticTacToeComputerLogic.getComputerMoveX(),
                ticTacToeComputerLogic.getComputerMoveY(),
                ticTacToeLogic.currentMove(),
                choicedBoard());
        if (!ticTacToeLogic.checkIfSomeOneWon(choicedBoard(), getBoardSize(), whoseTurn(), moveOnX, moveOnY)) {
            ticTacToeLogic.checkForDraw(getBoardSize(), getCurrentRound());
        }
    }
}
