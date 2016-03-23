package com.sreeni;

/**
 * Created by smadiraju on 9/30/15.
 */
public class LCS {

    public static String s1 = "great";
    public static String s2 = "reap";

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int LCSubStr( String s1, String s2 ){

        int[][] LCSuff = new int[s1.length()+1][s2.length()+1];

        int result = 0;

        for (int i=1; i<=s1.length();i++){
            for (int j=1; j<=s2.length();j++){
                if (i == 1 || j==1) {
                    LCSuff[i][j] = 1;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    LCSuff[i][j] = LCSuff[i-1][j-1] + 1;
                    result = max (result, LCSuff[i][j]);
                } else {
                    LCSuff[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] s) {
        System.out.println(LCSubStr(s1,s2));
        System.out.println(LCSubStr("OldSite:GeeksforGeeks.org","NewSite:GeeksQuiz.com"));
    }
}
