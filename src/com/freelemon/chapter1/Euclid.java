package com.freelemon.chapter1;

/**
 * Created by Hongbin on 2014/4/10.
 */
public class Euclid {
    public static void main(String[] args){
        //int a= 60, b=11;
        int a = 1111111, b=1234567;
        System.out.println("a is:"+a+", b is:"+b+", and the gcd is:"+ euclid(a,b));

    }

    /**
     * Compute the greatest common divisor.
     * @param a non-negative
     * @param b non-negative
     * @return
     */
    public static int euclid(int a, int b){
        if ( a > b ){
            return gcd(a, b);
        } else{
            return gcd(b, a);
        }
    }

    private static int gcd(int a, int b){
        if ( a > b && ((a % b)!= 0)){
            return gcd(b, a % b);
        } else if ( a<= b) {
            return 1;
        } else {
            return b;
        }
    }

    // gcd(a, b) = gcd(b, a % b) (a>b && a% b!=0)
}
