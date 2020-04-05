package Lesson5;

import java.util.Arrays;

public class TestThreads {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private synchronized void method1() {
        long a = System.currentTimeMillis();
        double[] arr = new double[size];
        Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        float result = (System.currentTimeMillis() - a) * 0.00000001f;
        System.out.println("Время выполнения метода 1: " + result + " секунд");
    }

    private synchronized void method2() {
        long a = System.currentTimeMillis();
        double[] arr = new double[size];
        double[] a1 = new double[h];
        double[] a2 = new double[h];
        Arrays.fill(arr, 1);

        synchronized (lock1) {
            System.arraycopy(arr, 0, a1, 0, h);
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, h);
        }
        synchronized (lock2) {
            System.arraycopy(arr, h, a2, 0, h);
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, h, h);
        }

        float result = (System.currentTimeMillis() - a) * 0.00000001f;
        System.out.println("Время выполнения метода 2: " + result + " секунд");
    }

    public static void main(String[] args) {
        TestThreads test = new TestThreads();
        System.out.println("Start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();
    }
}