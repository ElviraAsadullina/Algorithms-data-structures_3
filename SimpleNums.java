import static java.lang.Math.sqrt;

//# Задание 2 (тайминг 10 минут)
//        Написать алгоритм поиска простых чисел (делятся только на себя и
//        на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
//        вложенный for, что явно говорит о квадратичной сложности, на этом
//        стоит акцентировать внимание
public class SimpleNums {
    public static void main(String[] args) {
//        int n = 10;
//        int count = 0;
//        for (int i = 0; i < n; i++){
//            if (isPrime(i))
//                System.out.println("i = " + i);
//        }
//        long startTime = System.nanoTime();
//        int n1 = fibRec(1000);
//        long endTime = System.nanoTime();
//        System.out.println("time1 = " + (endTime - startTime));
        Long startTime = System.nanoTime();
        int n2 = fibUpp(1000);
        Long endTime = System.nanoTime();
        System.out.println("time2 = " + (endTime - startTime));
    }

    public static Boolean isPrime (Integer num1) {
        if (num1 < 4)
            return num1 > 1;
        if (num1 % 2 == 0 || num1 % 3 == 0)
            return false;
        for (int i = 5; i < sqrt(num1); i+=6) {
            if (num1 % i == 0 || num1 % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static Integer fibRec (Integer num) {
        if (num <= 1) {
            return 0;
        }
        if (num == 2) {
            return 1;
        }
        return fibRec(num - 1) + fibRec(num-2);
    }
    public static Integer fibUpp (Integer num) {
        Integer x = 0;
        Integer x1 = 1;
        Integer x2 = 1;
        for(int i = 3; i < num; i++) {
            x2 = x + x1;
            x = x1;
            x1 = x2;
        }
        return x2;
    }

}


