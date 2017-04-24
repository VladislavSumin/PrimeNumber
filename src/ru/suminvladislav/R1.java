package ru.suminvladislav;


public class R1 {
    private final int max;
    private int lastIndex = 2;
    private int currentNumber = 1;
    private final boolean[] vector;

    public R1(int max) {
        this.max = max + 1;
        vector = new boolean[this.max];

        process();

        System.out.println("Total: " + currentNumber);
    }

    private void process() {
        //System.out.println(1);
        while (lastIndex < max) {
            if (!vector[lastIndex]) {
                int tmp = lastIndex * 2;
                while (tmp < max) {
                    vector[tmp] = true;
                    tmp += lastIndex;
                }
                //System.out.println(lastIndex);
                currentNumber++;
            }
            lastIndex++;
        }
    }
}
