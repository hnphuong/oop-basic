package hnp.project.demoactivemq.test.all;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class O2004 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("DATA.IN");
            DataInputStream dis = new DataInputStream(fis);
            Map<Integer, Integer> numberCount = new HashMap<>();

            for (int i = 0; i < 100000; i++) {
                int number = dis.readInt();
                numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
            }
            dis.close();
            List<Integer> sortedNumbers = new ArrayList<>(numberCount.keySet());
            Collections.sort(sortedNumbers);
            for (int number : sortedNumbers) {
                System.out.println(number + " " + numberCount.get(number));
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
