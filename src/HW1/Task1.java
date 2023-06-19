package HW1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
      int i = getRandomNumber();
        System.out.println(i);
      int n = getByte(i);
        System.out.println(n);
        multipleNumbers(n, i);
        notAMultipleNumbers(n,i);
    }

    public static int getRandomNumber() {
        int i = new Random().nextInt(2000);
        return i;
    }

    public static int getByte(int i) {
        int n = 0;
        while (i != 1) {
            i >>= 1;
            n++;
        }
        return n;
    }

    public static void multipleNumbers(int n, int i) {
        List<Integer> result = new ArrayList<>();

        while (i<=Short.MAX_VALUE) {
            if (i%n==0){
                result.add(i);
            }
            i++;
        }
        System.out.println(result);
    }

    public static void notAMultipleNumbers(int n, int i) {
        List<Integer> result = new ArrayList<>();

        while (i<=Short.MAX_VALUE) {
            if (i%n!=0){
                result.add(i);
            }
            i++;
        }
        System.out.println(result);
    }
}
