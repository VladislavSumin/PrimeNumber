package ru.suminvladislav;


public class R5 {
    private final long maxCeil;
    private long lastIndex = 2;
    private long currentNumber = 2;
    private final int sizeI;
    private static final int sizeJ = Integer.MAX_VALUE / 2;
    private final boolean[][] vector;

    R5(long max) {
        maxCeil = ((long) Math.ceil(max / 2.0)) + 1;
        sizeI = (int) (max / (Integer.MAX_VALUE / 2) + 1);
        vector = new boolean[sizeI][sizeJ];
        process();
        System.out.println("Total: " + currentNumber);
    }

    private void process() {
        //System.out.println(1);
        //System.out.println(2);
        while (lastIndex < maxCeil) {
            if (!vector[(int) (lastIndex / sizeJ)][(int) (lastIndex % sizeJ)]) {
                long tmp = lastIndex * 2 - 1;
                long tmp2 = lastIndex + tmp;
                while (tmp2 < maxCeil && tmp2 > 0) {
                    vector[(int) (tmp2 / sizeJ)][(int) (tmp2 % sizeJ)] = true;
                    tmp2 += tmp;
                }
                //System.out.println(lastIndex * 2 - 1);
                currentNumber++;
            }
            lastIndex++;
        }
    }
}
