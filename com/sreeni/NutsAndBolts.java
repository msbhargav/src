package com.sreeni;

/**
 * Created by smadiraju on 3/7/16.
 */
public class NutsAndBolts {

    public static void main(String[] args) {
        int[] nuts =  { 3, 1, 2, 4, 5 } ;
        int[] bolts = { 2, 1, 4, 3, 5 } ;

        sortNutAndBolts( nuts, bolts, 0, bolts.length-1);

        printArray(nuts);
        printArray(bolts);

        int[] nuts1 =  { 1, 2, 3, 4, 5 } ;
        int[] bolts1 = { 2, 1, 4, 3, 5 } ;

        sortNutAndBolts( nuts1, bolts1, 0, bolts1.length-1);

        printArray(nuts1);
        printArray(bolts1);
    }

    public static void printArray(int[] A){
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void sortNutAndBolts(int[] nuts, int[] bolts, int low, int high){

        if (    nuts == null ||
                nuts.length == 0 ||
                bolts == null ||
                bolts.length == 0
        )
            return;
        if (low >= high)
            return;

        if (low < high) {
            int pivot = Partition(nuts, low, high, bolts[high]);

            Partition(bolts, low, high, nuts[pivot]);

            sortNutAndBolts(nuts, bolts, low, pivot - 1);
            sortNutAndBolts(nuts, bolts, pivot + 1, high);
        }
    }

    public static int Partition( int[] A, int low, int high, int val){
        int i = low;

        for (int j = low; j < high;j++){
            if (A[j] < val){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
            } else if (A[j] == val){
                int tmp = A[j];
                A[j] = A[high];
                A[high] = tmp;
                j--;
            }
        }
        //put the pivt in its correct place
        int tmp = A[i];
        A[i] = A[high];
        A[high] = tmp;

        return i;
    }
}
