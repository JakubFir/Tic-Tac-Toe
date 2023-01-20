package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static org.mockito.Mockito.when;

public class TicTacToeValidatorClassTest {

    @Test
    void shouldThrowInputMissMatch() {
        //given
        int boardSize = 1;
        TicTacToePlayerChoiceValidator ticTacToeMoveValidator = Mockito.mock(TicTacToePlayerChoiceValidator.class);
        //when
        when(ticTacToeMoveValidator.getNextMoveOnY(boardSize)).thenThrow(new InputMismatchException());
        //then
        Assertions.assertThrows(InputMismatchException.class, () -> ticTacToeMoveValidator.getNextMoveOnY(1));
    }

}
