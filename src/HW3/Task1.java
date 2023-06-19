package HW3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = fillList();
        System.out.println(list);
        List<Integer> firstTask = removeEvenNumbers(list);
        System.out.println(firstTask);
        int min = findMin(list);
        System.out.println(min);
        int max = findMax(list);
        System.out.println(max);
        double average = findAverage(list);
        System.out.println(average);

    }

    public static List<Integer> fillList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<=100; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> removeEvenNumbers(List<Integer> list) {
        List<Integer> result = list.stream().filter(n -> n % 2!=0).toList();
        return result;
    }

    public static int findMin(List<Integer> list) {
        Collections.sort(list);
        return list.get(0);
    }

    public static int findMax(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    public static double findAverage(List<Integer> list) {


        return list.stream().mapToDouble(i->i).average().orElse(0);
    }
}
