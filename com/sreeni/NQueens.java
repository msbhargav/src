package com.sreeni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by smadiraju on 3/18/16.
 */
public class NQueens {

    public static void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<String[]> res){
        if (r == board.length) res.add(board.clone());

        else {
            for (int c=0; c < board.length; c++){
                int id1 = r - c + board.length, id2 = 2 * board.length - r - c -1 ;
                System.out.println("r, c, board.length, id1, id2:"+r+","+c+","+board.length+","+id1+","+id2);
                if (!cols[c] && !d1[id1] && !d2[id2]){
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    helper(r+1, cols, d1, d2, board, res);
                    cols[c] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
        }
    }

    public static List<String[]> solveQueens(int n){
        List<String[]> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], new String[n], res);
        return res;
    }

    public static void main(String[] args) {
        List<String[]> q = solveQueens(4);
        int sol = 0;
        for(String[] s : q){

            for(int i=0; i<s.length; i++){
                if (i%4 == 0) {
                    System.out.println("Sol:" + sol++);
                    System.out.println("***************");
                }
                System.out.println(s[i]);
            }
            System.out.println("***************");
        }
    }

}
