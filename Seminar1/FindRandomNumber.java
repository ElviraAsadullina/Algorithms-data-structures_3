package Seminar1;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

// Этот алгоритм хорошо работает только в отсортированных по порядку структурах.
public class FindRandomNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите верхний диапазон числового отрезка: ");
        int right = in.nextInt();
        int left = 0;
        int x = new Random().nextInt(right);
        int m = new Random().nextInt(right/2);
        int counter = 0;
        while (m != x) {
            counter ++;
            if (x > m) {
                left = m;
                m = (left + right) / 2;
//                m = new Random().nextInt(right - m) + m;
            }
            else if (x < m) {
                right = m;
                m = (left + right) / 2;
//                m = new Random().nextInt(m - left + 1) + left;
            }
            if (m == x) {
                System.out.println("Бинго! Загаданное число: " + x + "\n  Вы угадали:" + m
                        + "\n Операций: " + counter);
                exit(0);
            }
        }
    }
}
