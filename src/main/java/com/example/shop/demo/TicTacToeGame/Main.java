package com.example.shop.demo.TicTacToeGame;

import java.util.Scanner;

public class Main {


    public static void main(String... s){

        Board board = new Board(3, 3);

        Scanner myObj = new Scanner(System.in);// Create a Scanner object

        System.out.println("Enter Player 1 name");

        String name = myObj.nextLine();

        Player player1 = new Player(name, SpotSign.O);

        System.out.println("Enter Player 2 name");

        Player player2 = new Player(myObj.nextLine(), SpotSign.X);

        while (true){

            System.out.println("Player 1 turn");
            int row = myObj.nextInt();
            int col = myObj.nextInt();

            board.makeAMove(player1, row, col);

            if(player1.hasWon(board.matrix, row, col)){
                System.out.println(player1.name + " has won!!");
                break;
            }

            System.out.println("Player 2 turn");
            row = myObj.nextInt();
            col = myObj.nextInt();

            board.makeAMove(player2, row, col);

            if(player2.hasWon(board.matrix, row, col)){
                System.out.println(player2.name + " has won!!");
                break;
            }

        }


    }


}
