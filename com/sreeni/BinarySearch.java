package com.sreeni;

/**
 * Created by smadiraju on 2/17/16.
 */
public class BinarySearch {

    public static int doSearch(int low, int high, int[] A, int key){
        if (low > high || low < 0 || high <0)
            return -1;
        int mid = (low + high ) / 2;

        if (A[mid] == key)
            return mid;
        else if (A[mid] < key)
            return doSearch(low, mid-1,A,key);
        else if (A[mid] > key)
            return doSearch(mid+1,high,A,key);
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1,2,4,5,7,8,9};
        System.out.println(doSearch(0,A.length,A,5));
        System.out.println(doSearch(0,A.length,A,6));
        System.out.println(doSearch(0,A.length,A,10));
    }
}
