package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TicTacToeLogicClassTests {

    TicTacToeGameState ticTacToeGameStateMock = Mockito.mock(TicTacToeGameState.class);
    TicTacToeLogic sut = new TicTacToeLogic(ticTacToeGameStateMock);
    TicTacToeData ticTacToeData = new TicTacToeData();

    @Test
    void playerXWinsInTopRow() {
        //Given
        char board[][] = new char[3][3];
        char xMove = 'X';
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        //When
        boolean result = sut.checkForWinInRows(board, 3, xMove, 0, 2);
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
        boolean result = sut.checkForWinInRows(board, 3, xMove, 1, 0);
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
        boolean result = sut.checkForWinInRows(board, 3, xMove, 2, 0);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInLeftColumn() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][0] = 'x';
        board[1][0] = 'x';
        board[2][0] = 'x';
        //When
        boolean result = sut.checkForWinInColumns(board, 3, xMove, 0, 0);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInMidColumn() {
        char[][] board = ticTacToeData.getBoard3x3();
        char xMove = 'x';
        board[0][1] = 'x';
        board[1][1] = 'x';
        board[2][1] = 'x';
        //When
        boolean result = sut.checkForWinInColumns(board, 3, xMove, 0, 1);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInRightColumn() {
        //Given
        char xMove = 'x';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][2] = 'x';
        board[1][2] = 'x';
        board[2][2] = 'x';
        //When
        boolean result = sut.checkForWinInColumns(board, 3, xMove, 0, 2);
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
        boolean result = sut.checkForWinInFirstCross(board, 3, xMove, 0, 0);
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
        boolean result = sut.checkForWinInSecondCross(board, 3, xMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }


    @Test
    void playerOWinsInTopRow() {
        //Given
        char board[][] = ticTacToeData.getBoard3x3();
        char oMove = 'O';
        board[0][0] = 'O';
        board[0][1] = 'O';
        board[0][2] = 'O';


        //When
        boolean result = sut.checkForWinInRows(board, 3, oMove, 0, 0);
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
        boolean result = sut.checkForWinInRows(board, 3, oMove, 1, 0);
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
        boolean result = sut.checkForWinInRows(board, 3, oMove, 2, 0);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInLeftColumn() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][0] = 'o';
        board[1][0] = 'o';
        board[2][0] = 'o';
        //When
        boolean result = sut.checkForWinInColumns(board, 3, oMove, 0, 0);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInMidColumn() {
        char[][] board = ticTacToeData.getBoard3x3();
        char oMove = 'o';
        board[0][1] = 'o';
        board[1][1] = 'o';
        board[2][1] = 'o';
        //When
        boolean result = sut.checkForWinInColumns(board, 3, oMove, 0, 1);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInRightColumn() {
        //Given
        char oMove = 'o';
        char[][] board = ticTacToeData.getBoard3x3();
        board[0][2] = 'o';
        board[1][2] = 'o';
        board[2][2] = 'o';
        //When
        boolean result = sut.checkForWinInColumns(board, 3, oMove, 0, 2);
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
        boolean result = sut.checkForWinInFirstCross(board, 3, oMove, 0, 0);
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
        boolean result = sut.checkForWinInSecondCross(board, 3, oMove, 0, 2);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeDrawOn3x3Board() {
        when(ticTacToeGameStateMock.getBoardSize()).thenReturn(3);
        when(ticTacToeGameStateMock.getCurrentRound()).thenReturn(9);
        //when
        boolean result = sut.checkForDraw();
        //then
        Assertions.assertTrue(result);


    }
}



