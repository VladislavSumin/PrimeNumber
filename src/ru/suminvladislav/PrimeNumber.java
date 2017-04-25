package ru.suminvladislav;

class PrimeNumber {
    private final long max; // Кол-во чисел после оптимизации
    private long currentNumber = 1; // Кол-во найденных чисел
    private final int sizeI; // Размер массива после деления на SizeJ
    private static final int sizeJ = 64; // Размер лонга в битах
    private final long[] vector;

    PrimeNumber(long max) {
        this.max = ((long) Math.ceil(max / 2.0)) + 1; // Двойная экономия памяти
        sizeI = (int) (this.max / sizeJ + 1);
        vector = new long[sizeI];
        process();
        System.out.println("Total: " + currentNumber);

        //Поиск последнего найденного.
        long lastIndex = this.max - 1;
        while (((vector[(int) (lastIndex / sizeJ)] >> (int) (lastIndex % sizeJ)) & 1) == 1) lastIndex--;
        System.out.println("Last number: " + (lastIndex * 2 - 1));
    }

    private void process() {
        long lastIndex = 2;
        long step, index;
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
            //System.out.println(lastIndex * 2 - 1);
            currentNumber++;
        }

        for (; lastIndex < max; lastIndex++) {
            while (((vector[(int) (lastIndex / sizeJ)] >> (lastIndex % sizeJ)) & 1) == 1)
                lastIndex++;
            if (lastIndex < max) {
                currentNumber++;
            }
        }
    }
}
