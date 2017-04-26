package ru.suminvladislav;

/**
 * Вычисление простых чисел с помощью решета Эратосфена
 *
 * @author Sumin Vladislav
 * @version 1.1
 */
class PrimeNumber {
    private final long max; // Кол-во чисел после оптимизации
    private long currentNumber = 1; // Кол-во найденных чисел
    private final int sizeI; // Размер массива после деления на SizeJ
    private static final int sizeJ = 64; // Размер лонга в битах
    private final long[] vector;

    /**
     * @param max - верхний предел поиска
     */
    PrimeNumber(long max) {
        long time = System.currentTimeMillis();
        System.out.println("N: " + max);

        this.max = ((long) Math.ceil(max / 2.0)) + 1; // Двойная экономия памяти
        sizeI = (int) (this.max / sizeJ + 1);
        vector = new long[sizeI];

        process();

        System.out.println("Total: " + currentNumber);

        //Поиск последнего найденного.
        long lastIndex = this.max - 1;
        while (((vector[(int) (lastIndex / sizeJ)] >> (int) (lastIndex % sizeJ)) & 1) == 1) lastIndex--;
        System.out.println("Last number: " + (lastIndex * 2 - 1));

        // Вывод информации о затраченном времени
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time + " ms");
    }

    /**
     * Внимание: вывод всех чисел в консоль занимает в 35 раз больше времени чем их поиск (при max = 2^31 - 2).
     *
     */
    private void process() {
        long lastIndex = 2;
        long step, index;
        // Вывод самих чисел
        //System.out.println(2);
        for (; lastIndex < max; lastIndex++) {
            if (((vector[(int) (lastIndex / sizeJ)] >> (lastIndex % sizeJ)) & 1) == 1) continue;
            step = lastIndex * 2 - 1;
            index = lastIndex + (lastIndex - 1) * step; // Вычеркивание начиная с n^2
            if (index > max) break;
            while (index < max) {
                vector[(int) (index / sizeJ)] |= (1L << (index % sizeJ));
                index += step;
            }
            // Вывод самих чисел
            //System.out.println(lastIndex * 2 - 1);
            currentNumber++;
        }

        for (; lastIndex < max; lastIndex++) {
            while (((vector[(int) (lastIndex / sizeJ)] >> (lastIndex % sizeJ)) & 1) == 1)
                lastIndex++;
            if (lastIndex < max) {
                // Вывод самих чисел
                //System.out.println(lastIndex * 2 - 1);
                currentNumber++;
            }
        }
    }
}
