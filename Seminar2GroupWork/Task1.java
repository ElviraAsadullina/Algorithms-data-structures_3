package Seminar2GroupWork;

// 1. Сортировка от O(n^2).
// 2. Реализовать бинарный поиск с рекурсией.
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        long time = System.nanoTime();
        Task1 t = new Task1();
        int[] array = new int[] {8, 19, 3, 89, 2, 19, 233, 3};
        int[] randArr = new int[] {8, 19, 3, 89, 2, 19, 233, 3};
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int)(Math.random() * 10000);
//        }
//        t.bubbleSort(array);
//        System.out.println(Arrays.toString(array));
//        time = System.nanoTime() - time;
//        System.out.printf("Код выполнен за: %,9.3f ms\n", time/1_000_000.0);
        time = System.nanoTime();
        t.quickSort(array, 0, array.length - 1);
        int n = t.recursiveBinarySearch(array, randArr,0, array.length - 1, 233);
        time = System.nanoTime() - time;
        System.out.printf("Код выполнен за: %,9.3f ms\n", time/1_000_000.0);
        System.out.println(Arrays.toString(randArr));
        time = System.nanoTime();


        int x = t.find(array, 19);
        time = System.nanoTime() - time;
        System.out.printf("Код выполнен за: %,9.3f ms\n", time/1_000_000.0);
        if (x == -1) {
            System.out.println("Заданное число в массиве не найдено!");
        }
        else {
            System.out.println("Заданное число найдено на позиции " + x);
        }



    }
    public void bubbleSort(int[] arr) {
        boolean x;
        do {
            x = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = tmp;
                    x = false;
                }
            }
        } while(!x);
    }
    public void quickSort(int[] arr, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = arr[(endPos + startPos) / 2];
        do {
            while (arr[leftPos] < pivot) {
                leftPos ++;
            }
            while (arr[rightPos] > pivot) {
                rightPos --;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int tmp = arr[leftPos];
                    arr[leftPos] = arr[rightPos];
                    arr[rightPos] = tmp;
                }
                leftPos ++;
                rightPos --;
            }
        } while (leftPos <= rightPos);
        if (leftPos < endPos) {
            quickSort(arr, leftPos, endPos);
        }
        if (startPos < rightPos) {
            quickSort(arr, startPos, rightPos);
        }
    }
    public int recursiveBinarySearch(int[] arr,int[] randArr, int left, int right, int number) {
        if (left > right) {
            return -1;
        }
        int middle = (right - left) / 2 + left;
        if (arr[middle] == number) {
            int i = find (randArr, arr[middle]);
            return i;
        }
        if (number < arr[middle]) {
            return recursiveBinarySearch(arr, randArr, left, middle - 1, number);
        }
        else {
            return recursiveBinarySearch(arr, randArr, middle + 1, right, number);
        }
    }
    public int find (int[] arr, int target) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(target);
    }

//    public static int[] quickSort2(int[] arr1, int startPos, int endPos) {
//        int[] arr = new int[arr1.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr1[i];
//        }
//        int leftPos = startPos;
//        int rightPos = endPos;
//        int pivot = arr[(endPos + startPos) / 2];
//        do {
//            while (arr[leftPos] < pivot) {
//                leftPos ++;
//            }
//            while (arr[rightPos] > pivot) {
//                rightPos --;
//            }
//            if (leftPos <= rightPos) {
//                if (leftPos < rightPos) {
//                    int tmp = arr[leftPos];
//                    arr[leftPos] = arr[rightPos];
//                    arr[rightPos] = tmp;
//                }
//                leftPos ++;
//                rightPos --;
//            }
//        } while (leftPos <= rightPos);
//        if (leftPos < endPos) {
//            int[] a = quickSort2(arr, leftPos, endPos);
//        }
//        if (startPos < rightPos) {
//            int[] b = quickSort2(arr, startPos, rightPos);
//        }
//        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
//    }
}
