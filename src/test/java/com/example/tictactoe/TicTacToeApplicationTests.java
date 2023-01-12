package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class TicTacToeApplicationTests {

    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
    List<List> winningMoves;

    public List<List> winningMoves() {
        winningMoves = new ArrayList<>();
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftSide = Arrays.asList(1, 4, 7);
        List middle = Arrays.asList(2, 5, 8);
        List rightSide = Arrays.asList(3, 6, 9);
        List firstCross = Arrays.asList(1, 5, 9);
        List secondCross = Arrays.asList(3, 5, 7);

        winningMoves.add(topRow);
        winningMoves.add(midRow);
        winningMoves.add(bottomRow);
        winningMoves.add(leftSide);
        winningMoves.add(middle);
        winningMoves.add(rightSide);
        winningMoves.add(firstCross);
        winningMoves.add(secondCross);
        return winningMoves;
    }

    @Test
    void playerXWinsInTopRow() {
        //Given
        List<Integer> xMoves = Arrays.asList(1, 2, 3);
        List<Integer> oMoves = Arrays.asList(8, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInMidRow() {
        //Given
        List<Integer> xMoves = Arrays.asList(4, 5, 6);
        List<Integer> oMoves = Arrays.asList(2, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInBottomRow() {
        //Given
        List<Integer> xMoves = Arrays.asList(7, 8, 9);
        List<Integer> oMoves = Arrays.asList(2, 4, 3);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInLeftSide() {
        //Given
        List<Integer> xMoves = Arrays.asList(1, 4, 7);
        List<Integer> oMoves = Arrays.asList(2, 5, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInMiddle() {
        //Given
        List<Integer> xMoves = Arrays.asList(2, 8, 5);
        List<Integer> oMoves = Arrays.asList(3, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerXWinsInRightSide() {
        //Given
        List<Integer> xMoves = Arrays.asList(3, 6, 9);
        List<Integer> oMoves = Arrays.asList(2, 4, 5);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInFirstCross() {
        //Given
        List<Integer> xMoves = Arrays.asList(1, 5, 9);
        List<Integer> oMoves = Arrays.asList(2, 4, 5);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerXWinsInSecondCross() {
        //Given
        List<Integer> xMoves = Arrays.asList(3, 5, 7);
        List<Integer> oMoves = Arrays.asList(2, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInTopRow() {
        //Given
        List<Integer> oMoves = Arrays.asList(1, 2, 3);
        List<Integer> xMoves = Arrays.asList(8, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInMidRow() {
        //Given
        List<Integer> oMoves = Arrays.asList(4, 5, 6);
        List<Integer> xMoves = Arrays.asList(2, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInBottomRow() {
        //Given
        List<Integer> oMoves = Arrays.asList(7, 8, 9);
        List<Integer> xMoves = Arrays.asList(2, 4, 3);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInLeftSide() {
        //Given
        List<Integer> oMoves = Arrays.asList(1, 4, 7);
        List<Integer> xMoves = Arrays.asList(2, 5, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInMiddle() {
        //Given
        List<Integer> oMoves = Arrays.asList(2, 8, 5);
        List<Integer> xMoves = Arrays.asList(3, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);

    }

    @Test
    void playerOWinsInRightSide() {
        //Given
        List<Integer> oMoves = Arrays.asList(3, 6, 9);
        List<Integer> xMoves = Arrays.asList(2, 4, 5);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInFirstCross() {
        //Given
        List<Integer> oMoves = Arrays.asList(1, 5, 9);
        List<Integer> xMoves = Arrays.asList(2, 4, 5);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void playerOWinsInSecondCross() {
        //Given
        List<Integer> oMoves = Arrays.asList(3, 5, 7);
        List<Integer> xMoves = Arrays.asList(2, 4, 9);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(winningMoves(), xMoves, oMoves);
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeDraw() {
       /* //Given
        TicTacToeData ticTacToeDataMock = Mockito.mock(TicTacToeData.class);
        List<Integer> playerO = Arrays.asList(1,2,3,4);
        List<Integer> playerX= Arrays.asList(1,2,3,4);
        //when
        Mockito.when(ticTacToeDataMock.getMovesOfXPlayer()).thenReturn(playerX);
        Mockito.when(ticTacToeDataMock.getMovesOfOPlayer()).thenReturn(playerO);
        boolean result = ticTacToeLogic.checkForDraw();
        //then
        Assertions.assertTrue(result);

        */
    }

    @Test
    void shouldThrowInputMissMatch() {
        //given
        //when
        //then
    }
}


