package ru.suminvladislav;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            long time = System.currentTimeMillis();
            //long n = (long) Integer.MAX_VALUE * (60+ 1) - 1;
            //long n = 987654321L;
            long n = Long.valueOf(args[0]);
            System.out.println("N: " + n);
            new R6(n);
            System.out.println("Time: " + (System.currentTimeMillis() - time) + " ms\n");
        }
    }
}
