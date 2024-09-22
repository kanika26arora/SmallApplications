package com.example.shop.demo.TicTacToeGame;

import java.util.List;

public class Player {

    String name;
    SpotSign signAssigned;

    Player(String name, SpotSign signAssigned){
        this.name = name;
        this.signAssigned = signAssigned;
    }

    public boolean hasWon(List<List<Spot>> matrix, int row, int col) {

      boolean rowMatch = true;
      boolean colMatch = true;
      boolean diagMatch = true;
      boolean antiDiagMatch = true;

      for(int i=0; i<matrix.size(); i++) {
          if (matrix.get(row).get(i).isFree || matrix.get(row).get(i).spotSign != this.signAssigned)
              rowMatch = false;
      }

        for (int i=0; i<matrix.size(); i++) {
            if (matrix.get(i).get(col).isFree || matrix.get(i).get(col).spotSign != this.signAssigned)
                colMatch = false;
        }

      for(int i=0; i<matrix.size(); i++) {
            if (matrix.get(i).get(i).isFree || matrix.get(i).get(i).spotSign != this.signAssigned)
                diagMatch = false;
        }

        for(int i= matrix.size()-1; i>=0; i--) {
            if (matrix.get(i).get(col).isFree || matrix.get(i).get(col).spotSign != this.signAssigned)
                antiDiagMatch = false;
        }

        return rowMatch || colMatch || diagMatch || antiDiagMatch;
    }
}
