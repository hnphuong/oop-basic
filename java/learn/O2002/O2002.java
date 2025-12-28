package hnp.project.demoactivemq.test.O2002;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class O2002 {
    public static void main(String[] args) {
        InputStream inputStream = O2002.class.getResourceAsStream("/DATA.in");
        String data = readFromInputStream(inputStream);
        //System.out.println(data);
        String[] lines = data.split("\\s+");
        Integer sum = 0;
        for (String line : lines) {
            Integer number = convertToInt(line);
            sum += number;
        }
        System.out.println(sum);
    }

    private static Integer convertToInt(String s) {
        try {
            //System.out.println(s);
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    private static String readFromInputStream(InputStream inputStream) {
        try {
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
            }
            return resultStringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
