package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class TicTacToeApplicationTests {
    List<List> winningMoves;
    public List<List> getWinningMoves() {
        winningMoves = new ArrayList<>();
        List list = Arrays.asList(1,2,3);
        winningMoves.add(list);
        return winningMoves;
    }
    @Test
    void winningMethodTest(){
        //Given
        List<Integer> playerMoves = Arrays.asList(1,2,3);
        TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWon(getWinningMoves(),playerMoves);
        //then
        Assertions.assertTrue(result);
    }

}


