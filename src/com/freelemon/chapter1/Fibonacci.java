package com.freelemon.chapter1;

/**
 * Created by Hongbin on 2014/4/2.
 */
public class Fibonacci {
    private static int[] fArray = null;

    public static long fOld(int N){
        if (N==0) return 0;
        if (N==1) return 1;
        return fOld(N-1)+fOld(N-2);
    }

    public static long fNew(int N){
        if (fArray == null) fArray = new int[N+1];

        if(N==0) {
            fArray[0] = 0;
        } else if(N==1) {
            fArray[1] = 1;
        } else {
            fArray[N] = fArray[N-1] + fArray[N-2];
        }

        return fArray[N];
    }



    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            System.out.println(i+ " " + fNew(i));
        }
    }

}
