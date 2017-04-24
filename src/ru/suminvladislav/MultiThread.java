package ru.suminvladislav;


import java.util.Arrays;

class MultiThread {
    private final long[] vector = new long[5_000_000];

    private volatile int lastIndex = 8;
    private volatile long firstUnknownNumber = 21;
    private final Object numberLock = new Object();
    private final long max;
    private final long[] lastFind = new long[4];

    private class Worker extends Thread {
        private final int threadNumber;

        Worker(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            x:
            while (true) {
                long checkNumber;
                synchronized (numberLock) {
                    if (firstUnknownNumber > max) return;
                    checkNumber = firstUnknownNumber;
                    firstUnknownNumber += 2;
                }
                double sqrtFromCheckNumber = Math.sqrt(checkNumber) + 1;

                while (vector[lastIndex - 5] <= sqrtFromCheckNumber ||
                        lastFind[0]<=sqrtFromCheckNumber||
                        lastFind[1]<=sqrtFromCheckNumber||
                        lastFind[2]<=sqrtFromCheckNumber||
                        lastFind[3]<=sqrtFromCheckNumber);// System.out.println("!");

                for (int j = 0; j < lastIndex - 4; j++) {
                    if (checkNumber % vector[j] == 0) continue x;
                    else if (vector[j] > sqrtFromCheckNumber)
                        break;
                }

                synchronized (vector) {
                    vector[lastIndex] = checkNumber;
                    Arrays.sort(vector, lastIndex - 4, lastIndex + 1);
                    lastFind[threadNumber] = checkNumber;
                    lastIndex++;
                }
                //System.out.println(checkNumber);
            }
        }

    }

    MultiThread(long max) {
        this.max = max;
        vector[0] = (2L);
        vector[1] = (3L);
        vector[2] = (5L);
        vector[3] = (7L);
        vector[4] = (11L);
        vector[5] = (13L);
        vector[6] = (17L);
        vector[7] = (19L);

        lastFind[0]= 19L;
        lastFind[1]= 19L;
        lastFind[2]= 19L;
        lastFind[3]= 19L;

        Worker worker1 = new Worker(0);
        Worker worker2 = new Worker(1);
        Worker worker3 = new Worker(2);
        Worker worker4 = new Worker(3);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            worker4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(lastIndex + 1);
        System.out.print(" @ ");
    }
}
