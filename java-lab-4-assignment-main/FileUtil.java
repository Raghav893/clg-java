import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<Student> loadStudents(String file) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                list.add(new Student(
                        Integer.parseInt(s[0]),
                        s[1], s[2], s[3],
                        Double.parseDouble(s[4])));
            }

        } catch (Exception e) {
            System.out.println("No existing file found. Starting fresh.");
        }
        return list;
    }

    public static void saveStudents(String file, List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error writing file.");
        }
    }
}
