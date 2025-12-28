package hnp.project.demoactivemq.test.all;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/phuonghn/workspace/free/test-code/demo-activemq/src/main/java/hnp/project/demoactivemq/test/DATA.in"));
        while (in.hasNext()) {
            System.out.println(in.next());
        }
        in.close();
    }
}
