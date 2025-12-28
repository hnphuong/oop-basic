package hnp.project.demoactivemq.test.all;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CreateFile {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 1; i < 1000; i++) {
                numbers.add(i);
            }
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(2);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(11);
            numbers.add(997);
            numbers.add(11);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            numbers.add(997);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SONGUYEN.in"));
            oos.writeObject(numbers);
            oos.close();
            System.out.println("File SONGUYEN.in đã được tạo thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
