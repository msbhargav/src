package com.sreeni;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smadiraju on 3/8/16.
 */
public class BucketSort {

    public static void main(String[] args) {
        String s = "This is easy";
        char[] ch = s.toCharArray();
        sort(ch);
        System.out.println("OUTPUT:");
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
        System.out.println();
        s = "The quick brown fox jumps over the lazy dog";
        ch = s.toCharArray();
        sort(ch);
        System.out.println("OUTPUT:");
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
    }

    private static final int DEFAULT_BUCKET_SIZE = 256;

    public static void sort(char[] array){
        sort(array, DEFAULT_BUCKET_SIZE);
    }

    public static void sort(char[] array, int bucketsize){
        if (array == null || array.length == 0){
            return;
        }

        int asciiMin = array[0];
        int asciiMax = array[0];

        //Determine min and max
        for (int i=0; i < array.length; i++){
            if (array[i] < asciiMin){
                asciiMin = array[i];
            } else if (array[i] > asciiMax){
                asciiMax = array[i];
            }
        }

        //Initialize buckets
        int bucketCount = (asciiMax - asciiMin) / bucketsize + 1;
        List<List<Character>> buckets = new ArrayList<List<Character>>(bucketCount);
        for(int i=0; i < bucketCount; i++){
            buckets.add(new ArrayList<Character>());
        }

        //Distribute input array values into buckets
        for(int i=0; i < array.length; i++){
            buckets.get((array[i] - asciiMin) / bucketsize).add(array[i]);
        }

        //sort buckets and place back into array
        int currentIndex = 0;
        for(int i=0; i< buckets.size(); i++){
            Character[] bucketArray = new Character[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            insertionSort(bucketArray);
            for (int j=0; j< bucketArray.length; j++){
                array[currentIndex++] = bucketArray[j];
            }
        }
    }

    public static void insertionSort(Character[] array){
        for (int i=1; i<array.length;i++){
            Character ch = array[i];
            int indexHole = i;
            while (indexHole > 0 && array[indexHole - 1].compareTo(ch) > 0){
                array[indexHole] = array[--indexHole];
            }
            array[indexHole] = ch;
        }
    }
}
