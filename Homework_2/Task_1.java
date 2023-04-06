package Homework_2;

import Seminar2.QuickSort;

import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args) {
        long time = System.nanoTime();
        QuickSort qs = new QuickSort();
        int[] myArray = new int[] {87, 665, 16, 98, 5, 13, 6, 43, 1, 99};
        qs.heapSort(myArray);
        System.out.println(Arrays.toString(myArray));
        time = System.nanoTime() - time;
        System.out.printf("Код выполнен за: %,9.3f ms\n", time/1_000_000.0);
    }

    public void heapSort(int[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heaping(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heaping(arr, i, 0);
        }
    }
    public void heaping(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            heaping(arr, heapSize, largest);
        }
    }
}
