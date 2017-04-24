package ru.suminvladislav;


public class R2 {
    private final int maxAbs;
    private final int maxCeil;
    private int lastIndex = 2;
    private int currentNumber = 2;
    private final boolean[] vector;

    public R2(int max) {
        maxAbs = max + 1;
        maxCeil = ((int) Math.ceil(max / 2.0)) + 1;
        vector = new boolean[maxCeil];
        process();
        System.out.println("Total: " + currentNumber);
    }

    private void process() {
        //System.out.println(1);
        //System.out.println(2);
        while (lastIndex < maxCeil) {
            if (!vector[lastIndex]) {
                int tmp = lastIndex * 2 - 1;
                int tmp2 = lastIndex + tmp;
                while (tmp2 < maxCeil) {
                    vector[tmp2] = true;
                    tmp2 += tmp;
                }
                //System.out.println(lastIndex * 2 - 1);
                currentNumber++;
            }
            lastIndex++;
        }
    }
}
