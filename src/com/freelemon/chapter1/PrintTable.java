package com.freelemon.chapter1;

/**
 * Created by Hongbin on 2014/4/2.
 */

import java.math.BigDecimal;
import java.util.*;

public class PrintTable {
    public static void main(String[] args){
        // no error handling
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] result = line.split(" ");

            double x = Double.parseDouble(result[1])/Double.parseDouble(result[2]);

            BigDecimal b   =   new   BigDecimal(x);
            double   x1   =   b.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();

            System.out.println(
                    result[0] + "\t" + result[1] + "\t" + result[2] + "\t" + x1
            );
        }
    }
}
