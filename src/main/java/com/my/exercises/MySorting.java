package com.my.exercises;

import java.util.Arrays;

import static java.util.Arrays.sort;

import java.util.Scanner;

public class MySorting {
    static int counter = 0;

    public static void main(String[] args) {
        int[] m = {3, 5, 10, 2, 7, 1, 11, 7, 4, 8, 2, 0};
        int[] sort = bubbleSort(m);
//        int[] sort = mergeSort(m);
        // int[] sort = insertionSort(m);

        for (int n : sort) {
            System.out.println(n);
        }

        System.out.println("Количество итераций: " + counter);
    }

    public static int[] bubbleSort(int[] unsortedArray) {
        for (int i = 0; i < unsortedArray.length; i++) {
            int num = unsortedArray[i];
            for (int j = i - 1; j >= 0; j--) {
                counter++;
                int leftNum = unsortedArray[j];

                if (num < leftNum) {
                    unsortedArray[j + 1] = leftNum;
                    unsortedArray[j] = num;
                } else {
                    break;
                }
            }
        }
        return unsortedArray;
    }

    //рекурсивная функция сортировки частей массива
    public static int[] mergeSort(int[] unsortedArray) {
        if (unsortedArray.length < 2)
            return unsortedArray;
        int middle = unsortedArray.length / 2;
        int[] arr1 = Arrays.copyOfRange(unsortedArray, 0, middle);
        int[] arr2 = Arrays.copyOfRange(unsortedArray, middle, unsortedArray.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    //слияние двух массивов в один отсортированный
    public static int[] merge(int[] arr1, int arr2[]) {
        int n = arr1.length + arr2.length;
        int[] sortedArray = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            counter++;
            if (i1 == arr1.length) {
                sortedArray[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                sortedArray[i] = arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    sortedArray[i] = arr1[i1++];
                } else {
                    sortedArray[i] = arr2[i2++];
                }
            }
        }
        return sortedArray;
    }

    public static int[] insertionSort(int[] unsortedArray) {
        //пройти по массиву
        //выбираем элемент
        //устнавливаем элемент на законное место
        int element;
        int indexToInsert;
        for (int i = 0; i < unsortedArray.length; i++) {
            element = unsortedArray[i];
            indexToInsert = i;
            while (indexToInsert > 0 && unsortedArray[indexToInsert - 1] > element) {
                counter++;
                unsortedArray[indexToInsert] = unsortedArray[indexToInsert - 1];
                indexToInsert--;
                unsortedArray[indexToInsert] = element;
            }
        }
        return unsortedArray;
    }

}

