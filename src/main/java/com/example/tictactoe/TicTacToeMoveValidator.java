package com.example.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeMoveValidator {
    int nextMoveOnX;
    int nextMoveOnY;
    Scanner scanner = new Scanner(System.in);

    public int getNextMoveX() {
        return nextMoveOnX;
    }
    public int getNextMoveY() {
        return nextMoveOnY;
    }


    public int getNextMoveOnX(int boardSize){
        System.out.println("select row");
        boolean valid;
        do {
            try {
                nextMoveOnX = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
                scanner.nextLine();
                valid = false;
            }
        }while (!valid);
        validateMove(nextMoveOnX,boardSize);
        return nextMoveOnX;
    }
    public int getNextMoveOnY(int boardSize){
        System.out.println("select column");
        boolean valid;
        do {
            try {
                nextMoveOnY = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again");
                scanner.nextLine();
                valid = false;
            }
        }while (!valid);
        validateMove(nextMoveOnY,boardSize);
        return nextMoveOnY;
    }
    public boolean validateMove(int move,int boardSize) {
        boolean valid = true;
        if(nextMoveOnX > boardSize-1){
            valid = false;
            System.out.println("choice between 0-"+ (boardSize-1));
            getNextMoveOnX(boardSize);
        }else if(nextMoveOnY > boardSize-1){
            System.out.println("choice between 0-"+ (boardSize-1));
            valid = false;
            getNextMoveOnY(boardSize);
        }

        return valid;
    }
}