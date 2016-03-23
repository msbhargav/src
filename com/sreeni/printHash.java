package com.sreeni;

/**
 * Created by smadiraju on 3/5/16.
 */
public class printHash {

    public static void main(String[] args){
        int n = 6;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                System.out.println(i+j);
                if((i+j)>n)
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(" ");
                }

            }
            System.out.println();

        }
    }
}
