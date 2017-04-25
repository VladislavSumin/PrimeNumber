package ru.suminvladislav;

public class Main {
    private static long time;

    public static void main(String[] args) {
        time = System.currentTimeMillis();
        //long n = (long) Integer.MAX_VALUE - 1;
        //long n = 987654321L;
        long n = Long.valueOf(args[0]);
        System.out.println("N: " + n);
        new PrimeNumber(n);
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time + " ms");
    }
}
