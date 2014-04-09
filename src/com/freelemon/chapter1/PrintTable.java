package com.freelemon.chapter1;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Hongbin on 2014/4/2.
 */
public class PrintTable {
    private static Vector table = new Vector<Score>();

    /**
     * Read system console input into a vector. Stop when type "exit".
     * @param in
     */
    private static void readTable(InputStream in){
        Scanner scanner = new Scanner(in);

        String line = "";

        while ( scanner.hasNext() && !( line =scanner.nextLine()).equals("exit")){
            Scanner lineScanner = new Scanner(line);
            Score score = new Score();
            score.setName(lineScanner.next());
            score.setScore1(lineScanner.nextInt());
            score.setScore2(lineScanner.nextInt());

            // keep three decimals
            BigDecimal score1 = new BigDecimal(score.getScore1());
            BigDecimal score2 = new BigDecimal(score.getScore2());
            double result = score1.divide(score2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();

            score.setDiv(result);

            table.add(score);
        }

    }

    private static void printTable(){
        for (int i = 0; i < table.size() ; i++) {
            Score s = (Score)table.get(i);
            System.out.printf("%s\t%d\t%d\t%.3f\n", s.getName(),s.getScore1(),s.getScore2(),s.getDiv());

        }
    }

    public static void main(String[] args){
        readTable(System.in);
        printTable();

    }
}

final class Score{
    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public double getDiv() {
        return div;
    }

    public void setDiv(double div) {
        this.div = div;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (Double.compare(score.div, div) != 0) return false;
        if (score1 != score.score1) return false;
        if (score2 != score.score2) return false;
        if (name != null ? !name.equals(score.name) : score.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + score1;
        result = 31 * result + score2;
        temp = Double.doubleToLongBits(div);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    private String name;
    private int score1;
    private int score2;
    private double div;
}
