package com.sreeni;

/**
 * Created by smadiraju on 3/9/16.
 */
public class HeapSort1 {

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 1 ,23 ,12 ,9 , 30 , 2 , 50 ,2};
        maxHeapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    static void sort(int[] arr){
        int heapsize = arr.length;

        buildheap(arr, heapsize);

        while (heapsize > 1){
            swap(arr, 0, heapsize -1);
            heapsize--;
            minheapify(arr, heapsize, 0);
        }
    }

    static void maxHeapSort(int[] arr){
        int heapsize = arr.length;

        buildminheap(arr, heapsize);

        while (heapsize > 1){
            swap(arr, 0, heapsize -1);
            heapsize--;
            maxheapify(arr, heapsize, 0);
        }
    }

    static void buildheap(int[] arr, int heapsize){
        for(int i=arr.length/2;i>=0;i--){
            minheapify(arr, heapsize, i);
        }
    }

    static void buildminheap(int[] arr, int heapsize){
        for(int i=arr.length/2;i>=0;i--){
            maxheapify(arr, heapsize, i);
        }
    }

    static void minheapify(int[] arr, int heapsize, int i){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int largest;

        if (left < heapsize && arr[left] > arr[i]){
            largest = left;
        } else
            largest = i;
        if (right < heapsize && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i){
            swap(arr, i, largest);
            minheapify(arr, heapsize, largest);
        }
    }

    static void maxheapify(int[] arr, int heapsize, int i){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int largest;

        if (left < heapsize && arr[left] < arr[i]){
            largest = left;
        } else
            largest = i;
        if (right < heapsize && arr[right] < arr[largest]){
            largest = right;
        }
        if (largest != i){
            swap(arr, i, largest);
            maxheapify(arr, heapsize, largest);
        }
    }

    static void swap(int[] arr, int i1, int i2){
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
