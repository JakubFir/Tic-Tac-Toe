package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TicTacToeComputerLogicTest {
    TicTacToeData ticTacToeData = new TicTacToeData();
    TicTacToeGameState ticTacToeGameState = Mockito.mock(TicTacToeGameState.class);
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic(ticTacToeGameState);
    TicTacToeComputerLogic sut = new TicTacToeComputerLogic(ticTacToeGameState,ticTacToeLogic);

    @Test
    void shouldReturn2CoordinatesInRangeOf2(){
        //given
        when(ticTacToeGameState.getBoardSize()).thenReturn(3);
        when(ticTacToeGameState.getBoard()).thenReturn(ticTacToeData.getBoard3x3());
        //when
       int[] result = sut.computerMove();
       int moveX = result[0];
       int moveY = result[1];
        //then
        Assertions.assertEquals(0<= moveX,moveX<=2);
        Assertions.assertEquals(0<= moveY,moveY<=2);

    }
}
