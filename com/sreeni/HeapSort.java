package com.sreeni;

/**
 * Created by smadiraju on 3/8/16.
 */
public class HeapSort {

    private static int N;

    static int[] topK(int[] iStream, int iK) {
        if (iK < 1 || iStream == null){
            return new int[]{0};
        }
        buildheap(iStream);
        int[] result = new int[iK];
        for (int i=0;i<iK; i++){
            result[i] = deleteMax(iStream);
        }
        return result;
    }

    static void buildheap(int[] arr){
        N = arr.length;
        heapify(arr);
        for (int i = N; i > 0; i--){
            swap(arr, 0, i);
            N = N - 1;
            maxheap(arr, 0);
        }
    }

    static int deleteMax(int[] arr){
        int tmp = arr[arr.length -1];
        arr[arr.length -1] = arr[0];
        N = arr.length - 1;
        buildheap(arr);
        return tmp;
    }

    static void heapify(int arr[]){
        N = arr.length -1;
        for (int i = N/2; i>=0; i--){
            maxheap(arr, i);
        }
    }

    static void maxheap(int arr[], int i){
        int left = 2*i;
        int right = 2*i +1;
        int max = i;

        if (left <=N && arr[left] > arr[i]){
            max = left;
        }

        if (right <= N && arr[right] > arr[max]){
            max = right;
        }

        if (max != i){
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void sort(int[] arr){
        heapify(arr);
        for( int i=N; i>0;i--){
            swap(arr, 0, i);
            N = N-1;
            maxheap(arr, arr.length-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 1 ,23 ,12 ,9 , 30 , 2 , 50 ,2};

        sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();

        int[] top = topK(arr, 2);
        for(int i=0; i< top.length;i++){
            System.out.println(top[i]);
        }
    }
}
