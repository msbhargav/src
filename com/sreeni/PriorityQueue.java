package com.sreeni;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smadiraju on 3/11/16.
 */
public class PriorityQueue {

    private List<Integer> heap;
    private int headsize, capacity;

    public PriorityQueue(int capacity){
        this.capacity = capacity;
        heap = new ArrayList<Integer>(this.capacity);
        headsize = 0;
    }

    public void clear(){
        heap = new ArrayList<Integer>(this.capacity);
        headsize = 0;
    }

    public boolean isEmpty(){
        return headsize == 0;
    }

    public boolean isFull(){
        return headsize == capacity - 1;
    }

    private void buildminheap(List<Integer> arr, int heapsize){
        for(int i=arr.size()/2;i>=0;i--){
            maxheapify(arr, heapsize, i);
        }
    }

    private void swap(List<Integer> arr, int i1, int i2){
        int tmp = arr.get(i1);
        arr.set(i1,arr.get(i2));
        arr.set(i2,tmp);
    }

    private void maxheapify(List<Integer> arr, int heapsize, int i){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int largest;

        if (left < heapsize && arr.get(left) < arr.get(i)){
            largest = left;
        } else
            largest = i;
        if (right < heapsize && arr.get(right) < arr.get(largest)){
            largest = right;
        }
        if (largest != i){
            swap(arr, i, largest);
            maxheapify(arr, heapsize, largest);
        }
    }

    public void insert(int val){
        heap.add(val);

        headsize = heap.size();

        buildminheap(heap, headsize);

        while (headsize > 1){
            swap(heap, 0, headsize -1);
            headsize--;
            maxheapify(heap, headsize, 0);
        }
    }

    public void add(int[] list){
        for (int i:list){
            insert(i);
        }
    }

    public void add(int[][] lists){
        for (int[] i: lists){
            add(i);
        }
    }

/*    public void insert(int val){
        heap[++headsize] = val;
        int pos = headsize;

        while (pos != 1 && val > heap[pos/2]){
            heap[pos] = heap[pos/2];
            pos /=2 ;
        }

        heap[pos] = val;
    }

    public int remove() {
        if (isEmpty()){
            System.out.println("Heap is empty");
            return -Integer.MAX_VALUE;
        }

        int item = heap[1];
        int tmp = heap[headsize--];

        int parent = 1;
        int child = 2;

        while (child <= headsize){
            if (child < headsize  && heap[child] < heap[child+1]){
                child++;
            }
            if (tmp >= heap[child]){
                break;
            }

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }

        heap[parent] = tmp;

        return item;
    }*/

    public void print(){
        for(int i=0;i<heap.size();i++){
            System.out.print(heap.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] l1 = { 1, 2, 4, 5, 6};
        int[] l2 = { 7, 8, 9, 10};
        int[][] l3 = {{
                1,3,5,7
        },{
                2,4,6,8
        },{
                0,9,10,11
        }};
        PriorityQueue pq = new PriorityQueue(l1.length);
        pq.add(l1);
        pq.add(l2);
        pq.add(l3);
        pq.print();
    }
}
