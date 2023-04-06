package Seminar2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] randomArray = new int[] {87, 16, 98, 5, 13, 6, 43};
        int[] randArr = new int[] {87, 16, 98, 5, 13, 6, 43};
        Arrays.sort(randomArray);
//        int x = bs.binarySearch(randomArray, randArr, 87);
        int x = bs.recursiveBinarySearch(randomArray, randArr, 0, randomArray.length - 1, 13);
        if (x == -1) {
            System.out.println("Заданное число в массиве не найдено!");
        }
        else {
            System.out.println("Заданное число найдено на позиции " + x);
        }
    }

    public int binarySearch(int[] array, int[] randomArr, int number) {
        int left = 0;
        int right = array.length - 1;
        int middle = (right - left) / 2 + left;
        while (left <= right) {
            if (array[middle] < number) {
                left = middle + 1;
            } else if (array[middle] > number) {
                right = middle - 1;
            } else {
                int i = find(randomArr, array[middle]);
                return i;
            }
            middle = (right - left) / 2 + left;
        }
        return -1;
    }
    public static int find(int[] array, int target)
    {
        return Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(target);
    }
    public int recursiveBinarySearch(int[] array, int[] randomArr, int left, int right, int number) {
        if (left > right) {
            return -1;
        }
        int middle = (right - left) / 2 + left;
        if (array[middle] == number) {
            int i = find(randomArr, array[middle]);
            return i;
        }
        else if (number < array[middle]) {
            return recursiveBinarySearch(array, randomArr, left, middle -1, number);
        }
        else {
            return recursiveBinarySearch(array, randomArr, middle + 1, right, number);
        }
    }
}
