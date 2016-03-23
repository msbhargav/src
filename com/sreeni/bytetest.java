package com.sreeni;

/**
 * Created by smadiraju on 3/12/16.
 */
public class bytetest {

    public static void main(String[] args) {
        int radix = 8;
        byte[] b = new byte[0xFFFF / radix];
        int n = 8;
        for(int i=0;i<b.length;i++){
            System.out.print(i+"/"+radix+":"+(i/radix));
            System.out.print(" ");
            System.out.print(i+"%"+radix+":" + (i % radix));
            System.out.print(" ");
            System.out.print(1+"<<"+"("+i+"%"+radix+"):"+(1<<(i%radix)));
            System.out.print(" ");
            b[i/radix] |= (1<<(i%radix));
            System.out.print(b[i]+","+b[i/radix]+":"+Integer.toBinaryString(b[i/radix]));
            System.out.print(" ");
            System.out.println();
        }
        System.out.println();
    }
}
