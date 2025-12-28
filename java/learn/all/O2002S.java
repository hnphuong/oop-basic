package hnp.project.demoactivemq.test.all;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class O2002S {
    public static void main(String[] args) {
        try {
            File file = new File("DATA.in");
            Scanner scanner = new Scanner(file);
            long sum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("[^0-9-]+");
                for (String token : tokens) {
                    if (token.isEmpty()) continue;

                    try {
                        long number = Long.parseLong(token);
                        sum += number;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            System.out.println(sum);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại!");
        }
    }
}
