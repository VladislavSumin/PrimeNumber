package ru.suminvladislav;

import java.util.Vector;

public class Main {
    private static long time;

    public static void main(String[] args) {
        Vector<Long> times = new Vector<>();
        for (int i = 0; i < 100; i++) {
            time = System.currentTimeMillis();
            long n = (long) Integer.MAX_VALUE - 1;
            //long n = 987654321L;
            //long n = Long.valueOf(args[0]);
            System.out.println("N: " + n);
            new PrimeNumber(n);
            time = System.currentTimeMillis() - time;
            System.out.println("Time: " + time + " ms");
            times.add(time);
            time = 0;
            times.forEach(aLong -> time += aLong);
            System.out.println("Avg time: " + (time / ((double) times.size())) + " ms\n");
        }
    }
}
