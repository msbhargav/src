package com.sreeni;

/**
 * Created by smadiraju on 9/29/15.
 */
public class PrintingStars {

    public static void main(String[] args) {

        int n = 10;

        print1(10,1);
        print2(10, 1);

    }

    public static void print1(int num, int indent){
        if (num == 0) return;
        for (int i=0;i<num;i++){
            System.out.print("*");
            for (int j=0;j<indent;j++){
                System.out.print(" ");
            }
        }
        System.out.println();
        print1(num - 1, 1);
    }

    public static void print2(int num, int indent){
        if (num == 0) return;
        print2(num - 1, 1);
        System.out.println();
        for (int i=0;i<num;i++){
            System.out.print("*");
            for (int j=0;j<indent;j++){
                System.out.print(" ");
            }
        }
    }
}
