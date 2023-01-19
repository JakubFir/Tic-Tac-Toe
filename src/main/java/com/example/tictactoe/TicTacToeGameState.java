package com.example.tictactoe;

public class TicTacToeGameState {
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeComputerLogic ticTacToeComputerLogic = new TicTacToeComputerLogic();
    TicTacToePlayerChoiceValidator ticTacToeMoveValidator = new TicTacToePlayerChoiceValidator();

    TicTacToeData ticTacToeData = new TicTacToeData();
    private boolean computerMode;
    private int boardSize;
    private int moveOnX;
    private int moveOnY;

    public TicTacToeGameState(TicTacToeLogic ticTacToeLogic, TicTacToeMenu ticTacToeMenu) {
        this.ticTacToeLogic = ticTacToeLogic;
        this.ticTacToeMenu = ticTacToeMenu;
    }

    public int getMoveOnX() {
        return moveOnX;
    }

    public int getMoveOnY() {
        return moveOnY;
    }

    public void setMoveOnX(int moveOnX) {
        this.moveOnX = moveOnX;
    }

    public void setMoveOnY(int moveOnY) {
        this.moveOnY = moveOnY;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getCurrentRound() {
        return ticTacToeLogic.getCurrentRound();

    }

    public char[][] getBoard() {
        if (boardSize == 3) {
            return ticTacToeData.getBoard3x3();
        } else if (boardSize == 10) {
            return ticTacToeData.getBoard10x10();
        }
        return ticTacToeData.getBoard3x3();
    }

    public void chosenBoardSize() {
        int choice = ticTacToeMenu.getChosenBoardSize();
        if (choice == 1) {
            setBoardSize(3);
        } else if (choice == 2) {
            setBoardSize(10);
        }
    }

    public void playerMoveOnX() {
        setMoveOnX(ticTacToeMoveValidator.getNextMoveOnX(getBoardSize()));
    }

    public void playerMoveOnY() {
        setMoveOnY(ticTacToeMoveValidator.getNextMoveOnY(getBoardSize()));
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setComputerMode(boolean computerMode) {
        this.computerMode = computerMode;
    }


    public boolean isComputerModeOn() {
        return computerMode;
    }

    public char whoseTurn() {
        return ticTacToeLogic.getMove();
    }


    public void manageGameMode() {
        if (ticTacToeMenu.getChosenGameMode() == 2) {
            setComputerMode(true);
        }
    }

    public char[][] printCurrentStateOfBoard() {
        chosenBoardSize();
        char[][] state = ticTacToeMenu.ticTacToeBoard(getBoard(), boardSize);
        return state;
    }


    public boolean isFieldTaken(int x, int y, char[][] board) {
        return ticTacToeLogic.isFieldTaken(x, y, board);
    }


    public void computerMove() {
        ticTacToeComputerLogic.computerMove(getBoard(), boardSize);
        setMoveOnX(ticTacToeComputerLogic.getComputerMoveX());
        setMoveOnY(ticTacToeComputerLogic.getComputerMoveY());
        ticTacToeLogic.playMove(
                getMoveOnX(),
                getMoveOnY(),
                ticTacToeLogic.currentMove(),
                getBoard());
        ticTacToeLogic.checkIfSomeOneWon(this);
    }
}
