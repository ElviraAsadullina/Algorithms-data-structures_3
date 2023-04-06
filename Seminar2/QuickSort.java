package Seminar2;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        long time = System.nanoTime();
        QuickSort qs = new QuickSort();
        int[] randomArray = new int[] {87, 16, 98, 5, 13, 6, 43};
//        qs.quickSort(randomArray, 0, randomArray.length -1);
        qs.heapSort(randomArray);
        System.out.println(Arrays.toString(randomArray));
        time = System.nanoTime() - time;
        System.out.printf("Код выполнен за: %,9.3f ms\n", time/1_000_000.0);
    }
    public void quickSort(int[] arr, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = arr[(endPos - startPos) / 2 + startPos];
        do {
            while (arr[leftPos] < pivot) {
                leftPos++;
            }
            while (arr[rightPos] > pivot) {
                rightPos--;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = arr[leftPos];
                    arr[leftPos] = arr[rightPos];
                    arr[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);
        if (leftPos < endPos) {
            quickSort(arr, leftPos, endPos);
        }
        if (startPos < rightPos) {
            quickSort(arr, startPos, rightPos);
        }
    }


    public void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализируем наибольший эл-т как корень;
        int leftChild = 2 * rootIndex + 1; // выставляем детей для корня;
        int rightChild = 2 * rootIndex + 2;
        // перетаскиваем в корень наибольший эл-т из кучки корень-дети:
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        // если самый большой эл-т - не корень, то переставляем эл-ты:
        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            // и рекурсивно проверяем тем же образом все кучи ниже:
            heapify(arr, heapSize, largest);
        }
    }
    public void heapSort(int[] arr) {
        // построение кучи (перегруппировка массива):
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        // извлекаем по очереди эл-ты из кучи, перемещаем текущий корень в конец
        // и делаем heapify на уменьшенной куче:
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
}
