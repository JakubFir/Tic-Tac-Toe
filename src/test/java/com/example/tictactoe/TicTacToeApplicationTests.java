package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.when;


class TicTacToeApplicationTests {

    @Test
    void playerXWinsInTopRow() {
        //Given
        char xMove = 'X';
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';


        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInMidRow() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[1][0] = 'x';
        board[1][1] = 'x';
        board[1][2] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 1, 2);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInBottomRow() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[2][0] = 'x';
        board[2][1] = 'x';
        board[2][2] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 2, 2);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInLeftSide() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][0] = 'x';
        board[1][0] = 'x';
        board[2][0] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 0, 0);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInMiddle() {
        char[][] board = ticTacToeData.getBoard3x3();
        char xMove = 'x';
        board[0][1] = 'x';
        board[1][1] = 'x';
        board[2][1] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 0, 1);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInRightSide() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][2] = 'x';
        board[1][2] = 'x';
        board[2][2] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInFirstCross() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][0] = 'x';
        board[1][1] = 'x';
        board[2][2] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 2, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInSecondCross() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][2] = 'x';
        board[1][1] = 'x';
        board[2][0] = 'x';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, xMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }


    @Test
    void playerOWinsInTopRow() {
        //Given
        char oMove = 'O';
        board[0][0] = 'O';
        board[0][1] = 'O';
        board[0][2] = 'O';


        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInMidRow() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[1][0] = 'o';
        board[1][1] = 'o';
        board[1][2] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 1, 2);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInBottomRow() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[2][0] = 'o';
        board[2][1] = 'o';
        board[2][2] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 2, 2);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInLeftSide() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][0] = 'o';
        board[1][0] = 'o';
        board[2][0] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 0, 0);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInMiddle() {
        char[][] board = ticTacToeData.getBoard3x3();
        char oMove = 'o';
        board[0][1] = 'o';
        board[1][1] = 'o';
        board[2][1] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 0, 1);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInRightSide() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][2] = 'o';
        board[1][2] = 'o';
        board[2][2] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInFirstCross() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][0] = 'o';
        board[1][1] = 'o';
        board[2][2] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 2, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInSecondCross() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][2] = 'o';
        board[1][1] = 'o';
        board[2][0] = 'o';
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(board, 3, oMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeDrawOn3x3Board() {
        //when
        boolean result = ticTacToeLogic.checkForDraw(3, 9);
        //then
        Assertions.assertTrue(result);


    }

    @Test
    void shouldThrowInputMissMatch() {
        //given
        int boardSize = 1;
        TicTacToeMoveValidator ticTacToeMoveValidator = Mockito.mock(TicTacToeMoveValidator.class);
        //when
        when(ticTacToeMoveValidator.getNextMoveOnY(boardSize)).thenThrow(new InputMismatchException());
        //then
        Assertions.assertThrows(InputMismatchException.class, () -> ticTacToeMoveValidator.getNextMoveOnY(1));
    }

    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    TicTacToeData ticTacToeData = new TicTacToeData();
    char board[][] = ticTacToeData.getBoard3x3();
}


