package hnp.project.demoactivemq.test.o3016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputInteger(scanner);
        int i = 0;
        List<Gamer> gamers = new ArrayList<>();
        while (n-- > 0) {
            String code = inputString(scanner);
            String name = inputString(scanner);
            String inTime = scanner.nextLine();
            String outTime = scanner.nextLine();
            Gamer gamer = new Gamer(code, name, inTime, outTime);
            gamers.add(gamer);
            i++;
        }
        Collections.sort(gamers);
        for (Gamer gamer : gamers) {
            System.out.println(gamer);
        }
    }

    private static Integer inputInteger(Scanner scanner) {
        int n = 0;
        do {
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                continue;
            }
            n = scanner.nextInt();
            scanner.nextLine();
        } while (n < 0 || n > 20);
        return n;
    }

    private static String inputString(Scanner scanner) {
        String s;
        do {
            s = scanner.nextLine();
        } while (s.length() > 100);
        return s;
    }

    private static String genCode(int i) {
        if (i < 10) return "G00000" + i;
        if (i < 100) return "G0000" + i;
        if (i < 1000) return "G000" + i;
        if (i < 10000) return "G00" + i;
        if (i < 100000) return "G0" + i;
        return "G" + i;
    }
}
