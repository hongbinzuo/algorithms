package com.freelemon.chapter1;

/**
 * Created by Hongbin on 2014/4/9.
 * This class is used for exercise 1.1.22.
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] a = {1,2,4,8,16,32,56,78,88,99,509};

        int result = rank(8, a);

        System.out.println("Result is: "+ result);
    }

    private static int depth = 0;

    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length-1);
    }

    public static int rank(int key, int[] a, int lo, int hi){
        depth ++;

        String spaces = "";
        for (int i = 0; i < depth ; i++) {
            spaces += " ";
        }
        System.out.print(spaces);
        System.out.printf("%d,%d\n", lo, hi);

        if ( lo > hi) return -1;
        int mid = lo + (hi -lo) /2;

        if ( key < a[mid]) return rank(key, a, lo, mid -1);
        else if (key > a[mid]) return rank(key, a, mid+1, hi);
        else return mid;

    }

}
