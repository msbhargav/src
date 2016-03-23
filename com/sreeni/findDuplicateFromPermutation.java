package com.sreeni;

/**
 * Created by smadiraju on 3/8/16.
 */
public class findDuplicateFromPermutation {

    public static void main(String[] args) {
        int[] array = {7,1, 7, 4, 3, 2, 7, 4};
        System.out.println(findDuplicateFromPermutation(array));
    }

    static int findDuplicateFromPermutation(int[] intArray) {
        if (intArray == null && intArray.length == 0){
            return -1;
        }
        int min = intArray[0];
        int max = intArray[0];

        for(int i=0;i<intArray.length;i++){
            if (intArray[i]<min){
                min = intArray[i];
            } else if (intArray[i] > max){
                max = intArray[i];
            }
        }
        int bucketCount = (max - min) + 1;
        int[] space = new int[bucketCount];
        for (int i=0; i<intArray.length;i++){
            if (space[intArray[i]-min] == 0){
                space[intArray[i]-min] = intArray[i];
            } else
                return intArray[i];
        }
        return -1;
    }

}
