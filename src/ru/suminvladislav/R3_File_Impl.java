package ru.suminvladislav;


import java.io.*;
import java.lang.reflect.Field;

public class R3_File_Impl {
    private final int maxAbs;
    private final int maxCeil;
    private int lastIndex = 2;
    private int currentNumber = 2;
    private final boolean[] vector;
    private PrintStream file = null;

    public R3_File_Impl(int max) {
        maxAbs = max + 1;
        maxCeil = ((int) Math.ceil(max / 2.0)) + 1;
        vector = new boolean[this.maxAbs];

        try {
            file = new PrintStream(new FileOutputStream("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        process();

        file.close();
        System.out.println("Total: " + currentNumber);
    }

    private void process() {
        file.println(1);
        file.println(2);
        while (lastIndex < maxCeil) {
            if (!vector[lastIndex]) {
                int tmp = lastIndex * 2 - 1;
                int tmp2 = lastIndex + tmp;
                while (tmp2 < maxCeil) {
                    vector[tmp2] = true;
                    tmp2 += tmp;
                }
                file.println(lastIndex * 2 - 1);
                currentNumber++;
            }
            lastIndex++;
        }
    }
}
