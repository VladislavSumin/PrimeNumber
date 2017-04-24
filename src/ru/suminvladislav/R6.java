package ru.suminvladislav;


class R6 {
    private final long max; // Кол-во чисел после оптимизации.
    private long lastIndex = 2; // Индекс последнего найденного
    private long currentNumber = 2; // Текущее для поиска (тут 3 на самом деле, только цссс)
    private final int sizeI; // Размер массива после деления на SizeJ
    private static final long sizeJ = 64; // Размер лонга
    private final long[] vector;

    R6(long max) {
        this.max = ((long) Math.ceil(max / 2.0)) + 1; // тут тип в 2 раза меньше чисел.
        sizeI = (int) (this.max / sizeJ + 1);
        vector = new long[sizeI];
        process();
        System.out.println("Total: " + currentNumber);

        //Поиск последнего найденного.
        lastIndex--; //<<---- Когда ты тупой.
        while (((vector[(int) (lastIndex / sizeJ)] >> (int) (lastIndex % sizeJ)) & 1) == 1) lastIndex--;
        System.out.println("Last number: " + (lastIndex * 2 - 1));
    }

    private void process() {
        long step;
        long index;
        //System.out.println(1);
        //System.out.println(2);
        while (lastIndex < max) {
            if (((vector[(int) (lastIndex / sizeJ)] >> ((int) (lastIndex % sizeJ))) & 1) == 0) {
                step = lastIndex * 2 - 1;
                //index = lastIndex + step;
                index = lastIndex + (lastIndex - 1) * step;//скорость x2 но это не точно.
                if (index > max) {
                    //System.out.println("!");
                    while (lastIndex < max) {
                        while (((vector[(int) (lastIndex / sizeJ)] >> (int) (lastIndex % sizeJ)) & 1) == 1)
                            lastIndex++;
                        if (lastIndex < max) {
                            lastIndex++;// И так сойдет =)
                            currentNumber++;
                        }
                    }
                    return;
                }
                while (index < max) {
                    vector[(int) (index / sizeJ)] |= (1L << (int) (index % sizeJ));
                    index += step;
                }
                //System.out.println(lastIndex * 2 - 1);
                currentNumber++;
            }
            lastIndex++;
        }
    }
}
