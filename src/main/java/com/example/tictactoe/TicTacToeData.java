package com.example.tictactoe;


public class TicTacToeData {
    private char[][] board3x3 = new char[3][3];
    private char[][] board10x10 = new char[10][10];

    public char[][] getBoard3x3() {
        return board3x3;
    }

    public char[][] getBoard10x10() {
        return board10x10;
    }

}