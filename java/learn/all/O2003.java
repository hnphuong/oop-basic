package hnp.project.demoactivemq.test.all;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class O2003 {

    public static void main(String[] args) {
        try {
            File file = new File("DATA.in");
            Scanner scanner = new Scanner(file);

            Map<Integer, Integer> numberCount = new HashMap<>();

            while (scanner.hasNext()) {
                int number = scanner.nextInt();

                numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
            }

            List<Integer> sortedNumbers = new ArrayList<>(numberCount.keySet());
            Collections.sort(sortedNumbers);

            for (int number : sortedNumbers) {
                System.out.println(number + " " + numberCount.get(number));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại!");
        }
    }
}
