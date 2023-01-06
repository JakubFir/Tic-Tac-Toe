package com.example.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeMoveValidator {
    int move;
    public int getMove() {
        return move;
    }
    public boolean ValidateMove(){
        Scanner scanner = new Scanner(System.in);
        boolean valid;
        do{
            try{
                valid = true;
                move = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Wrong input, try again");
                scanner.nextLine();
                valid = false;
            }
        }while (!valid);
        return valid;
    }
}