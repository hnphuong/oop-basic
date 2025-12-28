package hnp.project.demoactivemq.test.readFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class O2001 {
    public static void main(String[] args) {
        //ClassLoader classLoader = O2001.class.getClassLoader();
        InputStream inputStream = O2001.class.getResourceAsStream("/DATA.in");
        String data = readFromInputStream(inputStream);
        System.out.println(data);
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
