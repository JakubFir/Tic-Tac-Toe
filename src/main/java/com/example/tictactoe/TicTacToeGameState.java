package com.example.tictactoe;

public class TicTacToeGameState {
    TicTacToePlayerChoiceValidator ticTacToeMoveValidator = new TicTacToePlayerChoiceValidator();
    TicTacToeData ticTacToeData = new TicTacToeData();
    private boolean computerMode;
    private int boardSize;
    private int moveOnX;
    private int moveOnY;
    private int currentRound;

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    private int chosenGameMode;

    public void setChosenGameMode(int chosenGameMode) {
        this.chosenGameMode = chosenGameMode;
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



    public char[][] getBoard() {
        if (boardSize == 3) {
            return ticTacToeData.getBoard3x3();
        } else if (boardSize == 10) {
            return ticTacToeData.getBoard10x10();
        }
        return ticTacToeData.getBoard3x3();
    }

    public void chosenBoardSize() {
        int choice = getBoardSize();
        if (choice == 1) {
            setBoardSize(3);
        } else if (choice == 2) {
            setBoardSize(10);
        }
    }

    public int getCurrentRound() {
        return currentRound;
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


    public void manageGameMode() {
        if (chosenGameMode == 2) {
            setComputerMode(true);
        }
    }

    public char[][] printCurrentStateOfBoard() {
        chosenBoardSize();
        char[][] board = getBoard();
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
    public boolean isFieldTaken() {
        boolean isFieldTaken;
        if (getBoard()[moveOnX][moveOnY] == 'X' || getBoard()[moveOnX][moveOnY] == 'O') {
            System.out.println("field taken");
            isFieldTaken = true;
        } else {
            isFieldTaken = false;
        }
        return isFieldTaken;
    }

}
