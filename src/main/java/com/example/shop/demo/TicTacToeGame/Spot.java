package com.example.shop.demo.TicTacToeGame;

public class Spot {

    int row;
    int col;
    boolean isFree;

    SpotSign spotSign;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public SpotSign getSpotSign() {
        return spotSign;
    }

    public void setSpotSign(SpotSign spotSign) {
        this.spotSign = spotSign;
    }

    Spot(int row, int col){
        this.col = col;
        this.row = row;
        this.isFree = true;

    }
}
