package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TicTacToeGameStateTest {

    @Test
     void visualTest() {
        TicTacToeGameState gameStateMock = Mockito.mock(TicTacToeGameState.class);
        //given
        char[][] board2 = new char[3][3];
        when(gameStateMock.printCurrentStateOfBoard()).thenReturn(board2);
        //when
        char[][] expectedBoard = gameStateMock.printCurrentStateOfBoard();
        board2[0][0] = 'X';
        board2[1][1] = 'O';
        board2[2][2] = 'X';
        //then
        for (int i = 0; i < expectedBoard.length; i++) {
            for (int j = 0; j < expectedBoard[i].length; j++) {
                System.out.print("|" + expectedBoard[i][j] + "|");
            }
            System.out.println();
        }
        Assertions.assertArrayEquals(board2, expectedBoard);
    }
    @Test
     void fieldShouldBeFree() {
        //given
        TicTacToeGameState sut = new TicTacToeGameState();

        //when
        boolean result = sut.isFieldTaken();

        //then
        Assertions.assertFalse(result);
    }
    @Test
     void fieldShouldBeTaken() {
        //given
        TicTacToeGameState sut = new TicTacToeGameState();
        sut.setMoveOnX(1);
        sut.setMoveOnY(1);
        sut.getBoard()[1][1] = 'X';

        //when
        boolean result = sut.isFieldTaken();

        //then
        Assertions.assertTrue(result);
    }
}


