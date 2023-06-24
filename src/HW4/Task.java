package HW4;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Task {

    public static void main(String[] args) {
    //Task1 Организовать ввод и хранение данных пользователей. ФИО возраст и пол
    // Task 2 вывод в формате Фамилия И.О. возраст пол выделена в отдельный метод
    // printList

        List<String[]> persons = new ArrayList<>();
        System.out.println("Введите данные в формате ФИО, возраст, пол: ");
        while (true) {
            String info = input.nextLine();
            if (info.equals("q")) break;
            persons.add(info.split(" "));
        }
        Task.printList(persons);
        // Task 3 добавить возможность выхода или вывода списка отсортированного по возрасту!)
        System.out.println("Введите q для выхода или любую другую для сортировки: ");
        String nextTask = input.nextLine();
        if (nextTask.equals("q")) {
            System.exit(0);
        } else {
            persons.sort(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]) ;
                }
            });
            Task.printList(persons);
        }
        // Task 4 *реализовать сортировку по возрасту с использованием индексов
        List<String> surname = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<String> middleName = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<String> gender = new ArrayList<>();

        for (String[] person : persons) {
            surname.add(person[0]);
            name.add(person[1]);
            middleName.add(person[2]);
            age.add(Integer.parseInt(person[3]));
            gender.add(person[4]);
        }

        List<Integer> idx = new ArrayList<>();
        List<Integer> helper = age.stream().sorted().toList();
        for (int i = 0; i< helper.size(); i++) {
            for (int j = 0; j< age.size(); j++) {
                if (helper.get(i).equals(age.get(j))) {
                    idx.add(j);

                }
            }
        }

        Task.printListMod(surname, name, middleName,
                age, gender, idx);


        // Task 5 *реализовать сортировку по возрасту и полу с использованием индексов
        List<Integer> result = new ArrayList<>();
        List<Integer> women = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        List<Integer> helper2 = age.stream().sorted().toList();
        for (int i = 0; i< helper2.size(); i++) {
            for (int j = 0; j< age.size(); j++) {
                if (helper.get(i).equals(age.get(j))) {
                    index.add(j);
                    }
                }
            }
        for (int i = 0; i<index.size(); i++) {
            for (int j = 0; j<gender.size(); j++){
                if (gender.get(index.get(i)).equalsIgnoreCase("м")){
                    result.add(index.get(i));
                }
            }
        }

        System.out.println(result);




    }
    // Task 2 вывод в формате Фамилия И.О. возраст пол
    static Scanner input = new Scanner(System.in);
    public static void printList(List<String[]> persons) {
        for (String[] person : persons) {
            System.out.printf("%s %s. %s. %s %s\n",
                    person[0],
                    person[1].toUpperCase().charAt(0),
                    person[2].toUpperCase().charAt(0),
                    person[3],
                    person[4]);
        }
    }

    public static void printListMod(List<String> surname,
                                    List<String> name,
                                    List<String> middleName,
                                    List<Integer> age,
                                    List<String> gender,
                                    List<Integer> idx) {
        for (int  i : idx) {
            System.out.printf("%s %s. %s. %s %s\n",
                    surname.get(idx.get(i)),
                    name.get(idx.get(i)),
                    middleName.get(idx.get(i)),
                    age.get(idx.get(i)),
                    gender.get(idx.get(i)));
        }
    }

}
// Петров Пётр Петрович 42 м
// Сидоров Сидор Сидорович 22 м
// Евгеньева Евгения Евгеньевна 56 ж
// Александрова Александра Александровна 12 ж