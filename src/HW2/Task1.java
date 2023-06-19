package HW2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Statement;

public class Task1  {
    public static void main(String[] args) throws IOException {
        String first = "select * from students where ";
        String second = "name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null";
        // Task1
        System.out.println(getQuery(first, second));
        //Task2
        String s = readFromFile();
        String result = getStringFromFile(s);
        System.out.println(result);




    }

    public static String getQuery(String first, String second) {

        String[] helper = second
                .replaceAll(":", " ")
                .replaceAll("=", "")
                .replaceAll("\\s", " ")
                .replaceAll(",", "")
                .split(" ");
        StringBuilder builder = new StringBuilder();

        builder.append("'").append(helper[0]).append("' = '").append(helper[1]).append("', ")
                .append(helper[2]).append("' = ").append(helper[3]).append(", ")
                .append(helper[4]).append("' = ").append(helper[5]).append(", ");

        return first + builder ;
    }

    public static String readFromFile() throws IOException {
        String path = "task.txt";
        return Files.readString(Path.of(path));
    }

    public static String getStringFromFile(String string){
        String[] helper = string
                .replaceAll("фамилия", "Студент")
                .replaceAll("предмет", "предмету")
                .replaceAll("оценка", "получил")
                .replaceAll("\\s", "")
                .replaceAll(",", "")
                .replaceAll(":", " ")
                .replaceAll("=", "")
                .replaceAll(",", "")
                .replaceAll("\""," ")
                .replaceAll("^\\{|}|$", "\n")
                .split("\\}: \\{ ");
        String result = "";
        for (int i = 0; i<helper.length; i++) {
            result = result + helper[i];
        }
        return result;
    }


}
