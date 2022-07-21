package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {


//        double timeForBubbleSort = timeForBubbleSort(5);
//        System.out.println("время сортировки пузырьком - " + timeForBubbleSort + "м/с");
//        double timeForSelectionSort = timeForSelectionSort(5);
//        System.out.println("время сортировки выбором - " + timeForSelectionSort + "м/с");
//        double timeForInsertionSort = timeForInsertionSort(5);
//        System.out.println("время сортировки вставкой - " + timeForInsertionSort + "м/с");

        IntegerList testList = new IntegerListImpl(5);
        testList.add(2);
        testList.add(1);
        testList.add(8);
        testList.add(0);
        testList.add(91);
        testList.add(26);
//        testList.add(26);
        System.out.println(Arrays.toString(testList.toArray()));
        System.out.println(testList.contains(0));
        System.out.println(Arrays.toString(testList.toArray()));


    }


    //измерение среднего времени на пузырьковую сортировку
    static double timeForBubbleSort(int iteration) {
        double sum = 0;
        for (int i = 0; i < iteration; i++) {
            int[] array = generateArray(100_000);
            long start = System.currentTimeMillis();
            sortBubble(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }

    //измерение среднего времени на сортировку выбором
    static double timeForSelectionSort(int iteration) {
        double sum = 0;
        for (int i = 0; i < iteration; i++) {
            int[] array = generateArray(100_000);
            long start = System.currentTimeMillis();
            sortSelection(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }


    //измерение среднего времени на сортировку вставкой
    static double timeForInsertionSort(int iteration) {
        double sum = 0;
        for (int i = 0; i < iteration; i++) {
            int[] array = generateArray(100_000);
            long start = System.currentTimeMillis();
            sortSelection(array);
            long end = System.currentTimeMillis() - start;
            sum += end;
        }
        return sum / iteration;
    }



    //генерация массива cлучайными числами
    public static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt();
        }
        return array;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    //Пузырьковая сортировка
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    // сортировка Выбором
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    //Сортирвка вставкой
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    // Линейный поиск

}