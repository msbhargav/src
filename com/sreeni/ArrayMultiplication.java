package com.sreeni;

/**
 * Created by smadiraju on 2/8/16.
 */
public class ArrayMultiplication {

    public static void main(String[] args) {
        int[] a = { 9,9,9,9,9,9,9,9,9,9,9 };
        int[] b = { 1,1,1,1,1,1,1,1,1,1,1 };
        printResult(multiply(a,b));
        a = new int[] { -9,9,9,9,9,9,9,9,9,9,9 };
        b = new int[] { 1,1,1,1,1,1,1,1,1,1,1 };
        printResult(multiply(a,b));
        a = new int[] { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 };
        b = new int[] { 1,1,1,1,1,1,1,1,1,1,1,9,9,9,9,9,9,9,9,9,9,9 };
        printResult(multiply(a,b));
        a = new int[] { 0,9,9,9,9,9,9,9,9,9,9 };
        b = new int[] { 0,1,1,1,1,1,1,1,1,1,1 };
        printResult(multiply(a,b));
    }

    public static int[] multiply(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        int end = result.length - 1;
        int carry = 0;
        boolean negative = true;
        if (a[0]>0 && b[0]>0){
            negative = false;
        } else {
            if (a[0]<0)
                a[0]*=-1;
            if (b[0]<0)
                b[0]*=-1;
        }
        for (int i=a.length-1;i>=0;i--){
            int n = end;
            for (int j=b.length-1;j>=0;j--) {
                int c = a[i] * b[j]; // 9 * 1
                int total = result[n]+carry+c; //0 + 0 + 9 = 9
                if (total > 9) {
                    int rem = total % 10; //9
                    int div = total / 10; //0
                    result[n] = rem; //9
                    carry = div; //0
                } else {
                    result[n] = total;
                }
                n--; //before next update the add the carry to the index.
                result[n] += carry;
                carry = 0;
            }
            end--;
        }
        if (negative)
            result[0]*=-1;
        return (result);
    }

    public static void printResult(int[] result){
        for(int k=0;k<result.length;k++){
            System.out.print(result[k]);
        }
        System.out.println();
    }

    public static void p(String message){
        if (true){
            System.out.println(message);
        }
    }
}
