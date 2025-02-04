package model;

import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean won(){
        int n = this.size;
        for(int i = 0;i < n;++i){
            if(this.board[i][0] != null && checkSymmetry(i,0, 0, 1,this.board[i][0])){
                return true ;
            }

            if(this.board[0][i] != null && checkSymmetry(0, i, 1, 0, this.board[0][i])){
                return true;
            }
        }
        if(this.board[0][0] != null && checkSymmetry(0, 0, 1,1, this.board[0][0])){
            return true;
        }
        if(this.board[0][n - 1] != null && checkSymmetry(0,n - 1, 1, -1, this.board[0][n - 1])){
            return true;
        }
        return false;
    }

    public boolean checkSymmetry(int row, int col, int ra, int ca, PlayingPiece currentPiece) {
        int n = this.size;
        if(row >= n || col >= n || row < 0 || col < 0){
            return true;
        }
        if(!currentPiece.equals(this.board[row][col])){
            return false;
        }
        return checkSymmetry(row + ra, col + ca, ra, ca, currentPiece);

    }

    public boolean occupied(){
        int cnt = 0;
        for(int i = 0;i < this.size;++i){
            for(int j = 0;j < this.size;++j){
                if(this.board[i][j] == null){
                    cnt++;
                }
            }
        }
        return (cnt == 0);
    }

    @Override
    public String toString(){
        String ans = "";
        for(int i = 0;i < size;++i){
            ans += " ";
            for(int j = 0;j < size;++j){
                ans += "----";
            }
            ans += "\n";
            for(int j = 0;j < size;++j){
                ans += " | ";
                if(board[i][j] == null){
                    ans += " ";
                }else{
                    ans += board[i][j].pieceType;
                }
            }
            ans += "|\n";
        }
        return ans;
    }

}
