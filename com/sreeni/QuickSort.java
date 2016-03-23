package com.sreeni;

/**
 * Created by smadiraju on 3/4/16.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] A = new int[]{10, 2, 1, 4, 6, 5};
        int[] B = new int[]{2, 3, 1};
        int[] C = new int[]{1};
        int[] D = new int[]{};
        int[] E = new int[]{0,0,0,0,0};
        int[] F = new int[]{2,2,-1,1,1};
        int[] G = new int[]{4,5,4,5};
        QSort(A, 0, A.length - 1);
        QSort(B, 0, B.length - 1);
        QSort(C, 0, C.length - 1);
        QSort(D, 0, D.length - 1);
        QSort(E, 0, E.length - 1);
        QSort(F, 0, F.length - 1);
        QSort(G, 0, G.length - 1);
        printArray(A);
        printArray(B);
        printArray(C);
        printArray(D);
        printArray(E);
        printArray(F);
        printArray(G);
    }

    public static void p(String x) {
        System.out.println(x);
    }

    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void QSort(int[] A, int low, int high) {
        if (A == null || A.length == 0)
            return;
        if (low >= high)
            return;
        int pivot = A[(low + high) / 2] ;//A[(low + (high - low) / 2)];
        int index = Partition(A, low, high, pivot);
        if (low < index - 1)
            QSort(A, low, index - 1);
        if (index < high)
            QSort(A, index , high);
    }

    public static int Partition(int[] A, int low, int high, int pivot) {
        int i = low, j = high;
        while (i <= j) {
            while (A[i] < pivot)
                i++;
            while (A[j] > pivot)
                j--;
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    //good
    public static void swap(int[] A, int x, int y) {
        int temp = A[y];
        A[y] = A[x];
        A[x] = temp;
    }

    /*
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
    */


}
