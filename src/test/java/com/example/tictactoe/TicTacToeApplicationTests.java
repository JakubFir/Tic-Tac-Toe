package com.example.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


class TicTacToeApplicationTests {

    @Test
    void winningMetodTest(){
        //Given
        TicTacToeLogic ticTacToeLogic = new TicTacToeLogic();
        TicTacToeData ticTacToeData = new TicTacToeData();
        List<Integer> playerMoves = Arrays.asList(1,2,3);
        //When
        boolean result = ticTacToeLogic.checkIfSomeOneWin(ticTacToeData.getWinningMoves(),playerMoves);
        //then
        Assertions.assertTrue(result);
    }
}


