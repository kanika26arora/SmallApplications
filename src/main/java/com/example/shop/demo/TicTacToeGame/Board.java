package com.example.shop.demo.TicTacToeGame;

import java.util.ArrayList;
import java.util.List;

public class Board {

   public final List<List<Spot>> matrix;
   int row;
   int col;

    Board(int row, int col){
        this.row = row;
        this.col = col;
        matrix = new ArrayList<>();
        for(int i=0; i<row; i++){
            List<Spot> list = new ArrayList<>();

            for(int j=0; j<col; j++){
                list.add(new Spot(i, j));
            }
            matrix.add(list);
        }
    }

    void makeAMove(Player p, int r, int c){

        if(r>=0 && r<row && c>=0 && c<col && matrix.get(r).get(c).isFree()){
            matrix.get(r).get(c).setFree(false);
            matrix.get(r).get(c).setSpotSign(p.signAssigned);

        } else {
            System.out.println("Sorry cant make that move");
        }
    }

}
