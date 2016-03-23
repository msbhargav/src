package com.sreeni;

import java.util.Arrays;

/**
 * Created by smadiraju on 3/14/16.
 */
public class ClosestPair {
    public static void main(String[] args) {
        int len = 10;
        int[] B = { -20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};

        int[] A = new int[10];

        Arrays.sort(B);

        int min2 = Math.abs(B[1] - B[0]);
        int firstone = B[0], secondone = B[1];
        for(int i=2;i<B.length;i++){
            int min1 = Math.abs(B[i] - B[i-1]);
            int nmin2 = Math.min(min2, min1);
            if (nmin2 != min2){
                firstone = B[i-1];
                secondone = B[i];
            }
            min2 = nmin2;
        }
        System.out.print(firstone+" "+secondone);
    }
}
