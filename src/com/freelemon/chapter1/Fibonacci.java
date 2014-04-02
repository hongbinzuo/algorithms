package com.freelemon.chapter1;

/**
 * Created by Hongbin on 2014/4/2.
 */
public class Fibonacci {
    private static int length = 1000;
    private static long[] fArray = null;

    public static long fOld(int N){
        if (N==0) return 0;
        if (N==1) return 1;
        return fOld(N - 1)+fOld(N - 2);
    }

    public static void setMaxLength(int len){
        length = len;
    }

    /**
     * new implementation of Fibonacci with array container
     * @param N the size
     * @return
     */

    public static long fNew(int N){
        if (fArray == null) fArray = new long[length];

        System.out.println(fArray.length);

        for (int i = 0; i < fArray.length; i++) {
            if (i==0) {
                fArray[i] = 0;
            } else if (i==1) {
                fArray[i] = 1;
            } else  {
                fArray[i] = -1;
            }
        }

        int i = 0;
        for (i = 0; i < fArray.length ; i++) {
            if (fArray[i] != -1)
                continue;
            else
                break;
        }

        for (int j = i; j < fArray.length ; j++) {
            fArray[j] = fArray[j-2]+ fArray[j-1];
        }

        return fArray[N];
    }



    public static void main(String[] args){
        for (int i = 0; i < 20; i++) {
            System.out.println(i+ " " + fNew(i));
        }
    }

}
