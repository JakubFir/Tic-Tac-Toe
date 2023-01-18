package com.example.tictactoe;

public class TicTacToeGameState {
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeComputerLogic ticTacToeComputerLogic = new TicTacToeComputerLogic();

    public TicTacToeGameState(TicTacToeLogic ticTacToeLogic) {
        this.ticTacToeLogic = ticTacToeLogic;
    }

    TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    TicTacToeData ticTacToeData = new TicTacToeData();
    private boolean computerMode = false;

    private int boardSize = ticTacToeLogic.boardSize(ticTacToeMenu.choiceBoardSize());

    public boolean isComputerMode() {
        return computerMode;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public char whosTurn() {
        return ticTacToeLogic.getMove();
    }

    public void setComputerMode(boolean computerMode) {
        this.computerMode = computerMode;
    }

    public boolean isComputerModeOn(Integer mode) {
        if (mode == 2) {
            setComputerMode(true);
            return computerMode;
        }
        return computerMode;
    }

    public char[][] currentStateOfBoard() {
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

    public void checkIfComputerMode(int moveOnX, int moveOnY) {
        if (isComputerMode()) {
            ticTacToeComputerLogic.computerMove(choicedBoard(), getBoardSize());
            ticTacToeLogic.manageMove(ticTacToeComputerLogic.getComputerMoveX(),
                    ticTacToeComputerLogic.getComputerMoveY(),
                    ticTacToeLogic.currentMove(),
                    choicedBoard());
        }
        if (!ticTacToeLogic.checkIfSomeOneWon(choicedBoard(), getBoardSize(), whosTurn(), moveOnX, moveOnY)) {
            ticTacToeLogic.checkForDraw(getBoardSize(), getCurrentRound());
        }
    }
}
