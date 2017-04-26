package ru.suminvladislav;

public class Main {
    public static void main(String[] args) {
        long n = (long) Integer.MAX_VALUE - 1;
        //long n = 987654321L;
        //long n = Long.valueOf(args[0]);
        new PrimeNumber(n);
    }
}
