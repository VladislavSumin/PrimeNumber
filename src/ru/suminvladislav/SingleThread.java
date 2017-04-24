package ru.suminvladislav;

public class SingleThread {
    private final long[] vector = new long[5_000_000];
    private int lastIndex = 4;

    public SingleThread(long max) {
        vector[0] = (2L);
        vector[1] = (3L);
        vector[2] = (5L);
        vector[3] = (7L);


        x:
        for (long i = 9; i < max + 1; i += 2) {
            for (int j = 0; j < lastIndex; j++) {
                if (i % vector[j] == 0) continue x;
                else if (vector[j] > Math.sqrt(i)) break;
            }

            vector[lastIndex++] = i;
            System.out.println(i);
        }
        System.out.println(lastIndex + 1);
    }
}
